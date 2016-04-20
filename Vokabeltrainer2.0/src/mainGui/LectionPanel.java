package mainGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import subGui.internalLearningPanel;

public class LectionPanel extends JPanel {

	private MainFrame						frame;
	private internalLearningPanel			iLP;
	private BufferedImage					image;
	private ArrayList<TransperantButton>	button	= new ArrayList<TransperantButton>();

	public LectionPanel(MainFrame frame) {
		this.frame = frame;
		iLP = new internalLearningPanel(frame, this);
		try {
			image = ImageIO.read(new File("img/Lektionenleer2.png"));
		} catch (IOException ex) {}
		button.add(new TransperantButton("X", 1235, -19, 35, 40, 17));
		this.add(button.get(0));
		button.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("X");
			}
		});
		button.add(new TransperantButton("O", 1200, -19, 35, 40, 17));
		this.add(button.get(1));
		button.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("O");
			}
		});
		button.add(new TransperantButton("_", 1165, -19, 35, 40, 17));
		this.add(button.get(2));
		button.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("_");
			}
		});
		button.add(new TransperantButton("Lektionen", 0, 21, 250, 44, 30));
		this.add(button.get(3));
		button.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Lektionen ");
			}
		});
		button.add(new TransperantButton("Lektionen", 0, 65, 250, 45, 20));
		this.add(button.get(4));
		button.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Lektionen");
			}
		});
		button.add(new TransperantButton("Vokabeltest", 0, 110, 250, 45, 20));
		this.add(button.get(5));
		button.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Vokabeltest");
			}
		});
		button.add(new TransperantButton("Suchspiel", 0, 155, 250, 45, 20));
		this.add(button.get(6));
		button.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Suchspiel");
			}
		});
		button.add(new TransperantButton("Buchstabieren", 0, 200, 250, 45, 20));
		this.add(button.get(7));
		button.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Buchstabieren");
			}
		});
		button.add(new TransperantButton("Sprache Verwalten", 0, 250, 250, 45, 20));
		this.add(button.get(8));
		button.get(8).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Sprache Verwalten");
			}
		});
		button.add(new TransperantButton("Einstellungen", 0, 295, 250, 45, 20));
		this.add(button.get(9));
		button.get(9).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Einstellungen");
			}
		});
		button.add(new TransperantButton("Statistiken", 0, 340, 250, 45, 20));
		this.add(button.get(10));
		button.get(10).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Statistiken");
			}
		});
		button.add(new TransperantButton("Hilfe", 0, 385, 250, 45, 20));
		this.add(button.get(11));
		button.get(11).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Hilfe");
			}
		});
		button.add(new TransperantButton("Info", 0, 430, 250, 45, 20));
		this.add(button.get(12));
		button.get(12).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Info");
			}
		});
		button.add(new TransperantButton("Beenden", 5, 660, 245, 55, 30));
		this.add(button.get(13));
		button.get(13).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(1);
			}
		});
		button.add(new TransperantButton("Lektionen auswählen", 250, 21, 350, 44, 30));
		this.add(button.get(14));
		button.get(14).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("auswählen");
			}
		});
		this.add(iLP);
		for (TransperantButton b : button)
			System.out.println(b.getText() + " - X: " + b.getX() + " - Y: " + b.getY() + " - Width: " + b.getWidth() + " - Height: " + b.getHeight());
		// button
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
		for (TransperantButton p : button)
			p.paintComponent(g);
	}
}
