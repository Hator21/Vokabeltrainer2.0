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

@SuppressWarnings("serial")
public class LearningPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private TransparentButton		learning;
	private ArrayList<JCheckBox>	units	= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;

	/**
	 * create the frame
	 * 
	 * @param frame
	 */
	public LearningPrePanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.createComboBox(frame.add2Language());
		frame.getBear().putPr�fix(this.combobox);
		this.createCheckboxes(frame.getBear().getLektions());

		this.setLearning(TransparentButton.createButton("Lernen", 105, 550, 150, 40, 30, 0, (e -> {
			frame.getLek().clear();
			for (int i = 0; i < frame.getBear().getLektion(); i++) {
				if (this.units.get(i).isSelected() == true) {
					frame.getLek().add(i + 1);
				}
			}
			if (frame.getLek().size() == 0) {
				JOptionPane.showMessageDialog(frame, "Sie haben keine Lektion ausgew�hlt");
			} else {
				frame.getTestVokabeln().clear();
				frame.getLearningPanel().setRight(0);
				frame.getLearningPanel().setBright(0);
				frame.getLearningPanel().setWrong(0);
				frame.getLearningPanel().getCountRight().setText("Richtige: 0");
				frame.getLearningPanel().getCountWrong().setText("Falsche: 0");
				frame.getLearningPanel().getAverage().setText("Durchschnitt: 0%");
				frame.getLearningPanel().getCorrect().setImage(null);
				frame.getCheck().newGame(frame.getVokabeln());
				frame.getTestVokabeln().addAll(frame.getCheck().vok(frame.getLek().size(), frame.getBear().getPr�1(), frame.getBear().getPr�2()));
				frame.getLearningPanel().setCounts(frame.getTestVokabeln().size());
				frame.getLearningPanel().getSpeech1Text().setText(frame.getCheck().vok(true, true));

				for (JPanel p : frame.getPanelList()) {
					p.setVisible(false);
				}

				frame.getPanelList().get(2).setVisible(true);
				frame.getHeadingbar().getHeadingLabelL().setText("Lernen");
				frame.getLearningPanel().getCorrect().setImage(null);
			}
		}), this));
		frame.getButtons().add(this.getLearning());

		this.createHelp();

	}

	/**
	 * renders the graphics object
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
	 * create checkboxes for the lable select
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
	 * create the combobox to select the speach
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
			LearningPrePanel.this.frame.getBear().putPr�fix(LearningPrePanel.this.combobox);
			ArrayList<Integer> list1 = LearningPrePanel.this.frame.getBear().getLektions();
			for (int i = 0; i < LearningPrePanel.this.units.size(); i++) {
				if (list1.contains(i + 1)) {
					LearningPrePanel.this.units.get(i).setVisible(true);
				} else {
					LearningPrePanel.this.units.get(i).setVisible(false);
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

	/**
	 * sets the help text if option is used
	 */
	public void createHelp() {
		this.frame.getHelper().add(TransparentLabel.createLabel("<- 1. Bitte w�hle erst die gew�nschte Sprache aus!", 290, 55, 425, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("2. Danach w�hle eine oder mehrere Lektionen aus!", 0, 500, 444, 30, 18, this));
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

}
