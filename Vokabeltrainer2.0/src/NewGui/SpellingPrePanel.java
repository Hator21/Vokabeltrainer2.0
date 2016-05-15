package NewGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

public class SpellingPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private int						n				= 11;
	private TransparentButton		learning;
	private ArrayList<JCheckBox>	units			= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;
	private String					comboBoxListe[]	= {
			"Englisch", "Französisch"
	};

	/**
	 * creates the frame
	 * 
	 * @param frame
	 */
	public SpellingPrePanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}

		frame.getButtons().add(this.getLearning());
		this.createCheckboxes(frame.getBear().getLektion());
		this.createComboBox(frame.add2Language());
		this.frame.getBear().putPräfix(this.combobox);
		ArrayList<Integer> list1 = this.frame.getBear().getLektions();
		for (int i = 0; i < this.units.size(); i++) {
			if (list1.contains(i + 1)) {
				this.units.get(i).setVisible(true);
			} else {
				this.units.get(i).setVisible(false);
			}
		}

		this.setLearning(TransparentButton.createButton("Lernen", 105, 550, 150, 40, 30, 0, (e -> {
			frame.getLek().clear();
			for (int i = 0; i < frame.getBear().getLektion(); i++) {
				if (this.units.get(i).isSelected() == true) {
					frame.getLek().add(i + 1);
				}
			}
			if (frame.getLek().size() == 0) {
				JOptionPane.showMessageDialog(frame, "Sie haben keine Lektion ausgewählt");
			} else {
				frame.getTestVokabeln().clear();
				frame.getCheck().newGame(frame.getTestVokabeln());
				frame.getTestVokabeln().addAll(frame.getCheck().vok(frame.getLek().size(), frame.getBear().getPrä1(), frame.getBear().getPrä2()));

				for (JPanel p : frame.getPanelList()) {
					p.setVisible(false);
				}
				frame.getSpellingPanel().setButtonTexts(frame.getBear().getPrä1(), frame.getBear().getPrä2());
				frame.getPanelList().get(8).setVisible(true);
				frame.getHeadingbar().getHeadingLabelL().setText("Buchstabieren");
			}
		}), this));
		this.createHelp();
	}

	/**
	 * renders graphic object
	 */
	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	/**
	 * create checkbox for lecton select
	 * 
	 * @param n
	 */
	public void createCheckboxes(int n) {
		for (int i = 0; i < n; i++) {
			this.units.add(new JCheckBox("Lektion " + (i + 1)));
			this.units.get(i).setBounds(120, (40 * i) + 100, 200, 40);
			this.units.get(i).setOpaque(false);
			this.units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.units.get(i));
		}
	}

	/**
	 * create combobox for the speac
	 * 
	 * @param list
	 */
	public void createComboBox(String[] list) {
		this.combobox = new JComboBox<String>(list);
		this.combobox.setBounds(80, 50, 200, 40);
		this.combobox.setOpaque(false);
		this.combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.combobox);
		this.combobox.addActionListener(arg0 -> {
			SpellingPrePanel.this.frame.getBear().putPräfix(SpellingPrePanel.this.combobox);
			ArrayList<Integer> list1 = SpellingPrePanel.this.frame.getBear().getLektions();
			for (int i = 0; i < SpellingPrePanel.this.units.size(); i++) {
				if (list1.contains(i + 1)) {
					SpellingPrePanel.this.units.get(i).setVisible(true);
				} else {
					SpellingPrePanel.this.units.get(i).setVisible(false);
				}
			}
			this.repaint();
		});
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/*
	 * sets the help test if option is selected
	 */
	public void createHelp() {
		this.frame.getHelper().add(TransparentLabel.createLabel("<- 1. Bitte wähle erst die gewünschte Sprache aus!", 290, 55, 425, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("2. Danach wähle eine oder mehrere Lektionen aus!", 0, 500, 444, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("<- 3. Zu guter letzt, klicke auf \"Lernen\" damit es weiter geht!", 260, 555, 530, 30, 18, this));
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
	 * @return the n
	 */
	public int getN() {
		return this.n;
	}

	/**
	 * @param n
	 *            the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the learning
	 */
	public TransparentButton getLearning() {
		return this.learning;
	}

	/**
	 * @param learning
	 *            the learning to set
	 */
	public void setLearning(TransparentButton learning) {
		this.learning = learning;
	}

	/**
	 * @return the units
	 */
	public ArrayList<JCheckBox> getUnits() {
		return this.units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(ArrayList<JCheckBox> units) {
		this.units = units;
	}

	/**
	 * @return the combobox
	 */
	public JComboBox<String> getCombobox() {
		return this.combobox;
	}

	/**
	 * @param combobox
	 *            the combobox to set
	 */
	public void setCombobox(JComboBox<String> combobox) {
		this.combobox = combobox;
	}

	/**
	 * @return the comboBoxListe
	 */
	public String[] getComboBoxListe() {
		return this.comboBoxListe;
	}

	/**
	 * @param comboBoxListe
	 *            the comboBoxListe to set
	 */
	public void setComboBoxListe(String[] comboBoxListe) {
		this.comboBoxListe = comboBoxListe;
	}

}
