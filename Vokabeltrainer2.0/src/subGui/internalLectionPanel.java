package subGui;

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

import mainGui.LectionPanel;
import mainGui.MainFrame;
import mainGui.TransperantButton;

@SuppressWarnings("serial")
public class internalLectionPanel extends JPanel {

	private MainFrame						frame;
	private LectionPanel					lPanel;
	private BufferedImage					image;
	private int								n		= 0;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();
	private ArrayList<JCheckBox>			units	= new ArrayList<JCheckBox>();
	private JComboBox						combobox;

	public internalLectionPanel(MainFrame frame, LectionPanel lPanel) {
		this.frame = frame;
		this.lPanel = lPanel;
		this.setLayout(null);
		try {
			image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.setBounds(251, 66, 1028, 653);
		buttons.add(new TransperantButton("Lernen", 105, 550, 150, 40, 30));
		for (int i = 0; i < 11; i++) {
			units.add(new JCheckBox("Lektion " + (i + 1)));
			units.get(i).setBounds(120, 40 * i + 100, 200, 40);
			units.get(i).setOpaque(false);
			units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(units.get(i));
		}
		combobox = new JComboBox<Object>();
		combobox.setBounds(80, 50, 200, 40);
		combobox.setOpaque(false);
		combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(combobox);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
		for (TransperantButton p : buttons)
			p.render(g);
	}
}
