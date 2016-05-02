package NewGui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class TitleBar extends JPanel {
	private Point							initialClick;
	private MainFrame						frame;
	private BufferedImage					image, icon;
	private Color							c;
	private ArrayList<TransparentButton>	buttons	= new ArrayList<TransparentButton>();

	public TitleBar(final MainFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBounds(1, 1, 1278, 30);
		c = new Color(0, 0, 0, 15);
		try {
			this.image = ImageIO.read(new File("img/titlebar.png"));
		} catch (IOException ex) {}
		try {
			this.icon = ImageIO.read(new File("img/icon2.png"));
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

		TransparentButton.createButton("Vokabeltrainer 2.0", 50, 0, 200, 30, 20, 0, (e -> {
			for(JPanel p : frame.getPanelList()){
				p.setVisible(false);
			}
			frame.getPanelList().get(0).setVisible(true);
		}), this);

		TransparentButton.createButton("X", 1248, 0, 30, 30, 17, 8, (e -> {
			System.out.println("FUCK TITLE BAR");
			System.exit(1);
		}), this);

		TransparentButton.createButton("_", 1218, 0, 30, 30, 17, 5, (e -> {
			System.out.println("FUCK TITLE BAR 2");
			frame.setState(Frame.ICONIFIED);
		}), this);
	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
		g.drawImage(this.icon, 10, 1, 28, 28, null);
	}
}
