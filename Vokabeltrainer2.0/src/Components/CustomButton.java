package Components;

import java.awt.Graphics;

import javax.swing.JButton;

public abstract class CustomButton extends JButton {

	private static final long serialVersionUID = 1L;

	/**
	 * setBorderPaintet and setContenAreaFilled to false
	 */
	public CustomButton() {
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);

	}

	/**
	 * render the Graphics object
	 */
	@Override
	protected void paintComponent(Graphics g) {
		this.render(g);
	}

	@Override
	public void paintComponents(Graphics g) {
		//this.render(g);
	}

	public abstract void render(Graphics g);

}
