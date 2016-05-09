package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
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

	private String				prä1;
	private String				prä2;
	private addLanguage			addL;
	private addLection			addLe;

	public EditSPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		addL = new addLanguage();
		setAddLe(new addLection());
		add2Language();
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiß.png"));
		} catch (IOException ex) {}

		vocabelPanel = new JPanel();
		vocabelPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Vokabel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		vocabelPanel.setBounds(688, 11, 330, 190);
		add(vocabelPanel);
		vocabelPanel.setLayout(null);

		setAddVocabel(TransparentButton.createButton("Vokabel anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), vocabelPanel));
		setDeleteVocabel(TransparentButton.createButton("Vokabel löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), vocabelPanel));
		setEditVocabel(TransparentButton.createButton("Vokabel ändern", 36, 87, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

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
				} else
					System.out.println("nein");
			}
		}), lectionPanel));
		setDeleteLection(TransparentButton.createButton("Lektion löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), lectionPanel));

		lectionsCB = new JComboBox<String>();
		lectionsCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lectionsCB.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Lektion 1", "Lektion 2", "Lektion 3", "Lektion 4", "Lektion 5", "Lektion 6", "Lektion 7", "Lektion 8", "Lektion 9", "Lektion 10", "Lektion 11"
		}));
		lectionsCB.setSelectedIndex(0);
		lectionsCB.setBounds(36, 127, 248, 29);
		lectionPanel.add(lectionsCB);

		setSelectLection(TransparentLabel.createLabel("Lektion auswählen", 36, 87, 248, 29, 20, lectionPanel));

		speechPanel = new JPanel();
		speechPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Sprache", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		speechPanel.setBounds(8, 11, 330, 190);
		add(speechPanel);
		speechPanel.setLayout(null);

		setAddSpeech(TransparentButton.createButton("Sprache anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int s = JOptionPane.showConfirmDialog(null, addL.getInputs(), "Sprache anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!addL.getAddLanguage1TF().getText().equals("") && !addL.getAddLanguage2TF().getText().equals("") && !addL.getAddPräfix1TF().getText().equals("") && !addL.getAddPräfix2TF().getText().equals("")) {
					frame.getLanguageCombi().put(new Language(addL.getAddPräfix1TF().getText(), addL.getAddLanguage1TF().getText()), new Language(addL.getAddPräfix2TF().getText(), addL.getAddLanguage2TF().getText()));
					languageCB.setModel(new DefaultComboBoxModel<String>(add2Language()));
				} else
					System.out.println("nein");
			}
		}), speechPanel));
		setDeleteSpeech(TransparentButton.createButton("Sprache löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), speechPanel));

		languageCB = new JComboBox<String>();
		languageCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		languageCB.setSelectedIndex(-1);
		languageCB.setBounds(36, 127, 248, 29);
		speechPanel.add(languageCB);
		languageCB.setModel(new DefaultComboBoxModel<String>(add2Language()));

		setSelectLection(TransparentLabel.createLabel("Sprache auswählen", 36, 87, 248, 29, 20, speechPanel));

		vocabellistPanel = new JPanel();
		vocabellistPanel.setLayout(new GridLayout(1, 0));
		vocabellistPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		vocabellistPanel.setBounds(8, 212, 1010, 421);
		add(vocabellistPanel);

		tableModel = new DefaultTableModel(columnNames, (nr - 1));
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
		String language = ((String) (languageCB.getSelectedItem()));
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang1))
				prä1 = frame.getLanguageCombi().get(key).getPräfix();
			if (key.getLanguage().equals(lang2))
				prä2 = frame.getLanguageCombi().get(key).getPräfix();
		}
		if (prä1 != null && prä2 != null) {
			for (int i = 0; i < frame.getVokabeln().size(); i++) {
				if (frame.getVokabeln().get(i).getCountryOriginCode() == prä1 && frame.getVokabeln().get(i).getCountryDistinationCode() == prä2) {
					if (((String) (lectionsCB.getSelectedItem())).startsWith("Lektion ")) {
						int x = Integer.valueOf(((String) (lectionsCB.getSelectedItem())).split(" ")[1]);
						if (frame.getVokabeln().get(i).getLection() == x) {

							String originalLanguage = frame.getVokabeln().get(i).getVocabOrigin();
							String destinationLanguage = frame.getVokabeln().get(i).getVocabTranslation();
							int learned = frame.getVokabeln().get(i).getTested();
							int correct = frame.getVokabeln().get(i).getCorrect() / frame.getVokabeln().get(i).getTested() * 100;

							Object[] data = {
									nr, originalLanguage, destinationLanguage, learned, correct
							};
							tableModel.addRow(data);
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
		ArrayList<String> languageComponents = new ArrayList<String>();
		boolean b = false;
		for (Language s : frame.getLanguageCombi().keySet()) {
			Language t = frame.getLanguageCombi().get(s);
			if (languageComponents.size() != 0) {
				for (String st : languageComponents)
					if ((s.getLanguage() + "-" + t.getLanguage()).equals(st) || (t.getLanguage() + "-" + s.getLanguage()).equals(st))
						b = true;
				if (b == false)
					languageComponents.add(s.getLanguage() + "-" + t.getLanguage());
				b = false;
			} else
				languageComponents.add(s.getLanguage() + "-" + t.getLanguage());
		}

		return (String[]) languageComponents.toArray(new String[languageComponents.size()]);
	}
	public String[] add2Lection(String lection){
		ArrayList<String> lectionComponents = new ArrayList<String>();
		boolean b = false;
		for(int i = 0; i <lectionsCB.getItemCount(); i++)
			if(lection.equals(lectionsCB.getItemAt(i)))
				b = true;
		if(b == false)
			lectionsCB.addItem(lection);
		return (String[])(lectionComponents.toArray(new String[lectionComponents.size()]));
	}

	public addLection getAddLe() {
		return addLe;
	}

	public void setAddLe(addLection addLe) {
		this.addLe = addLe;
	}

}
