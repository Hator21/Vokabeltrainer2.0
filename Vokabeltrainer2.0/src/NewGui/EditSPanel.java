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

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class EditSPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private JTable				table;
	private TransparentButton	addSpeech, deleteSpeech, addLection, deleteLection, addVocabel, deleteVocabel, editVocabel;
	private TransparentLabel	selectSpeech, selectLection;
	JComboBox<String>			lectionsCB, languageCB;
	JPanel						vocabellistPanel, vocabelPanel, speechPanel, lectionPanel;
	JScrollPane					scrollPane;
	private String[]			columnNames	= {
			"Nr.", "Sprache1", "Sprache2", "Gelernt x-mal", "Richtig (%)"
	};

	private String[][]			vokabeln	= {
			{
					"1", "Hallo", "Hello", "2", "50%"
			}, {
					"2", "Junge", "Boy/Guy", "1", "100%"
			}, {
					"3", "Mädchen", "girl", "3", "33%"
			}

	};

	public EditSPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiß.png"));

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

			}), speechPanel));
			setDeleteSpeech(TransparentButton.createButton("Sprache löschen", 36, 53, 248, 29, 20, 0, new Color(10, 10, 10, 20), (e -> {

			}), speechPanel));

			languageCB = new JComboBox<String>();
			languageCB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			languageCB.setModel(new DefaultComboBoxModel<String>(new String[] {
					"Deutsch-Englisch", "Deutsch-Französisch"
			}));
			languageCB.setSelectedIndex(0);
			languageCB.setBounds(36, 127, 248, 29);
			speechPanel.add(languageCB);

			setSelectLection(TransparentLabel.createLabel("Sprache auswählen", 36, 87, 248, 29, 20, speechPanel));

			vocabellistPanel = new JPanel();
			vocabellistPanel.setLayout(new GridLayout(1, 0));
			vocabellistPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			vocabellistPanel.setBounds(8, 212, 1010, 421);
			add(vocabellistPanel);

			table = new JTable(vokabeln, columnNames);
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
		} catch (IOException ex) {}

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
		for (int i = 0; i < frame.getVokabeln().size(); i++) {
			if (((String)(lectionsCB.getSelectedItem())).startsWith("Lektion ")) {
				int x = Integer.valueOf(((String)(lectionsCB.getSelectedItem())).split(" ")[1]);
				String
				if(frame.getVokabeln().get(i).getLection() == x){
					String originalLanguage = frame.getVokabeln().get(i).get;
					String name = originalLeagueList.get(i).getName();
					int points = originalLeagueList.get(i).getPoinst();
					int wins = originalLeagueList.get(i).getWins();
					int defeats = originalLeagueList.get(i).getDefeats();
					int draws = originalLeagueList.get(i).getDraws();
					int totalMatches = originalLeagueList.get(i).getTotalMathces();
					int goalF = originalLeagueList.get(i).getGoalF();
					int goalA = originalLeagueList.get(i).getGoalA();
					int tgoalD = originalLeagueList.get(i).getTtgoalD();

			Object[] data = {
					position, name, points, wins, defeats, draws, totalMatches, goalF, goalA, ttgoalD
			};

			tableModel.add(data);

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
}
