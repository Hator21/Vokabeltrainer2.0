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
public class InfoPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private TransparentLabel	buildName, buildID, copyright;

	/**
	 * sets the frame
	 * 
	 * @param frame
	 */
	public InfoPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiﬂ.png"));
		} catch (IOException ex) {}
		this.createLabel();
	}

	/**
	 * create Label
	 */
	public void createLabel() {
		this.setBuildName(TransparentLabel.createLabel("Vokabeltrainer v2", 100, 100, 200, 50, 20, this));
		this.setBuildID(TransparentLabel.createLabel("Build id: 20160515-0120", 100, 150, 270, 50, 20, this));
		this.setCopyright(TransparentLabel.createLabel("Copyright (c) by Jonas Lampe, Alexander Sochart", 100, 200, 500, 50, 20, this));
		this.frame.getLabels().add(this.getBuildName());
		this.frame.getLabels().add(this.getBuildID());
		this.frame.getLabels().add(this.getCopyright());
	}

	/**
	 * renders the graphics object
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

	public MainFrame getFrame() {
		return this.frame;
	}

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
	 * @return the buildName
	 */
	public TransparentLabel getBuildName() {
		return this.buildName;
	}

	/**
	 * @param buildName
	 *            the buildName to set
	 */
	public void setBuildName(TransparentLabel buildName) {
		this.buildName = buildName;
	}

	/**
	 * @return the buildID
	 */
	public TransparentLabel getBuildID() {
		return this.buildID;
	}

	/**
	 * @param buildID
	 *            the buildID to set
	 */
	public void setBuildID(TransparentLabel buildID) {
		this.buildID = buildID;
	}

	/**
	 * @return the copyright
	 */
	public TransparentLabel getCopyright() {
		return this.copyright;
	}

	/**
	 * @param copyright
	 *            the copyright to set
	 */
	public void setCopyright(TransparentLabel copyright) {
		this.copyright = copyright;
	}

}
