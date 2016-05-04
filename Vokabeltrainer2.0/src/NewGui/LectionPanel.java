package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;

@SuppressWarnings("serial")
public class LectionPanel extends JPanel {

	private MainFrame				frame;
	private internalLearningPanel	iLP;
	private BufferedImage			image;

	public LectionPanel(MainFrame frame) {
		this.setFrame(frame);
		this.iLP = new internalLearningPanel(frame);
		this.setBounds(2, 22, 1276, 686);
		try {
			this.image = ImageIO.read(new File("img/Lektionenleer2.png"));
		} catch (IOException ex) {}

		TransparentButton.createButton("Lektionen", 0, 65, 250, 45, 20, 0, (e -> {
			System.exit(1);
		}), this);

		TransparentButton.createButton("Lernen", 0, 21, 250, 44, 30, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Vokabeltest", 0, 110, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Suchspiel", 0, 155, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Buchstabieren", 0, 200, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Sprache Verwalten", 0, 250, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Einstellungen", 0, 295, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Statistiken", 0, 340, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Hilfe", 0, 385, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Info", 0, 430, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Beenden", 0, 660, 250, 60, 30, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		this.add(this.iLP);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);

		// this.paintChildren(g_);
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

}
