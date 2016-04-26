package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentLabel;

@SuppressWarnings("serial")
public class HeadingBar extends JPanel {

	private MainFrame			frame;
	private BufferedImage		image;
	private TransparentLabel	headingLabelL, headingLabelR;

	public HeadingBar(MainFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBounds(251, 31, 1028, 44);
		try {
			this.image = ImageIO.read(new File("img/HeadingBar.png"));
		} catch (IOException ex) {}
		headingLabelL = TransparentLabel.createLabel("Hauptmen�", 0, 0, 250, 44, 30, this);
		headingLabelR = TransparentLabel.createLabel("", 514, 0, 250, 44, 30, this);
	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public TransparentLabel getHeadingLabelL() {
		return headingLabelL;
	}

	public void setHeadingPanelL(TransparentLabel headingLabelL) {
		this.headingLabelL = headingLabelL;
	}
	
	public TransparentLabel getHeadingLabelR() {
		return headingLabelR;
	}

	public void setHeadingPanelR(TransparentLabel headingLabelR) {
		this.headingLabelR = headingLabelR;
	}

}