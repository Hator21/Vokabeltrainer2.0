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

import Components.TransparentButton;

@SuppressWarnings("serial")
public class internalLectionPanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private int						n				= 11;
	private ArrayList<JCheckBox>	units			= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;
	private String					comboBoxListe[]	= {
			"Englisch", "Französisch"
	};

	public internalLectionPanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}

		TransparentButton.createButton("Lernen", 105, 550, 150, 40, 30, 0, (e -> {
			frame.getiLectionPanel().setVisible(false);
			frame.getiLearningPanel().setVisible(true);
			frame.getHeadingbar().getMainmenu().setText("Lernen");
		}), this);

		createCheckboxes(n);
		createComboBox(comboBoxListe);
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
}
