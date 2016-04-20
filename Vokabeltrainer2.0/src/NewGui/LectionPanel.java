package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mainGui.TransperantButton;
import subGui.internalLearningPanel;

public class LectionPanel extends JPanel {

	private MainFrame						frame;
	private internalLearningPanel			iLP;
	private BufferedImage					image;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();

	public LectionPanel(MainFrame frame) {
		this.frame = frame;
		this.iLP = new internalLearningPanel(frame);
		this.setBounds(2, 22, 1276, 686);
		try {
			this.image = ImageIO.read(new File("img/Lektionenleer2.png"));
		} catch (IOException ex) {}

		TransperantButton.createButton("Lektionen", 0, 65, 250, 45, 20, 0, (e -> {
			System.exit(1);
		}), this);

		TransperantButton.createButton("Lernen", 0, 21, 250, 44, 30, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Vokabeltest", 0, 110, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Suchspiel", 0, 155, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Buchstabieren", 0, 200, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Sprache Verwalten", 0, 250, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Einstellungen", 0, 295, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Statistiken", 0, 340, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Hilfe", 0, 385, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Info", 0, 430, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransperantButton.createButton("Beenden", 0, 660, 250, 60, 30, 0, (e -> {
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

}
