package NewGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MPanel extends JPanel {
	private MainFrame		frame;
	private BufferedImage	image;
	private Color			c;

	public MPanel(MainFrame frame) {
		this.frame = frame;
		c = new Color(255, 0, 0, 255);
		this.setLayout(null);
		this.setBounds(1, 30, 250, 688);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setColor(c);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}
}
