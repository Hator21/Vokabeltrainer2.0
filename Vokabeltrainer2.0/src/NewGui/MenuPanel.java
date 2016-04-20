package NewGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mainGui.TransperantButton;

public class MenuPanel extends JPanel {
	private MainFrame		frame;
	private BufferedImage	image;
	private Color			c;

	public MenuPanel(MainFrame frame) {
		this.frame = frame;
		c = new Color(255, 0, 0, 255);
		this.setLayout(null);
		this.setBounds(1, 32, 250, 687);
		try {
			this.image = ImageIO.read(new File("img/menu.png"));
		} catch (IOException ex) {}

		TransperantButton.createButton("Lektionen", 0, 45, 250, 45, 20, 0, (e -> {
			System.exit(1);
		}), this);

		TransperantButton.createButton("Lernen", 0, 0, 250, 44, 30, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Vokabeltest", 0, 90, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Suchspiel", 0, 135, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Buchstabieren", 0, 180, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Sprache Verwalten", 0, 229, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Einstellungen", 0, 274, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Statistiken", 0, 319, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Hilfe", 0, 364, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Info", 0, 409, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Beenden", 0, 627, 250, 60, 30, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);

	}
}
