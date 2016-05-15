package NewGui;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;

@SuppressWarnings("serial")
public class TitleBar extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image, icon;
	private Point				initialClick;
	private TransparentButton	close, minimize, mainmenu;

	/**
	 * create the frame
	 *
	 * @param frame
	 */
	public TitleBar(final MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(1, 1, 1278, 30);
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

		this.setMainmenu(TransparentButton.createButton("Vokabeltrainer 2.0", 50, 0, 200, 30, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(0).setVisible(true);
		}), this));
		frame.getButtons().add(this.getMainmenu());

		this.setClose(TransparentButton.createButton("X", 1248, 0, 30, 30, 17, 8, (e -> {
			frame.getBear().Close();
			try {
				FileOutputStream fos = new FileOutputStream("data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(frame.getLanguageCombi());
				oos.close();
			} catch (IOException e1) {}
			try {
				frame.getStats().write(frame.getStats().getStat());
			} catch (Exception exc) {}

			System.exit(1);
		}), this));
		frame.getButtons().add(this.getClose());

		this.setMinimize(TransparentButton.createButton("_", 1218, 0, 30, 30, 17, 5, (e -> {
			frame.setState(Frame.ICONIFIED);
		}), this));
		frame.getButtons().add(this.getMinimize());
	}

	/**
	 * render graphics object
	 */
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

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * @return the icon
	 */
	public BufferedImage getIcon() {
		return this.icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(BufferedImage icon) {
		this.icon = icon;
	}

	/**
	 * @return the initialClick
	 */
	public Point getInitialClick() {
		return this.initialClick;
	}

	/**
	 * @param initialClick
	 *            the initialClick to set
	 */
	public void setInitialClick(Point initialClick) {
		this.initialClick = initialClick;
	}

	/**
	 * @return the close
	 */
	public TransparentButton getClose() {
		return this.close;
	}

	/**
	 * @param close
	 *            the close to set
	 */
	public void setClose(TransparentButton close) {
		this.close = close;
	}

	/**
	 * @return the minimize
	 */
	public TransparentButton getMinimize() {
		return this.minimize;
	}

	/**
	 * @param minimize
	 *            the minimize to set
	 */
	public void setMinimize(TransparentButton minimize) {
		this.minimize = minimize;
	}

	/**
	 * @return the mainmenu
	 */
	public TransparentButton getMainmenu() {
		return this.mainmenu;
	}

	/**
	 * @param mainmenu
	 *            the mainmenu to set
	 */
	public void setMainmenu(TransparentButton mainmenu) {
		this.mainmenu = mainmenu;
	}

}
