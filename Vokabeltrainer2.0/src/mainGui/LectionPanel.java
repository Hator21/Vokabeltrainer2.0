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

import subGui.internalLearningPanel;

public class LectionPanel extends JPanel {

	private MainFrame						frame;
	private internalLearningPanel			iLP;
	private BufferedImage					image;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();

	public LectionPanel(MainFrame frame) {
		this.frame = frame;
		this.iLP = new internalLearningPanel(frame, this);
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

		//		TransperantButton lection2 = new TransperantButton("Lektionen", 0, 65, 250, 45, 20, 0);
		//		this.add(lection2);
		//		buttons.add(lection2);
		//		lection2.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Lektionen");
		//			}
		//		});
		//
		//		TransperantButton vocabeltest = new TransperantButton("Vokabeltest", 0, 110, 250, 45, 20, 0);
		//		this.add(vocabeltest);
		//		buttons.add(vocabeltest);
		//		vocabeltest.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Vokabeltest");
		//			}
		//		});
		//
		//		TransperantButton searchgame = new TransperantButton("Suchspiel", 0, 155, 250, 45, 20, 0);
		//		this.add(searchgame);
		//		buttons.add(searchgame);
		//		searchgame.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Suchspiel");
		//			}
		//		});
		//
		//		TransperantButton spell = new TransperantButton("Buchstabieren", 0, 200, 250, 45, 20, 0);
		//		this.add(spell);
		//		buttons.add(spell);
		//		spell.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Buchstabieren");
		//			}
		//		});
		//
		//		TransperantButton speach = new TransperantButton("Sprache Verwalten", 0, 250, 250, 45, 20, 0);
		//		this.add(speach);
		//		buttons.add(speach);
		//		speach.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Sprache Verwalten");
		//			}
		//		});
		//
		//		TransperantButton settings = new TransperantButton("Einstellungen", 0, 295, 250, 45, 20, 0);
		//		this.add(settings);
		//		buttons.add(settings);
		//		settings.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Einstellungen");
		//			}
		//		});
		//
		//		TransperantButton statistics = new TransperantButton("Statistiken", 0, 340, 250, 45, 20, 0);
		//		this.add(statistics);
		//		buttons.add(statistics);
		//		statistics.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Statistiken");
		//			}
		//		});
		//
		//		TransperantButton help = new TransperantButton("Hilfe", 0, 385, 250, 45, 20, 0);
		//		this.add(help);
		//		buttons.add(help);
		//		help.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Hilfe");
		//			}
		//		});
		//
		//		TransperantButton info = new TransperantButton("Info", 0, 430, 250, 45, 20, 0);
		//		this.add(info);
		//		buttons.add(info);
		//		info.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.out.println("Info");
		//			}
		//		});
		//
		//		TransperantButton exit = new TransperantButton("Beenden", 5, 660, 245, 55, 30, 0);
		//		this.add(exit);
		//		buttons.add(exit);
		//		exit.addActionListener(new ActionListener() {
		//			public void actionPerformed(java.awt.event.ActionEvent e) {
		//				System.exit(1);
		//			}
		//		});
		//
		//		TransperantButton lectionselect = new TransperantButton("Lektionen auswählen", 250, 21, 350, 44, 30, 0);
		//		buttons.add(lectionselect);

		for (TransperantButton b : this.buttons) {
			System.out.println(b.getText() + " - X: " + b.getX() + " - Y: " + b.getY() + " - Width: " + b.getWidth() + " - Height: " + b.getHeight());
		}

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

		//this.paintChildren(g_);
	}

}
