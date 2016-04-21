package NewGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JComponent;


public class TransparentLabel extends CustomLabel {

	private int			fontsize;
	private Point		bounds;
	private Point		position;
	private Font		f;
	static final Color	color	= new Color(0, 0, 255, 0);
	static final Color	color2	= new Color(0, 0, 0, 0);

	public TransparentLabel(String text, int x, int y, int width, int height, int fontsize) {
		this.setText(text);
		this.setFontsize(fontsize);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
		System.out.println(this.getBounds());
	}

	@Override
	public void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setFont(this.f);

		g.setColor(color);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(color2);
		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);

		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
	}

	public static void createLabel(String text, int x, int y, int width, int height, int fontsize, JComponent parent) {
		TransparentLabel label = new TransparentLabel(text, x, y, width, height, fontsize);
		// System.out.println(parent.getClass().getName());
		parent.add(label);
	}

	@Override
	public String toString() {
		return this.getText();
	}

	protected int getFontsize() {
		return this.fontsize;
	}

	protected void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}
}
