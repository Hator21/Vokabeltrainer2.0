package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Components.TransparentButton;
import Components.TransparentLabel;
import Trainer.Language;
import Trainer.Vokabel;

@SuppressWarnings("serial")
public class EditSPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private JTable				table;
	DefaultTableModel			tableModel;
	int							nr			= 1;
	private TransparentButton	addSpeech, deleteSpeech, addLection, deleteLection, addVocabel, deleteVocabel, editVocabel;
	private TransparentLabel	selectSpeech, selectLection;
	JComboBox<String>			lectionsCB, languageCB;
	JPanel						vocabellistPanel, vocabelPanel, speechPanel, lectionPanel;
	JScrollPane					scrollPane;
	private String[]			columnNames	= {
			"Nr.", "Sprache1", "Sprache2", "Gelernt x-mal", "Richtig (%)"
	};

	private String				pr�1;
	private String				pr�2;
	private addLanguage			addL;
	private addLection			addLe;
	private addVocabel			addVoc;
	private ArrayList<String>	lections	= new ArrayList<String>();
	ArrayList<String>			languages	= new ArrayList<String>();
	private ArrayList<Vokabel>	vocabellist	= new ArrayList<Vokabel>();

	public EditSPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		addL = new addLanguage();
		setAddLe(new addLection());
		add2Language();
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-wei�.png"));
		} catch (IOException ex) {}

		vocabelPanel = new JPanel();
		vocabelPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Vokabel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		vocabelPanel.setBounds(688, 11, 330, 190);
		add(vocabelPanel);
		vocabelPanel.setLayout(null);

		setAddVocabel(TransparentButton.createButton("Vokabel anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			String language = ((String) (languageCB.getSelectedItem()));
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			pr�1 = getPr�fix1(lang1);
			pr�2 = getPr�fix2(lang2);
			addVoc = new addVocabel(lang1, lang2);
			int s = JOptionPane.showConfirmDialog(null, addVoc.getInputs(), "Vokabel anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!addVoc.getAddVocabelOLTF().getText().equals("") && !addVoc.getAddVocabelDLTF().getText().equals("")) {
					nr++;
					int lectionNR = Integer.parseInt(lectionsCB.getSelectedItem().toString().split(" ")[1]);
					frame.getVokabeln().add(new Vokabel(pr�1, pr�2, addVoc.getAddVocabelOLTF().getText(), addVoc.getAddVocabelDLTF().getText(), lectionNR, 0, 0, false));
					loadTable();
					for (Vokabel v : frame.getVokabeln())
						System.out.println(v.toString());
				}
			}
		}), vocabelPanel));

		setDeleteVocabel(TransparentButton.createButton("Vokabel l�schen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int row = table.getSelectedRow();
			frame.getVokabeln().remove(getVocabelFromTable(row));
			loadTable();
		}), vocabelPanel));

		setEditVocabel(TransparentButton.createButton("Vokabel �ndern", 36, 87, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			String language = ((String) (languageCB.getSelectedItem()));
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			int row = table.getSelectedRow();
			int index = getVocabelFromTable(row);
			Vokabel voc = frame.getVokabeln().get(index);
			System.out.println(voc.getVocabOrigin());
			System.err.println("->" + index);
			addVoc = new addVocabel(lang1, lang2);
			addVoc.getAddVocabelOLTF().setText(voc.getVocabOrigin());
			addVoc.getAddVocabelDLTF().setText(voc.getVocabTranslation());
			int s = JOptionPane.showConfirmDialog(null, addVoc.getInputs(), "Vokabel �ndern", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!addVoc.getAddVocabelOLTF().getText().equals("") && !addVoc.getAddVocabelDLTF().getText().equals("")) {
					frame.getVokabeln().get(index).setVocabOrigin(addVoc.getAddVocabelOLTF().getText());
					frame.getVokabeln().get(index).setVocabTranslation(addVoc.getAddVocabelDLTF().getText());
				}
			}
			loadTable();
		}), vocabelPanel));

		lectionPanel = new JPanel();
		lectionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Lektion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lectionPanel.setBounds(348, 11, 330, 190);
		add(lectionPanel);
		lectionPanel.setLayout(null);

		setAddLection(TransparentButton.createButton("Lektion anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int s = JOptionPane.showConfirmDialog(null, addLe.getInputs(), "Lektion anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!addLe.getAddLanguage1TF().getText().equals("")) {
					lectionsCB.setModel(new DefaultComboBoxModel<String>(add2Lection(addLe.getAddLanguage1TF().getText())));
				}
			}
			createLectionList();
			loadTable();
		}), lectionPanel));

		setDeleteLection(TransparentButton.createButton("Lektion l�schen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int lection = Integer.parseInt(lectionsCB.getSelectedItem().toString().split(" ")[1]);
			putPr�fix();
			Iterator<Vokabel> it = frame.getVokabeln().iterator();
			while (it.hasNext()) {
				Vokabel voc = it.next();
				if (voc.getCountryOriginCode().equals(pr�1) && voc.getCountryDistinationCode().equals(pr�2) && voc.getLection() == lection)
					it.remove();
			}
			createLectionList();
			loadTable();
		}), lectionPanel));

		lectionsCB = new JComboBox<String>();
		lectionsCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lectionsCB.setSelectedIndex(-1);
		lectionsCB.setBounds(36, 127, 248, 29);
		lectionPanel.add(lectionsCB);
		lectionsCB.setModel(new DefaultComboBoxModel<String>(lections.toArray(new String[lections.size()])));
		lectionsCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});

		setSelectLection(TransparentLabel.createLabel("Lektion ausw�hlen", 36, 87, 248, 29, 20, lectionPanel));

		speechPanel = new JPanel();
		speechPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Sprache", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		speechPanel.setBounds(8, 11, 330, 190);
		add(speechPanel);
		speechPanel.setLayout(null);

		setAddSpeech(TransparentButton.createButton("Sprache anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int s = JOptionPane.showConfirmDialog(null, addL.getInputs(), "Sprache anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!addL.getAddLanguage1TF().getText().equals("") && !addL.getAddLanguage2TF().getText().equals("") && !addL.getAddPr�fix1TF().getText().equals("") && !addL.getAddPr�fix2TF().getText().equals("")) {
					frame.getLanguageCombi().put(new Language(addL.getAddPr�fix1TF().getText(), addL.getAddLanguage1TF().getText()), new Language(addL.getAddPr�fix2TF().getText(), addL.getAddLanguage2TF().getText()));
					languageCB.setModel(new DefaultComboBoxModel<String>(add2Language()));
				}
			}
			createLectionList();
			loadTable();
		}), speechPanel));

		setDeleteSpeech(TransparentButton.createButton("Sprache l�schen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			String language = languageCB.getSelectedItem().toString();
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			pr�1 = getPr�fix1(lang1);
			pr�2 = getPr�fix2(lang2);
			Iterator<Vokabel> it = frame.getVokabeln().iterator();
			while (it.hasNext()) {
				Vokabel voc = it.next();
				if (voc.getCountryOriginCode().equals(pr�1) && voc.getCountryDistinationCode().equals(pr�2))
					it.remove();
			}
			for (Language key : frame.getLanguageCombi().keySet()) {
				if (key.getLanguage().equals(lang1) && frame.getLanguageCombi().get(key).getLanguage().equals(lang2)) {
					frame.getLanguageCombi().remove(key);
					break;
				}
			}
			languageCB.removeItem(language);
			createLectionList();
			loadTable();
		}), speechPanel));

		languageCB = new JComboBox<String>();
		languageCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		languageCB.setSelectedIndex(-1);
		languageCB.setBounds(36, 127, 248, 29);
		speechPanel.add(languageCB);
		languageCB.setModel(new DefaultComboBoxModel<String>(add2Language()));
		languageCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLectionList();
				loadTable();
			}
		});
		createLectionList();

		setSelectLection(TransparentLabel.createLabel("Sprache ausw�hlen", 36, 87, 248, 29, 20, speechPanel));

		vocabellistPanel = new JPanel();
		vocabellistPanel.setLayout(new GridLayout(1, 0));
		vocabellistPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		vocabellistPanel.setBounds(8, 212, 1010, 421);
		add(vocabellistPanel);

		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(1).setPreferredWidth(370);
		table.getColumnModel().getColumn(2).setPreferredWidth(370);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		table.getColumnModel().getColumn(4).setPreferredWidth(111);
		scrollPane = new JScrollPane(table);
		vocabellistPanel.add(scrollPane);

	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public void loadTable() {
		nr = 1;
		int correct;
		tableModel.setRowCount(0);
		putPr�fix();
		if (pr�1 != null && pr�2 != null) {
			for (int i = 0; i < frame.getVokabeln().size(); i++) {
				if (frame.getVokabeln().get(i).getCountryOriginCode().equals(pr�1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(pr�2)) {
					if (lectionsCB.getItemCount() != 0) {
						if (((String) (lectionsCB.getSelectedItem())).startsWith("Lektion ")) {
							int x = Integer.valueOf(((String) (lectionsCB.getSelectedItem())).split(" ")[1]);
							if (frame.getVokabeln().get(i).getLection() == x) {

								String originalLanguage = frame.getVokabeln().get(i).getVocabOrigin();
								String destinationLanguage = frame.getVokabeln().get(i).getVocabTranslation();
								int learned = frame.getVokabeln().get(i).getTested();
								if (frame.getVokabeln().get(i).getCorrect() == 0 || frame.getVokabeln().get(i).getTested() == 0) {
									correct = 0;
								} else {
									double correctD = frame.getVokabeln().get(i).getCorrect() * 100 / frame.getVokabeln().get(i).getTested();
									correct = (int) correctD;
								}

								Object[] data = {
										nr, originalLanguage, destinationLanguage, learned, correct
								};
								nr++;
								vocabellist.add(new Vokabel(pr�1, pr�2, originalLanguage, destinationLanguage, x, learned, correct, frame.getVokabeln().get(i).getUsed()));
								tableModel.addRow(data);
							}
						}
					}
				}
			}
		}
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentButton getAddSpeech() {
		return addSpeech;
	}

	public void setAddSpeech(TransparentButton addSpeech) {
		this.addSpeech = addSpeech;
	}

	public TransparentButton getDeleteSpeech() {
		return deleteSpeech;
	}

	public void setDeleteSpeech(TransparentButton deleteSpeech) {
		this.deleteSpeech = deleteSpeech;
	}

	public TransparentButton getAddLection() {
		return addLection;
	}

	public void setAddLection(TransparentButton addLection) {
		this.addLection = addLection;
	}

	public TransparentButton getDeleteLection() {
		return deleteLection;
	}

	public void setDeleteLection(TransparentButton deleteLection) {
		this.deleteLection = deleteLection;
	}

	public TransparentButton getAddVocabel() {
		return addVocabel;
	}

	public void setAddVocabel(TransparentButton addVocabel) {
		this.addVocabel = addVocabel;
	}

	public TransparentButton getDeleteVocabel() {
		return deleteVocabel;
	}

	public void setDeleteVocabel(TransparentButton deleteVocabel) {
		this.deleteVocabel = deleteVocabel;
	}

	public TransparentButton getEditVocabel() {
		return editVocabel;
	}

	public void setEditVocabel(TransparentButton editVocabel) {
		this.editVocabel = editVocabel;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public TransparentLabel getSelectSpeech() {
		return selectSpeech;
	}

	public void setSelectSpeech(TransparentLabel selectSpeech) {
		this.selectSpeech = selectSpeech;
	}

	public TransparentLabel getSelectLection() {
		return selectLection;
	}

	public void setSelectLection(TransparentLabel selectLection) {
		this.selectLection = selectLection;
	}

	public String[] add2Language() {
		boolean b = false;
		for (Language s : frame.getLanguageCombi().keySet()) {
			Language t = frame.getLanguageCombi().get(s);
			if (languages.size() != 0) {
				for (String st : languages)
					if ((s.getLanguage() + "-" + t.getLanguage()).equals(st) || (t.getLanguage() + "-" + s.getLanguage()).equals(st))
						b = true;
				if (b == false)
					languages.add(s.getLanguage() + "-" + t.getLanguage());
				b = false;
			} else
				languages.add(s.getLanguage() + "-" + t.getLanguage());
		}

		return (String[]) languages.toArray(new String[languages.size()]);
	}

	public String[] add2Lection(String lection) {
		boolean b = false;
		for (String s : lections)
			if (lection.equals(s))
				b = true;
		if (b == false)
			lections.add(lection);
		return (String[]) (lections.toArray(new String[lections.size()]));
	}

	public addLection getAddLe() {
		return addLe;
	}

	public void setAddLe(addLection addLe) {
		this.addLe = addLe;
	}

	public String getPr�fix1(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang))
				pr�1 = key.getPr�fix();
		}
		return pr�1;
	}

	public String getPr�fix2(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (frame.getLanguageCombi().get(key).getLanguage().equals(lang))
				pr�2 = frame.getLanguageCombi().get(key).getPr�fix();
		}
		return pr�2;
	}

	public void createLectionList() {
		lections.clear();
		putPr�fix();
		lections.addAll(frame.getBear().getLektionList(pr�1, pr�2));
		lections.sort(null);
		lectionsCB.setModel(new DefaultComboBoxModel<String>(lections.toArray(new String[lections.size()])));
	}

	public int getVocabelFromTable(int row) {
		int index = 0;
		int lection = Integer.parseInt(lectionsCB.getSelectedItem().toString().split(" ")[1]);
		putPr�fix();
		String original = (String) table.getModel().getValueAt(row, 1);
		String destination = (String) table.getModel().getValueAt(row, 2);
		int gelernt = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
		for (int i = 0; i < frame.getVokabeln().size(); i++) {
			if (frame.getVokabeln().get(i).getCountryOriginCode().equals(pr�1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(pr�2) && frame.getVokabeln().get(i).getLection() == lection && frame.getVokabeln().get(i).getVocabOrigin().equals(original) && frame.getVokabeln().get(i).getVocabTranslation().equals(destination) && frame.getVokabeln().get(i).getTested() == gelernt) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void putPr�fix() {
		String language = languageCB.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		pr�1 = getPr�fix1(lang1);
		pr�2 = getPr�fix2(lang2);
	}

}
