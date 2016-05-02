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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.TransparentButton;
import Components.TransparentLabel;

public class VocabelPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private int						n				= 11;
	private ArrayList<JCheckBox>	units			= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;
	private JSlider					timer;
	private TransparentButton		test;
	private String					comboBoxListe[]	= {
			"Englisch", "Franz�sisch"
	};

	public VocabelPrePanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			image = ImageIO.read(new File("img/Hintergrund-wei�.png"));
		} catch (IOException ex) {}

		test = TransparentButton.createButton("Pr�fen", 600, 450, 250, 40, 30, 0, (e -> {
			frame.getVocabelPrePanel().setVisible(false);
			frame.getiLectionPanel().setVisible(false);
			frame.getiLearningPanel().setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Vokabeltest");
			frame.getHeadingbar().getHeadingLabelR().setText("");
			// frame.getTimer().startTimer();
		}), this);

		createCheckboxes(n);
		createComboBox(comboBoxListe);
		createSettings();
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
	}

	public void createCheckboxes(int n) {
		for (int i = 0; i < n; i++) {
			units.add(new JCheckBox("Lektion " + (i + 1)));
			units.get(i).setBounds(120, 40 * i + 100, 200, 40);
			units.get(i).setOpaque(false);
			units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(units.get(i));
		}
	}

	public void createComboBox(String[] list) {
		combobox = new JComboBox<String>(list);
		combobox.setBounds(80, 50, 200, 40);
		combobox.setOpaque(false);
		combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(combobox);
	}

	public void createSettings() {
		JSlider timeSlider = new JSlider(0, 60, 15);
		timeSlider.setBounds(600, 360, 250, 55);
		timeSlider.setPaintTicks(true);
		timeSlider.setPaintLabels(true);
		timeSlider.setMajorTickSpacing(10);
		timeSlider.setMinorTickSpacing(2);
		timeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(((JSlider) e.getSource()).getValue());
			}
		});
		timeSlider.setOpaque(false);
		timeSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(timeSlider);

		TransparentLabel.createLabel("Zeit (min)", 600, 310, 250, 40, 20, this);

		JSlider coundSlider = new JSlider(0, 50, 30);
		coundSlider.setBounds(600, 220, 250, 55);
		coundSlider.setPaintTicks(true);
		coundSlider.setPaintLabels(true);
		coundSlider.setMajorTickSpacing(10);
		coundSlider.setMinorTickSpacing(2);
		coundSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(((JSlider) e.getSource()).getValue());
			}
		});
		coundSlider.setOpaque(false);
		coundSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(coundSlider);

		TransparentLabel.createLabel("Anzahl Vokabeln", 600, 170, 250, 40, 20, this);

		JCheckBox deengCheckBox = new JCheckBox("Deutsch-Englisch");
		deengCheckBox.setOpaque(false);
		deengCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		deengCheckBox.setBounds(550, 100, 200, 40);
		this.add(deengCheckBox);

		JCheckBox engdeCheckBox = new JCheckBox("Englisch-Deutsch");
		engdeCheckBox.setOpaque(false);
		engdeCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		engdeCheckBox.setBounds(750, 100, 200, 40);
		this.add(engdeCheckBox);
	}

	public TransparentButton getTest() {
		return test;
	}

	public void setTest(TransparentButton test) {
		this.test = test;
	}

}
