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

	/**
	 * crate the frame
	 * 
	 * @param frame
	 */
	public HeadingBar(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 31, 1028, 44);
		try {
			this.image = ImageIO.read(new File("img/HeadingBar.png"));
		} catch (IOException ex) {}
		this.headingLabelL = TransparentLabel.createLabel("Hauptmenü", 0, 0, 250, 44, 30, this);
		this.headingLabelR = TransparentLabel.createLabel("", 514, 0, 250, 44, 30, this);
		frame.getLabels().add(this.getHeadingLabelL());
		frame.getLabels().add(this.getHeadingLabelR());
	}

	/**
	 * render the grapics object
	 */
	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	/**
	 * @return the frame
	 */
	public MainFrame getFrame() {
		return this.frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * @return the headingLabelL
	 */
	public TransparentLabel getHeadingLabelL() {
		return this.headingLabelL;
	}

	/**
	 * @param headingLabelL
	 *            the headingLabelL to set
	 */
	public void setHeadingLabelL(TransparentLabel headingLabelL) {
		this.headingLabelL = headingLabelL;
	}

	/**
	 * @return the headingLabelR
	 */
	public TransparentLabel getHeadingLabelR() {
		return this.headingLabelR;
	}

	/**
	 * @param headingLabelR
	 *            the headingLabelR to set
	 */
	public void setHeadingLabelR(TransparentLabel headingLabelR) {
		this.headingLabelR = headingLabelR;
	}

}
