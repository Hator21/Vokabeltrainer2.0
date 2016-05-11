package NewGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class SpellingPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private TransparentLabel	vocabel, infoLabel;
	private TransparentButton	voc1, voc2, voc3, voc4;

	public SpellingPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.createLabel();
		this.createButton();
	}

	public void createLabel() {
		this.setVocabel(TransparentLabel.createLabel("Vokabel", 115, 300, 200, 50, 20, this));
		this.setInfoLabel(TransparentLabel.createLabel("Wie wird das denn nun geschrieben?!", 10, 50, 500, 50, 30, this));
		this.frame.getLabels().add(this.getVocabel());
		this.frame.getLabels().add(this.getInfoLabel());
	}

	public void createButton() {
		this.setVoc1(TransparentButton.createButton("Vokabell", 10, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		this.frame.getButtons().add(this.getVoc1());
		this.setVoc2(TransparentButton.createButton("Vukabel", 220, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		this.frame.getButtons().add(this.getVoc2());
		this.setVoc3(TransparentButton.createButton("Vokabel", 10, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		this.frame.getButtons().add(this.getVoc3());
		this.setVoc4(TransparentButton.createButton("Vukabell", 220, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		this.frame.getButtons().add(this.getVoc4());
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
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentLabel getVocabel() {
		return this.vocabel;
	}

	public void setVocabel(TransparentLabel vocabel) {
		this.vocabel = vocabel;
	}

	public TransparentLabel getInfoLabel() {
		return this.infoLabel;
	}

	public void setInfoLabel(TransparentLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	public TransparentButton getVoc1() {
		return this.voc1;
	}

	public void setVoc1(TransparentButton voc1) {
		this.voc1 = voc1;
	}

	public TransparentButton getVoc2() {
		return this.voc2;
	}

	public void setVoc2(TransparentButton voc2) {
		this.voc2 = voc2;
	}

	public TransparentButton getVoc3() {
		return this.voc3;
	}

	public void setVoc3(TransparentButton voc3) {
		this.voc3 = voc3;
	}

	public TransparentButton getVoc4() {
		return this.voc4;
	}

	public void setVoc4(TransparentButton voc4) {
		this.voc4 = voc4;
	}
}
