package Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TransparentLabel extends CustomLabel {

	private int				fontsize;
	private Point			bounds;
	private Point			position;
	private Font			f;
	Color					color	= new Color(0, 0, 255, 0);
	Color					color2	= new Color(0, 0, 0, 0);
	boolean					opaque	= false;
	private BufferedImage	image	= null;

	/**
	 * Constructor of the TransperentLabel
	 *
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 */
	public TransparentLabel(String text, int x, int y, int width, int height, int fontsize) {
		this.setText(text);
		this.setFontsize(fontsize);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
	}

	/**
	 * Constructor of the TransperentLabel with opaque settings
	 *
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param opaque
	 */
	public TransparentLabel(String text, int x, int y, int width, int height, int fontsize, boolean opaque) {
		this.setText(text);
		this.setFontsize(fontsize);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.opaque = opaque;

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
	}

	/**
	 * painting the Label
	 */
	@Override
	public void paintComponent(Graphics g_) {
		if (this.opaque == false) {
			this.render(g_);
		} else {
			this.renderOpaque(g_);
		}
	}

	/**
	 * render settings for opaque labels
	 * 
	 * @param g_
	 */
	public void renderOpaque(Graphics g_) {
		if (this.image != null) {
			Graphics2D g = (Graphics2D) g_;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g.drawImage(this.image, 0, 0, 40, 40, null);
			System.out.println("angekommen");
		}
	}

	/**
	 * render settings for labels
	 * 
	 * @param g_
	 */
	public void render(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setFont(this.f);

		g.setColor(this.color);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(this.color2);
		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);

		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
	}

	/**
	 * crate the standard label
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param parent
	 * @return
	 */

	public static TransparentLabel createLabel(String text, int x, int y, int width, int height, int fontsize, JComponent parent) {
		TransparentLabel label = new TransparentLabel(text, x, y, width, height, fontsize);
		parent.add(label);
		return label;
	}

	/**
	 * create the opaque label
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param opaque
	 * @param parent
	 * @return
	 */
	public static TransparentLabel createLabel(String text, int x, int y, int width, int height, int fontsize, boolean opaque, JComponent parent) {
		TransparentLabel label = new TransparentLabel(text, x, y, width, height, fontsize, opaque);
		parent.add(label);
		return label;
	}

	/**
	 * return the Text of the Label
	 */
	@Override
	public String toString() {
		return this.getText();
	}

	/**
	 * 
	 * @return the frontsize of the label
	 */
	public int getFontsize() {
		return this.fontsize;
	}

	/**
	 * sets the frontsize of the label
	 * 
	 * @param fontsize
	 */
	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}

	/**
	 * 
	 * @return label color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * sets the color and repaint
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
		this.repaint();
	}

	/**
	 * set the image of the label
	 * 
	 * @param path
	 */
	public void setImage(String path) {
		if (path == null)
			path = "img/CorrectImage.png";
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException ex) {}
	}

}
