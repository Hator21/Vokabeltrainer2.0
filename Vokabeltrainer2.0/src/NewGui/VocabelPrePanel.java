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
import javax.swing.JSlider;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class VocabelPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private ArrayList<JCheckBox>	units	= new ArrayList<JCheckBox>();
	private JCheckBox				deengCheckBox, engdeCheckBox;
	private JComboBox<String>		combobox;
	private JSlider					timeSlider, coundSlider;
	private TransparentButton		test;
	private TransparentLabel		countVocs, time;
	private int						n		= 0;

	/**
	 * create the frame
	 * 
	 * @param frame
	 */
	public VocabelPrePanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiß.png"));
		} catch (IOException ex) {}

		this.createButton();
		this.createCheckboxes(frame.getBear().getLektions());
		this.createComboBox(frame.add2Language());
		this.createSettings();
		this.createHelp();

	}

	/**
	 * create the button Prüfen
	 */
	public void createButton() {
		this.setTest(TransparentButton.createButton("Prüfen", 600, 550, 250, 40, 30, 0, (e -> {
			this.frame.getLek().clear();
			for (int i = 0; i < this.frame.getBear().getLektion(); i++) {
				if (this.units.get(i).isSelected() == true) {
					this.frame.getLek().add(i + 1);
				}
			}
			if (this.frame.getLek().size() == 0) {
				JOptionPane.showMessageDialog(this.frame, "Sie haben keine Lektion ausgewählt");
			} else {
				this.frame.getTestVokabeln().clear();
				this.frame.getLearningPanel().setRight(0);
				this.frame.getTestVokabeln().addAll(this.frame.getCheck().vok(this.frame.getLek().size(), this.frame.getBear().getPrä1(), this.frame.getBear().getPrä2()));
				if (this.getCoundSlider().getValue() > this.frame.getTestVokabeln().size()) {
					this.n = this.frame.getTestVokabeln().size();
				} else {
					this.n = this.getCoundSlider().getValue();
				}
				this.frame.getVocabeltestPanel().setCounts(this.n);
				this.frame.getVocabeltestPanel().getSpeech1Text().setText(this.frame.getCheck().vok(this.deengCheckBox.isSelected(), this.engdeCheckBox.isSelected()));

				for (JPanel p : this.frame.getPanelList()) {
					p.setVisible(false);
				}
				this.frame.getVocabeltestPanel().getTimerLabel().setText("Übrige Zeit: " + String.valueOf(this.getTimeSlider().getValue() + ":00"));
				this.frame.getPanelList().get(4).setVisible(true);
				this.frame.getHeadingbar().getHeadingLabelL().setText("Vokabeltest");
				this.frame.getVocabeltestPanel().getStart().setEnabled(true);
				this.frame.getVocabeltestPanel().getNext().setEnabled(false);
				this.frame.getTimer().setStopper(false);
			}
		}), this));
		this.frame.getButtons().add(this.getTest());
		this.frame.getButtons().add(this.getTest());
	}

	/**
	 * creat the ceckboxes fpr the lections
	 * 
	 * @param list
	 */
	public void createCheckboxes(ArrayList<Integer> list) {
		for (int i = 0; i < 10; i++) {
			this.units.add(new JCheckBox("Lektion " + (i + 1)));
			this.units.get(i).setBounds(120, (40 * i) + 100, 200, 40);
			if (list.contains(i + 1)) {
				this.units.get(i).setVisible(true);
			} else {
				this.units.get(i).setVisible(false);
			}
			this.units.get(i).setOpaque(false);
			this.units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.units.get(i));
		}
	}

	/**
	 * create the combobox for the speach
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
			VocabelPrePanel.this.frame.getBear().putPräfix(VocabelPrePanel.this.combobox);
			ArrayList<Integer> list1 = VocabelPrePanel.this.frame.getBear().getLektions();
			for (int i = 0; i < VocabelPrePanel.this.units.size(); i++) {
				if (list1.contains(i + 1)) {
					VocabelPrePanel.this.units.get(i).setVisible(true);
				} else {
					VocabelPrePanel.this.units.get(i).setVisible(false);
				}
			}
			this.deengCheckBox.setText((String) this.combobox.getSelectedItem());
			this.engdeCheckBox.setText(((String) (this.combobox.getSelectedItem())).split("-")[1] + "-" + ((String) (this.combobox.getSelectedItem())).split("-")[0]);
			this.repaint();
		});
	}

	/**
	 * creates the time slider and the cound slider and two checkboxes for the speach convert
	 */
	public void createSettings() {
		this.timeSlider = new JSlider(0, 60, 15);
		this.timeSlider.setBounds(600, 460, 250, 55);
		this.timeSlider.setPaintTicks(true);
		this.timeSlider.setPaintLabels(true);
		this.timeSlider.setMajorTickSpacing(10);
		this.timeSlider.setMinorTickSpacing(2);
		this.timeSlider.addChangeListener(e -> {
			return;
		});
		this.timeSlider.setOpaque(false);
		this.timeSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.timeSlider);

		this.coundSlider = new JSlider(0, 50, 30);
		this.coundSlider.setBounds(600, 320, 250, 55);
		this.coundSlider.setPaintTicks(true);
		this.coundSlider.setPaintLabels(true);
		this.coundSlider.setMajorTickSpacing(10);
		this.coundSlider.setMinorTickSpacing(2);
		this.coundSlider.addChangeListener(e -> {
			return;
		});
		this.coundSlider.setOpaque(false);
		this.coundSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.coundSlider);

		this.setCountVocs(TransparentLabel.createLabel("Anzahl Vokabeln", 600, 270, 250, 40, 20, this));
		this.frame.getLabels().add(this.getCountVocs());
		this.setTime(TransparentLabel.createLabel("Zeit (min)", 600, 410, 250, 40, 20, this));
		this.frame.getLabels().add(this.getTime());

		this.deengCheckBox = new JCheckBox("Deutsch-Englisch");
		this.deengCheckBox.setOpaque(false);
		this.deengCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.deengCheckBox.setBounds(550, 200, 200, 40);
		this.add(this.deengCheckBox);

		this.engdeCheckBox = new JCheckBox("Englisch-Deutsch");
		this.engdeCheckBox.setOpaque(false);
		this.engdeCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.engdeCheckBox.setBounds(750, 200, 200, 40);
		this.add(this.engdeCheckBox);

		this.deengCheckBox.setText((String) this.combobox.getSelectedItem());
		this.engdeCheckBox.setText(((String) (this.combobox.getSelectedItem())).split("-")[1] + "-" + ((String) (this.combobox.getSelectedItem())).split("-")[0]);
	}

	/**
	 * @return the frame
	 */
	public MainFrame getFrame() {
		return this.frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
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
	 * @return the timeSlider
	 */
	public JSlider getTimeSlider() {
		return this.timeSlider;
	}

	/**
	 * @param timeSlider
	 *            the timeSlider to set
	 */
	public void setTimeSlider(JSlider timeSlider) {
		this.timeSlider = timeSlider;
	}

	/**
	 * @return the test
	 */
	public TransparentButton getTest() {
		return this.test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(TransparentButton test) {
		this.test = test;
	}

	/**
	 * @return the countVocs
	 */
	public TransparentLabel getCountVocs() {
		return this.countVocs;
	}

	/**
	 * @param countVocs
	 *            the countVocs to set
	 */
	public void setCountVocs(TransparentLabel countVocs) {
		this.countVocs = countVocs;
	}

	/**
	 * @return the time
	 */
	public TransparentLabel getTime() {
		return this.time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(TransparentLabel time) {
		this.time = time;
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
	 * @return the coundSlider
	 */
	public JSlider getCoundSlider() {
		return this.coundSlider;
	}

	/**
	 * @param coundSlider
	 *            the coundSlider to set
	 */
	public void setCoundSlider(JSlider coundSlider) {
		this.coundSlider = coundSlider;
	}

	/**
	 * @return the deengCheckBox
	 */
	public JCheckBox getDeengCheckBox() {
		return this.deengCheckBox;
	}

	/**
	 * @param deengCheckBox
	 *            the deengCheckBox to set
	 */
	public void setDeengCheckBox(JCheckBox deengCheckBox) {
		this.deengCheckBox = deengCheckBox;
	}

	/**
	 * @return the engdeCheckBox
	 */
	public JCheckBox getEngdeCheckBox() {
		return this.engdeCheckBox;
	}

	/**
	 * @param engdeCheckBox
	 *            the engdeCheckBox to set
	 */
	public void setEngdeCheckBox(JCheckBox engdeCheckBox) {
		this.engdeCheckBox = engdeCheckBox;
	}

	/**
	 * render graphics objects
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
	 * creats the help text if option is selected
	 */
	public void createHelp() {
		this.frame.getHelper().add(TransparentLabel.createLabel("<- 1. Bitte wähle erst die gewünschte Sprache aus!", 290, 55, 425, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("<- 2. Danach wähle eine oder mehrere Lektionen aus!", 290, 105, 440, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("4. Zu guter letzt, klicke auf \"Prüfen\" damit es weiter geht! ->", 60, 555, 530, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("3. Nehme noch ein paar Einstellungen vor!", 540, 170, 430, 30, 18, this));
	}
}
