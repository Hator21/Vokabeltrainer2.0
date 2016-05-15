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

	public InfoPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiﬂ.png"));
		} catch (IOException ex) {}
		createLabel();
	}

	public void createLabel() {
		setBuildName(TransparentLabel.createLabel("Vokabeltrainer v2", 100, 100, 200, 50, 20, this));
		setBuildID(TransparentLabel.createLabel("Build id: 20160515-0115", 100, 150, 270, 50, 20, this));
		setCopyright(TransparentLabel.createLabel("Copyright (c) by Jonas Lampe, Alexander Sochart", 100, 200, 500, 50, 20, this));
		frame.getLabels().add(getBuildName());
		frame.getLabels().add(getBuildID());
		frame.getLabels().add(getCopyright());
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

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentLabel getBuildName() {
		return buildName;
	}

	public void setBuildName(TransparentLabel buildName) {
		this.buildName = buildName;
	}

	public TransparentLabel getBuildID() {
		return buildID;
	}

	public void setBuildID(TransparentLabel buildID) {
		this.buildID = buildID;
	}

	public TransparentLabel getCopyright() {
		return copyright;
	}

	public void setCopyright(TransparentLabel copyright) {
		this.copyright = copyright;
	}
}
