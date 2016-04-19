package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class TransperantButton extends CustomButton {

	private int		x		= 0, y = 0;
	private int		width	= 0, height = 0;
	// private String text;
	private Color	color;
	private double	factor;
	private int		fontsize;

	public TransperantButton(String text, int x, int y, int width, int height, int fontsize) {
		this.setXCoord(x);
		this.setYCoord(y);
		this.setWidthX(width);
		this.setHeightY(height);
		this.setText(text);
		this.fontsize = fontsize;
	}

	public void render(Graphics g) {
		System.out.println("ASDF");
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, fontsize));
		Color color = new Color(255, 0, 0, 255);
		Color color2 = new Color(1, 0, 0, 0);
		g.setColor(color);
		g.drawRect(x, y, width, height);
		g.setColor(color2);
		g.fillRect(x + 1, y + 1, width - 1, height - 1);
		g.setColor(Color.BLACK);
		g.drawString(this.getText(), this.x + (width / 2) - (int) (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth() / 2), this.y + height * 3 / 4);
	}

	protected int getXCoord() {
		return x;
	}

	protected void setXCoord(int x) {
		this.x = x;
	}

	protected int getYCoord() {
		return y;
	}

	protected void setYCoord(int y) {
		this.y = y;
	}

	public int getWidthX() {
		return width;
	}

	protected void setWidthX(int width) {
		this.width = width;
	}

	protected int getHeightY() {
		return height;
	}

	protected void setHeightY(int height) {
		this.height = height;
	}

	protected Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;
	}

	protected int getFontsize() {
		return fontsize;
	}

	protected void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}

}
