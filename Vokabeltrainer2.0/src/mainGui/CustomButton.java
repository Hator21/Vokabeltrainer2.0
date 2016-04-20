package mainGui;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class CustomButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;

	public CustomButton() {
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		this.render(g);
	}

	@Override
	public void paintComponents(Graphics g) {
		this.render(g);
	}

	public abstract void render(Graphics g);

}
