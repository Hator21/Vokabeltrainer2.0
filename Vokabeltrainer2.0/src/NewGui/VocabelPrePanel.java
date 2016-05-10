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
import javax.swing.JPanel;
import javax.swing.JSlider;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class VocabelPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private ArrayList<JCheckBox>	units			= new ArrayList<JCheckBox>();
	private JCheckBox				deengCheckBox, engdeCheckBox;
	private JComboBox<String>		combobox;
	private JSlider					timeSlider, coundSlider;
	private TransparentButton		test;
	private TransparentLabel		countVocs, time;
	private String					comboBoxListe[]	= {
			"Englisch", "Franz�sisch"
	};

	public VocabelPrePanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			this.image = ImageIO.read(new File("img/Hintergrund-wei�.png"));
		} catch (IOException ex) {}

		this.createButton();
		this.createCheckboxes(frame.getBear().getLektion());
		this.createComboBox(this.comboBoxListe);
		this.createSettings();

	}

	public void createButton() {
		this.setTest(TransparentButton.createButton("Pr�fen", 600, 450, 250, 40, 30, 0, (e -> {
			this.frame.getTestVokabeln().addAll(this.frame.getCheck().vok(this.frame.getVokabeln(), 10, this.frame.getLek()));
			for (JPanel p : this.frame.getPanelList()) {
				p.setVisible(false);
			}
			this.frame.getVocabeltestPanel().getTimerLabel().setText("�brige Zeit: " + String.valueOf(this.getTimeSlider().getValue() + ":00"));
			this.frame.getPanelList().get(4).setVisible(true);
			this.frame.getHeadingbar().getHeadingLabelL().setText("Vokabeltest");
			this.frame.getHeadingbar().getHeadingLabelR().setText("");
			this.frame.getTimer().setTimer(this.timeSlider.getValue(), 0);
		}), this));
		this.frame.getButtons().add(this.getTest());
	}

	public void createCheckboxes(int n) {
		for (int i = 0; i < n; i++) {
			this.units.add(new JCheckBox("Lektion " + (i + 1)));
			this.units.get(i).setBounds(120, (40 * i) + 100, 200, 40);
			this.units.get(i).setOpaque(false);
			this.units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.units.get(i));
		}
	}

	public void createComboBox(String[] list) {
		this.combobox = new JComboBox<String>(list);
		this.combobox.setBounds(80, 50, 200, 40);
		this.combobox.setOpaque(false);
		this.combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.combobox);
	}

	public void createSettings() {
		this.timeSlider = new JSlider(0, 60, 15);
		this.timeSlider.setBounds(600, 360, 250, 55);
		this.timeSlider.setPaintTicks(true);
		this.timeSlider.setPaintLabels(true);
		this.timeSlider.setMajorTickSpacing(10);
		this.timeSlider.setMinorTickSpacing(2);
		this.timeSlider.addChangeListener(e -> System.out.println(((JSlider) e.getSource()).getValue()));
		this.timeSlider.setOpaque(false);
		this.timeSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.timeSlider);

		this.coundSlider = new JSlider(0, 50, 30);
		this.coundSlider.setBounds(600, 220, 250, 55);
		this.coundSlider.setPaintTicks(true);
		this.coundSlider.setPaintLabels(true);
		this.coundSlider.setMajorTickSpacing(10);
		this.coundSlider.setMinorTickSpacing(2);
		this.coundSlider.addChangeListener(e -> System.out.println(((JSlider) e.getSource()).getValue()));
		this.coundSlider.setOpaque(false);
		this.coundSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.coundSlider);

		this.setCountVocs(TransparentLabel.createLabel("Anzahl Vokabeln", 600, 170, 250, 40, 20, this));
		this.frame.getLabels().add(this.getCountVocs());
		this.setTime(TransparentLabel.createLabel("Zeit (min)", 600, 310, 250, 40, 20, this));
		this.frame.getLabels().add(this.getTime());

		this.deengCheckBox = new JCheckBox("Deutsch-Englisch");
		this.deengCheckBox.setOpaque(false);
		this.deengCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.deengCheckBox.setBounds(550, 100, 200, 40);
		this.add(this.deengCheckBox);

		this.engdeCheckBox = new JCheckBox("Englisch-Deutsch");
		this.engdeCheckBox.setOpaque(false);
		this.engdeCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.engdeCheckBox.setBounds(750, 100, 200, 40);
		this.add(this.engdeCheckBox);
	}

	public TransparentButton getTest() {
		return this.test;
	}

	public void setTest(TransparentButton test) {
		this.test = test;
	}

	protected JSlider getTimeSlider() {
		return this.timeSlider;
	}

	protected TransparentLabel getCountVocs() {
		return this.countVocs;
	}

	protected void setCountVocs(TransparentLabel countVocs) {
		this.countVocs = countVocs;
	}

	protected TransparentLabel getTime() {
		return this.time;
	}

	protected void setTime(TransparentLabel time) {
		this.time = time;
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

}
