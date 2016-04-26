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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Components.TransparentButton;
import Components.TransparentLabel;

public class VocabelPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private int						n				= 11;
	private ArrayList<JCheckBox>	units			= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;
	private JSlider					timer;
	private String					comboBoxListe[]	= {
			"Englisch", "Französisch"
	};

	public VocabelPrePanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			image = ImageIO.read(new File("img/Hintergrund-weiß.png"));
		} catch (IOException ex) {}

		TransparentButton.createButton("Prüfen", 105, 550, 150, 40, 30, 0, (e -> {
			frame.getVocabelPrePanel().setVisible(false);
			frame.getiLectionPanel().setVisible(false);
			frame.getiLearningPanel().setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Vokabeltest");
			frame.getHeadingbar().getHeadingLabelR().setText("");
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
	public void createSettings(){
		JSlider timeSlider = new JSlider();
		timeSlider.setBounds(600, 300, 250, 40);
		timeSlider.setOpaque(false);
		timeSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(timeSlider);
				
		TransparentLabel.createLabel("Zeit", 600, 250, 250, 40, 20, this);
		
		JSlider coundSlider = new JSlider();
		coundSlider.setBounds(600, 200, 250, 40);
		coundSlider.setOpaque(false);
		coundSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(coundSlider);
		
		TransparentLabel.createLabel("Anzahl Vokabeln", 600, 150, 250, 40, 20, this);
		
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
	
}
