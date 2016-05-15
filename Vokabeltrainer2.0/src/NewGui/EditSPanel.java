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
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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

	private String				prä1;
	private String				prä2;
	private addLanguage			addL;
	private addLection			addLe;
	private addVocabel			addVoc;
	private ArrayList<String>	lections	= new ArrayList<String>();
	private ArrayList<Vokabel>	vocabellist	= new ArrayList<Vokabel>();

	/**
	 * create the frame of the SpeachEdit Pannel
	 *
	 * @param frame
	 */
	public EditSPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		this.addL = new addLanguage();
		this.setAddLe(new addLection());
		frame.add2Language();
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiß.png"));
		} catch (IOException ex) {}

		this.vocabelPanel = new JPanel();
		this.vocabelPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Vokabel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.vocabelPanel.setBounds(688, 11, 330, 190);
		this.add(this.vocabelPanel);
		this.vocabelPanel.setLayout(null);

		this.setAddVocabel(TransparentButton.createButton("Vokabel anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			String language = ((String) (this.languageCB.getSelectedItem()));
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			this.prä1 = this.getPräfix1(lang1);
			this.prä2 = this.getPräfix2(lang2);
			this.addVoc = new addVocabel(lang1, lang2);
			int s = JOptionPane.showConfirmDialog(null, this.addVoc.getInputs(), "Vokabel anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!this.addVoc.getAddVocabelOLTF().getText().equals("") && !this.addVoc.getAddVocabelDLTF().getText().equals("")) {
					this.nr++;
					int lectionNR = Integer.parseInt(this.lectionsCB.getSelectedItem().toString().split(" ")[1]);
					frame.getVokabeln().add(new Vokabel(this.prä1, this.prä2, this.addVoc.getAddVocabelOLTF().getText(), this.addVoc.getAddVocabelDLTF().getText(), lectionNR, 0, 0, false));
					this.loadTable();
					for (Vokabel v : frame.getVokabeln()) {
						System.out.println(v.toString());
					}
				}
			}
		}), this.vocabelPanel));

		this.setDeleteVocabel(TransparentButton.createButton("Vokabel löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			if (this.languageCB.getSelectedIndex() == 0) {
				return;
			}
			int row = this.table.getSelectedRow();
			frame.getVokabeln().remove(this.getVocabelFromTable(row));
			this.loadTable();
		}), this.vocabelPanel));

		this.setEditVocabel(TransparentButton.createButton("Vokabel ändern", 36, 87, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			if (this.languageCB.getSelectedIndex() == 0) {
				return;
			}
			String language = ((String) (this.languageCB.getSelectedItem()));
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			int row = this.table.getSelectedRow();
			int index = this.getVocabelFromTable(row);
			Vokabel voc = frame.getVokabeln().get(index);
			System.out.println(voc.getVocabOrigin());
			System.err.println("->" + index);
			this.addVoc = new addVocabel(lang1, lang2);
			this.addVoc.getAddVocabelOLTF().setText(voc.getVocabOrigin());
			this.addVoc.getAddVocabelDLTF().setText(voc.getVocabTranslation());
			int s = JOptionPane.showConfirmDialog(null, this.addVoc.getInputs(), "Vokabel ändern", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!this.addVoc.getAddVocabelOLTF().getText().equals("") && !this.addVoc.getAddVocabelDLTF().getText().equals("")) {
					frame.getVokabeln().get(index).setVocabOrigin(this.addVoc.getAddVocabelOLTF().getText());
					frame.getVokabeln().get(index).setVocabTranslation(this.addVoc.getAddVocabelDLTF().getText());
				}
			}
			this.loadTable();
		}), this.vocabelPanel));

		this.lectionPanel = new JPanel();
		this.lectionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Lektion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.lectionPanel.setBounds(348, 11, 330, 190);
		this.add(this.lectionPanel);
		this.lectionPanel.setLayout(null);

		this.setAddLection(TransparentButton.createButton("Lektion anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int s = JOptionPane.showConfirmDialog(null, this.addLe.getInputs(), "Lektion anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!this.addLe.getAddLanguage1TF().getText().equals("")) {
					this.lectionsCB.setModel(new DefaultComboBoxModel<String>(this.add2Lection(this.addLe.getAddLanguage1TF().getText())));
				}
			}
			this.loadTable();
		}), this.lectionPanel));

		this.setDeleteLection(TransparentButton.createButton("Lektion löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int lection = Integer.parseInt(this.lectionsCB.getSelectedItem().toString().split(" ")[1]);
			this.putPräfix();
			Iterator<Vokabel> it = frame.getVokabeln().iterator();
			while (it.hasNext()) {
				Vokabel voc = it.next();
				if (voc.getCountryOriginCode().equals(this.prä1) && voc.getCountryDistinationCode().equals(this.prä2) && (voc.getLection() == lection)) {
					it.remove();
				}
			}
			this.createLectionList();
			this.loadTable();
		}), this.lectionPanel));

		this.lectionsCB = new JComboBox<String>();
		this.lectionsCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.lectionsCB.setSelectedIndex(-1);
		this.lectionsCB.setBounds(36, 127, 248, 29);
		this.lectionPanel.add(this.lectionsCB);
		this.lectionsCB.setModel(new DefaultComboBoxModel<String>(this.lections.toArray(new String[this.lections.size()])));
		this.lectionsCB.addActionListener(e -> EditSPanel.this.loadTable());

		this.setSelectLection(TransparentLabel.createLabel("Lektion auswählen", 36, 87, 248, 29, 20, this.lectionPanel));

		this.speechPanel = new JPanel();
		this.speechPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Sprache", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.speechPanel.setBounds(8, 11, 330, 190);
		this.add(this.speechPanel);
		this.speechPanel.setLayout(null);

		this.setAddSpeech(TransparentButton.createButton("Sprache anlegen", 36, 19, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			int s = JOptionPane.showConfirmDialog(null, this.addL.getInputs(), "Sprache anlegen", JOptionPane.PLAIN_MESSAGE);
			if (s == JOptionPane.OK_OPTION) {
				if (!this.addL.getAddLanguage1TF().getText().equals("") && !this.addL.getAddLanguage2TF().getText().equals("") && !this.addL.getAddPräfix1TF().getText().equals("") && !this.addL.getAddPräfix2TF().getText().equals("")) {
					frame.getLanguageCombi().put(new Language(this.addL.getAddPräfix1TF().getText(), this.addL.getAddLanguage1TF().getText()), new Language(this.addL.getAddPräfix2TF().getText(), this.addL.getAddLanguage2TF().getText()));
					this.languageCB.setModel(new DefaultComboBoxModel<String>(frame.add2Language()));
				}
			}
			this.createLectionList();
			this.loadTable();
		}), this.speechPanel));

		this.setDeleteSpeech(TransparentButton.createButton("Sprache löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {
			String language = this.languageCB.getSelectedItem().toString();
			String lang1 = language.split("-")[0];
			String lang2 = language.split("-")[1];
			this.prä1 = this.getPräfix1(lang1);
			this.prä2 = this.getPräfix2(lang2);
			Iterator<Vokabel> it = frame.getVokabeln().iterator();
			while (it.hasNext()) {
				Vokabel voc = it.next();
				if (voc.getCountryOriginCode().equals(this.prä1) && voc.getCountryDistinationCode().equals(this.prä2)) {
					it.remove();
				}
			}
			for (Language key : frame.getLanguageCombi().keySet()) {
				if (key.getLanguage().equals(lang1) && frame.getLanguageCombi().get(key).getLanguage().equals(lang2)) {
					frame.getLanguageCombi().remove(key);
					break;
				}
			}
			this.languageCB.removeItem(language);
			this.createLectionList();
			this.loadTable();
		}), this.speechPanel));

		this.languageCB = new JComboBox<String>();
		this.languageCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.languageCB.setSelectedIndex(-1);
		this.languageCB.setBounds(36, 127, 248, 29);
		this.speechPanel.add(this.languageCB);
		this.languageCB.setModel(new DefaultComboBoxModel<String>(frame.add2Language()));
		this.languageCB.addActionListener(e -> {
			EditSPanel.this.createLectionList();
			EditSPanel.this.loadTable();
		});
		this.createLectionList();

		this.setSelectLection(TransparentLabel.createLabel("Sprache auswählen", 36, 87, 248, 29, 20, this.speechPanel));

		this.vocabellistPanel = new JPanel();
		this.vocabellistPanel.setLayout(new GridLayout(1, 0));
		this.vocabellistPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.vocabellistPanel.setBounds(8, 212, 1010, 421);
		this.add(this.vocabellistPanel);

		this.tableModel = new CustomTableModel(this.columnNames, 0);

		this.table = new JTable(this.tableModel);
		this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(39);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(370);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(370);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(111);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(111);
		this.scrollPane = new JScrollPane(this.table);
		this.vocabellistPanel.add(this.scrollPane);
	}

	/**
	 * 
	 * Set the settings for the tabel
	 *
	 */
	private static class CustomTableModel extends DefaultTableModel {
		/**
		 * the constructor of the tabel
		 * 
		 * @param a
		 * @param b
		 */
		public CustomTableModel(String[] a, int b) {
			super(a, b);
		}

		/**
		 * sets all Cell Editables to false
		 */
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	/**
	 * painting setings for
	 */
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
		this.nr = 1;
		int correct;
		this.tableModel.setRowCount(0);
		this.putPräfix();
		if ((this.prä1 != null) && (this.prä2 != null)) {
			for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
				if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(this.prä1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(this.prä2)) {
					if (this.lectionsCB.getItemCount() != 0) {
						if (((String) (this.lectionsCB.getSelectedItem())).startsWith("Lektion ")) {
							int x = Integer.valueOf(((String) (this.lectionsCB.getSelectedItem())).split(" ")[1]);
							if (this.frame.getVokabeln().get(i).getLection() == x) {

								String originalLanguage = this.frame.getVokabeln().get(i).getVocabOrigin();
								String destinationLanguage = this.frame.getVokabeln().get(i).getVocabTranslation();
								int learned = this.frame.getVokabeln().get(i).getTested();
								if ((this.frame.getVokabeln().get(i).getCorrect() == 0) || (this.frame.getVokabeln().get(i).getTested() == 0)) {
									correct = 0;
								} else {
									double correctD = (this.frame.getVokabeln().get(i).getCorrect() * 100) / this.frame.getVokabeln().get(i).getTested();
									correct = (int) correctD;
								}

								Object[] data = {
										this.nr, originalLanguage, destinationLanguage, learned, correct
								};
								this.nr++;
								this.vocabellist.add(new Vokabel(this.prä1, this.prä2, originalLanguage, destinationLanguage, x, learned, correct, this.frame.getVokabeln().get(i).getUsed()));
								this.tableModel.addRow(data);
							}
						}
					}
				}
			}
		}
	}

	public String[] add2Lection(String lection) {
		System.out.println("Lections before");
		System.out.println(this.lections.toString());
		boolean b = false;
		for (String s : this.lections) {
			if (lection.equals(s)) {
				b = true;
			}
		}
		if (b == false) {
			this.lections.add(lection);
		}
		String[] arr = new String[this.lections.size()];
		arr = this.lections.toArray(arr);
		System.out.println("Lections after");
		System.out.println(this.lections.toString());
		System.out.println("Lections array");
		System.out.println(Arrays.asList(arr).toString());
		return arr;
	}

	public String getPräfix1(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang)) {
				this.prä1 = key.getPräfix();
			}
		}
		return this.prä1;
	}

	public String getPräfix2(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (this.frame.getLanguageCombi().get(key).getLanguage().equals(lang)) {
				this.prä2 = this.frame.getLanguageCombi().get(key).getPräfix();
			}
		}
		return this.prä2;
	}

	public void createLectionList() {
		this.lections.clear();
		this.putPräfix();
		this.lections.addAll(this.frame.getBear().getLektionList(this.prä1, this.prä2));
		this.lections.sort(null);
		this.lectionsCB.setModel(new DefaultComboBoxModel<String>(this.lections.toArray(new String[this.lections.size()])));
		//System.out.println(this.lections);
	}

	public int getVocabelFromTable(int row) {
		int index = 0;
		int lection = Integer.parseInt(this.lectionsCB.getSelectedItem().toString().split(" ")[1]);
		this.putPräfix();
		String original = (String) this.table.getModel().getValueAt(row, 1);
		String destination = (String) this.table.getModel().getValueAt(row, 2);
		int gelernt = Integer.parseInt(this.table.getModel().getValueAt(row, 3).toString());
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(this.prä1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(this.prä2) && (this.frame.getVokabeln().get(i).getLection() == lection) && this.frame.getVokabeln().get(i).getVocabOrigin().equals(original) && this.frame.getVokabeln().get(i).getVocabTranslation().equals(destination) && (this.frame.getVokabeln().get(i).getTested() == gelernt)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void putPräfix() {
		String language = this.languageCB.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		this.prä1 = this.getPräfix1(lang1);
		this.prä2 = this.getPräfix2(lang2);
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return this.table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the tableModel
	 */
	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}

	/**
	 * @param tableModel
	 *            the tableModel to set
	 */
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	/**
	 * @return the nr
	 */
	public int getNr() {
		return this.nr;
	}

	/**
	 * @param nr
	 *            the nr to set
	 */
	public void setNr(int nr) {
		this.nr = nr;
	}

	/**
	 * @return the addSpeech
	 */
	public TransparentButton getAddSpeech() {
		return this.addSpeech;
	}

	/**
	 * @param addSpeech
	 *            the addSpeech to set
	 */
	public void setAddSpeech(TransparentButton addSpeech) {
		this.addSpeech = addSpeech;
	}

	/**
	 * @return the deleteSpeech
	 */
	public TransparentButton getDeleteSpeech() {
		return this.deleteSpeech;
	}

	/**
	 * @param deleteSpeech
	 *            the deleteSpeech to set
	 */
	public void setDeleteSpeech(TransparentButton deleteSpeech) {
		this.deleteSpeech = deleteSpeech;
	}

	/**
	 * @return the addLection
	 */
	public TransparentButton getAddLection() {
		return this.addLection;
	}

	/**
	 * @param addLection
	 *            the addLection to set
	 */
	public void setAddLection(TransparentButton addLection) {
		this.addLection = addLection;
	}

	/**
	 * @return the deleteLection
	 */
	public TransparentButton getDeleteLection() {
		return this.deleteLection;
	}

	/**
	 * @param deleteLection
	 *            the deleteLection to set
	 */
	public void setDeleteLection(TransparentButton deleteLection) {
		this.deleteLection = deleteLection;
	}

	/**
	 * @return the addVocabel
	 */
	public TransparentButton getAddVocabel() {
		return this.addVocabel;
	}

	/**
	 * @param addVocabel
	 *            the addVocabel to set
	 */
	public void setAddVocabel(TransparentButton addVocabel) {
		this.addVocabel = addVocabel;
	}

	/**
	 * @return the deleteVocabel
	 */
	public TransparentButton getDeleteVocabel() {
		return this.deleteVocabel;
	}

	/**
	 * @param deleteVocabel
	 *            the deleteVocabel to set
	 */
	public void setDeleteVocabel(TransparentButton deleteVocabel) {
		this.deleteVocabel = deleteVocabel;
	}

	/**
	 * @return the editVocabel
	 */
	public TransparentButton getEditVocabel() {
		return this.editVocabel;
	}

	/**
	 * @param editVocabel
	 *            the editVocabel to set
	 */
	public void setEditVocabel(TransparentButton editVocabel) {
		this.editVocabel = editVocabel;
	}

	/**
	 * @return the selectSpeech
	 */
	public TransparentLabel getSelectSpeech() {
		return this.selectSpeech;
	}

	/**
	 * @param selectSpeech
	 *            the selectSpeech to set
	 */
	public void setSelectSpeech(TransparentLabel selectSpeech) {
		this.selectSpeech = selectSpeech;
	}

	/**
	 * @return the selectLection
	 */
	public TransparentLabel getSelectLection() {
		return this.selectLection;
	}

	/**
	 * @param selectLection
	 *            the selectLection to set
	 */
	public void setSelectLection(TransparentLabel selectLection) {
		this.selectLection = selectLection;
	}

	/**
	 * @return the lectionsCB
	 */
	public JComboBox<String> getLectionsCB() {
		return this.lectionsCB;
	}

	/**
	 * @param lectionsCB
	 *            the lectionsCB to set
	 */
	public void setLectionsCB(JComboBox<String> lectionsCB) {
		this.lectionsCB = lectionsCB;
	}

	/**
	 * @return the languageCB
	 */
	public JComboBox<String> getLanguageCB() {
		return this.languageCB;
	}

	/**
	 * @param languageCB
	 *            the languageCB to set
	 */
	public void setLanguageCB(JComboBox<String> languageCB) {
		this.languageCB = languageCB;
	}

	/**
	 * @return the vocabellistPanel
	 */
	public JPanel getVocabellistPanel() {
		return this.vocabellistPanel;
	}

	/**
	 * @param vocabellistPanel
	 *            the vocabellistPanel to set
	 */
	public void setVocabellistPanel(JPanel vocabellistPanel) {
		this.vocabellistPanel = vocabellistPanel;
	}

	/**
	 * @return the vocabelPanel
	 */
	public JPanel getVocabelPanel() {
		return this.vocabelPanel;
	}

	/**
	 * @param vocabelPanel
	 *            the vocabelPanel to set
	 */
	public void setVocabelPanel(JPanel vocabelPanel) {
		this.vocabelPanel = vocabelPanel;
	}

	/**
	 * @return the speechPanel
	 */
	public JPanel getSpeechPanel() {
		return this.speechPanel;
	}

	/**
	 * @param speechPanel
	 *            the speechPanel to set
	 */
	public void setSpeechPanel(JPanel speechPanel) {
		this.speechPanel = speechPanel;
	}

	/**
	 * @return the lectionPanel
	 */
	public JPanel getLectionPanel() {
		return this.lectionPanel;
	}

	/**
	 * @param lectionPanel
	 *            the lectionPanel to set
	 */
	public void setLectionPanel(JPanel lectionPanel) {
		this.lectionPanel = lectionPanel;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	/**
	 * @param scrollPane
	 *            the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * @return the columnNames
	 */
	public String[] getColumnNames() {
		return this.columnNames;
	}

	/**
	 * @param columnNames
	 *            the columnNames to set
	 */
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * @return the prä1
	 */
	public String getPrä1() {
		return this.prä1;
	}

	/**
	 * @param prä1
	 *            the prä1 to set
	 */
	public void setPrä1(String prä1) {
		this.prä1 = prä1;
	}

	/**
	 * @return the prä2
	 */
	public String getPrä2() {
		return this.prä2;
	}

	/**
	 * @param prä2
	 *            the prä2 to set
	 */
	public void setPrä2(String prä2) {
		this.prä2 = prä2;
	}

	/**
	 * @return the addL
	 */
	public addLanguage getAddL() {
		return this.addL;
	}

	/**
	 * @param addL
	 *            the addL to set
	 */
	public void setAddL(addLanguage addL) {
		this.addL = addL;
	}

	/**
	 * @return the addLe
	 */
	public addLection getAddLe() {
		return this.addLe;
	}

	/**
	 * @param addLe
	 *            the addLe to set
	 */
	public void setAddLe(addLection addLe) {
		this.addLe = addLe;
	}

	/**
	 * @return the addVoc
	 */
	public addVocabel getAddVoc() {
		return this.addVoc;
	}

	/**
	 * @param addVoc
	 *            the addVoc to set
	 */
	public void setAddVoc(addVocabel addVoc) {
		this.addVoc = addVoc;
	}

	/**
	 * @return the lections
	 */
	public ArrayList<String> getLections() {
		return this.lections;
	}

	/**
	 * @param lections
	 *            the lections to set
	 */
	public void setLections(ArrayList<String> lections) {
		this.lections = lections;
	}

	/**
	 * @return the vocabellist
	 */
	public ArrayList<Vokabel> getVocabellist() {
		return this.vocabellist;
	}

	/**
	 * @param vocabellist
	 *            the vocabellist to set
	 */
	public void setVocabellist(ArrayList<Vokabel> vocabellist) {
		this.vocabellist = vocabellist;
	}

}
