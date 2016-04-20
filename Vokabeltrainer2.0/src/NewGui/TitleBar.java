package NewGui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mainGui.TransperantButton;

@SuppressWarnings("serial")
public class TitleBar extends JPanel {
	private Point							initialClick;
	private MainFrame						frame;
	private BufferedImage					image;
	private Color							c;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();

	public TitleBar(final MainFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBounds(1, 1, 1278, 30);
		c = new Color(0, 0, 0, 15);
		try {
			this.image = ImageIO.read(new File("img/titlebar.png"));
		} catch (IOException ex) {}
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TitleBar.this.initialClick = e.getPoint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				int xMoved = (thisX + e.getX()) - (thisX + TitleBar.this.initialClick.x);
				int yMoved = (thisY + e.getY()) - (thisY + TitleBar.this.initialClick.y);

				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});

		TransperantButton.createButton("X", 1248, 0, 30, 30, 17, 8, (e -> {
			System.out.println("FUCK TITLE BAR");
			System.exit(1);
		}), this);

		TransperantButton.createButton("_", 1218, 0, 30, 30, 17, 5, (e -> {
			System.out.println("FUCK TITLE BAR 2");
			frame.setState(Frame.ICONIFIED);
		}), this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.image, 0, 0, null);
	}
}
