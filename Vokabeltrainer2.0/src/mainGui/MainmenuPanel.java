package mainGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainmenuPanel extends JPanel {

	private MainFrame						frame;
	private BufferedImage					image;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();

	public MainmenuPanel(MainFrame frame) {
		this.frame = frame;
		try {
			image = ImageIO.read(new File("img/Hauptmenu2.png"));
		} catch (IOException ex) {}
		buttons.add(new TransperantButton("X", 1235, -19, 35, 40, 17));
		buttons.add(new TransperantButton("O", 1200, -19, 35, 40, 17));
		buttons.add(new TransperantButton("_", 1165, -19, 35, 40, 17));
		buttons.add(new TransperantButton("Lernen", 0, 21, 250, 44, 30));
		buttons.add(new TransperantButton("Lektionen", 0, 65, 250, 45, 20));
		buttons.add(new TransperantButton("Vokabeltest", 0, 110, 250, 45, 20));
		buttons.add(new TransperantButton("Suchspiel", 0, 155, 250, 45, 20));
		buttons.add(new TransperantButton("Buchstabieren", 0, 200, 250, 45, 20));
		buttons.add(new TransperantButton("Sprache Verwalten", 0, 250, 250, 45, 20));
		buttons.add(new TransperantButton("Einstellungen", 0, 295, 250, 45, 20));
		buttons.add(new TransperantButton("Statistiken", 0, 340, 250, 45, 20));
		buttons.add(new TransperantButton("Hilfe", 0, 385, 250, 45, 20));
		buttons.add(new TransperantButton("Info", 0, 430, 250, 45, 20));
		buttons.add(new TransperantButton("Beenden", 0, 660, 250, 60, 30));
		// buttons
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
		for (TransperantButton p : buttons)
			p.paintComponent(g);
	}

}
