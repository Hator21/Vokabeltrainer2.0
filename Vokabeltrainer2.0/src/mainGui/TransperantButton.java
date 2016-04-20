package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TransperantButton extends CustomButton {

	// private String text;
	private int			factor;
	private int			fontsize;

	private Point		bounds;
	private Point		position;
	private Font		f;

	static final Color	color	= new Color(255, 0, 0, 0);
	static final Color	color2	= new Color(0, 0, 0, 0);

	public TransperantButton(String text, int x, int y, int width, int height, int fontsize, int factor) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);

		this.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.setFont(this.f);

		g.setColor(color);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(color2);
		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);// this.position.y + ((this.bounds.y * 3) / 4) + this.factor;

		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
		// System.out.println("RENDER: " + this.getText() + " - X: " + this.getX() + " - Y: " + this.getY() + " - Width: " + this.getWidth() + " - Height: " + this.getHeight());
	}

	public static void createButton(String text, int x, int y, int width, int height, int fontsize, int factor, ActionListener listener, JComponent parent) {
		TransperantButton button = new TransperantButton(text, x, y, width, height, fontsize, factor);
		button.addActionListener(listener);
		System.out.println(parent.getClass().getName());
		parent.add(button);
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

}
