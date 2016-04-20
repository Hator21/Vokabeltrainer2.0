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
	Color				blah	= Color.BLACK;

	static final Color	color	= new Color(255, 0, 0, 255);
	static final Color	color2	= new Color(1, 0, 0, 0);

	public TransperantButton(String text, int x, int y, int width, int height, int fontsize, int factor) {
		this.setText(text);
		this.setFontsize(fontsize);
		this.setFactor(factor);

		this.f = new Font("Comic Sans MS", Font.PLAIN, this.fontsize);

		this.bounds = new Point(width, height);
		this.position = new Point(0, 0);
		/*
		 * System.out.println("Bounds:");
		 * System.out.println(this.bounds);
		 * System.out.println("Position:");
		 * System.out.println(this.position);
		 */

		this.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		System.out.println(this.toString());
		g.setFont(this.f);

		//g.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setColor(color);
		g.drawRect(this.position.x, this.position.y, this.bounds.x - 1, this.bounds.y - 1);

		g.setColor(color2);

		g.fillRect(this.position.x + 1, this.position.y + 1, this.bounds.x - 2, this.bounds.y - 2);
		g.setColor(Color.BLACK);

		int x = (this.position.x + (this.bounds.x / 2)) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2);
		int y = ((this.position.y + (this.bounds.y / 2)) + (int) ((g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()) / 2)) + ((int) g.getFontMetrics().getStringBounds(this.getText(), g).getY() / 4);//this.position.y + ((this.bounds.y * 3) / 4) + this.factor;

		System.out.println("Position:");
		System.out.println(this.position);

		System.out.println("X: " + x);
		System.out.println("Y: " + y);

		System.out.println("Width: " + this.bounds.x);
		System.out.println("Height: " + this.bounds.y);

		System.out.println("String Width: " + g.getFontMetrics().getStringBounds(this.getText(), g).getWidth());
		System.out.println("String Height: " + g.getFontMetrics().getStringBounds(this.getText(), g).getHeight());

		g.setColor(Color.RED);
		g.fillArc(x, y, 10, 10, 0, 360);

		g.setColor(this.blah);
		g.fillArc(5, 5, 10, 10, 0, 360);

		g.setColor(Color.BLACK);
		g.drawString(this.getText(), x, y);
		//		if (this.getText() == "Lektionen")
		//			System.out.println("RENDER: " + this.getText() + " - X: " + this.getX() + " - Y: " + this.getY() + " - Width: " + this.getWidth() + " - Height: " + this.getHeight());
	}

	public static void createButton(String text, int x, int y, int width, int height, int fontsize, int factor, ActionListener listener, JComponent parent) {
		TransperantButton button = new TransperantButton(text, x, y, width, height, fontsize, factor);
		button.addActionListener(listener);
		System.out.println(parent.getClass().getName());
		if (parent.getClass().getName().equalsIgnoreCase("mainGui.TitleBar")) {
			button.blah = Color.BLUE;
		}
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
