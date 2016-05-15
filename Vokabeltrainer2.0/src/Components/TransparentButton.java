package Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TransparentButton extends CustomButton {

	// private String text;
	private int		factor;
	private int		fontsize;
	private double	rotation				= 0;
	private boolean	correctX				= true;

	private Point	bounds;
	private Point	position;
	private Font	f;

	Color			borderColor				= new Color(255, 0, 0, 0);
	Color			backgroundColorcolor	= new Color(0, 0, 0, 0);

	/**
	 * the constructor of the standard TransperentButton
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 */
	public TransparentButton(String text, int x, int y, int width, int height, int fontsize, int factor) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
	}

	/**
	 * the constructor of the colored TrasperentButton
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 * @param c
	 */
	public TransparentButton(String text, int x, int y, int width, int height, int fontsize, int factor, Color c) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);
		this.backgroundColorcolor = c;

		this.setBounds(x, y, width, height);
	}

	/**
	 * the constructor of a TransperentButton with rotatet text
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 * @param rotation
	 */
	public TransparentButton(String text, int x, int y, int width, int height, int fontsize, int factor, double rotation) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
		this.rotation = (rotation * Math.PI) / 180.0;
		this.correctX = true;
	}

	/**
	 * render method of the button
	 */
	@Override
	public void render(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setFont(this.f);

		g.setColor(this.borderColor);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(this.backgroundColorcolor);
		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);// this.position.y + ((this.bounds.y * 3) / 4) + this.factor;
		if (this.correctX == true) {
			Font bft = g.getFont();
			AffineTransform at = new AffineTransform();
			at.rotate(this.rotation);
			g.setFont(bft.deriveFont(at));
			y -= (this.rotation * 180) / Math.PI;
		}
		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
	}

	/**
	 * crate the stadard TransperentButton
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 * @param c
	 * @param listener
	 * @param parent
	 * @return
	 */
	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, Color c, ActionListener listener, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor, c);
		button.addActionListener(listener);
		parent.add(button);
		return button;
	}

	/**
	 * create the colored TransperentButton
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 * @param listener
	 * @param parent
	 * @return
	 */
	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, ActionListener listener, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor);
		button.addActionListener(listener);
		parent.add(button);
		return button;
	}

	/**
	 * create the TransperentButton with rotated text
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param fontsize
	 * @param factor
	 * @param rotation
	 * @param listener
	 * @param parent
	 * @return
	 */
	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, double rotation, ActionListener listener, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor, rotation);
		button.addActionListener(listener);

		parent.add(button);
		return button;
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

	protected int getFactor() {
		return this.factor;
	}

	protected void setFactor(int factor) {
		this.factor = factor;
	}

	public double getRotation() {
		return this.rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public boolean isCorrectX() {
		return this.correctX;
	}

	public void setCorrectX(boolean correctX) {
		this.correctX = correctX;
	}

	public void setBackgroundColor(Color c) {
		this.backgroundColorcolor = c;
		this.repaint();
	}

	public void setBorderColor(Color c) {
		this.borderColor = c;
		this.repaint();
	}

}
