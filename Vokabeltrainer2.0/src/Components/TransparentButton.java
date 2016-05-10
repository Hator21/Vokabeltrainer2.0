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

import NewGui.MainFrame;

@SuppressWarnings("serial")
public class TransparentButton extends CustomButton {

	// private String text;
	private MainFrame	frame;
	private int			factor;
	private int			fontsize;
	private double		rotation				= 0;
	private boolean		correctX				= true;

	private Point		bounds;
	private Point		position;
	private Font		f;

	Color				borderColor				= new Color(255, 0, 0, 0);
	Color				backgroundColorcolor	= new Color(0, 0, 0, 0);

	public TransparentButton(String text, int x, int y, int width, int height, int fontsize, int factor) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
	}

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

	public TransparentButton(String text, int x, int y, int width, int height, int fontsize, int factor, double rotation) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
		this.rotation = rotation * Math.PI / 180.0;
		this.correctX = true;
	}

	@Override
	public void render(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setFont(this.f);

		g.setColor(borderColor);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(backgroundColorcolor);
		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);// this.position.y + ((this.bounds.y * 3) / 4) + this.factor;
		if (correctX == true) {
			Font bft = g.getFont();
			AffineTransform at = new AffineTransform();
			at.rotate(rotation);
			g.setFont(bft.deriveFont(at));
			y -= rotation * 180 / Math.PI;
		}
		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
	}

	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, Color c, ActionListener listener, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor, c);
		button.addActionListener(listener);
		System.out.println(parent.getClass().getName());
		parent.add(button);
		return button;
	}

	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, ActionListener listener, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor);
		button.addActionListener(listener);
		System.out.println(parent.getClass().getName());
		parent.add(button);
		return button;
	}

	public static TransparentButton createButton(String text, int x, int y, int width, int height, int fontsize, int factor, double rotation, ActionListener listener, String actionCommand, JComponent parent) {
		TransparentButton button = new TransparentButton(text, x, y, width, height, fontsize, factor, rotation);
		button.addActionListener(listener);
		button.setActionCommand(actionCommand);
		System.out.println(parent.getClass().getName());
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
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public boolean isCorrectX() {
		return correctX;
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
