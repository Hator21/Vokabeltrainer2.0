package NewGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class LearningPanel extends JPanel {

	private MainFrame			frame;
	private BufferedImage		image;
	private JTextField			speech1Text, speech2Text;
	private TransparentLabel	speech1Label, speech2Label, correct, countRight, countWrong, average;
	private String				sprache1	= "Deutsch", sprache2 = "Englisch", vokabel = "vokabel";
	private String				test		= "Überprüfen";
	private TransparentButton	check;
	private int					right, counts = 10;

	public LearningPanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}

		this.setCheck(TransparentButton.createButton(this.test, 120, 320, 200, 40, 30, 0, (e -> {
			frame.getCheck().check(this.speech2Text.getText(), frame.getVokabeln(), this.vokabel, this.right);
			this.speech1Text.setText(frame.getCheck().vok());
			this.speech2Text.setText("");
		}), this));
		frame.getButtons().add(this.getCheck());

		this.setSpeech1Label(TransparentLabel.createLabel("Deutsch", 20, 200, 100, 40, 20, this));
		this.setSpeech2Label(TransparentLabel.createLabel("Englisch", 20, 260, 100, 40, 20, this));
		this.setCorrect(TransparentLabel.createLabel("Richtig", 320, 260, 70, 40, 20, this));
		this.setCountRight(TransparentLabel.createLabel("Richtige..", 50, 550, 100, 40, 20, this));
		this.setCountWrong(TransparentLabel.createLabel("Falsche..", 170, 550, 100, 40, 20, this));
		this.setAverage(TransparentLabel.createLabel("Durchschnitt..", 290, 550, 150, 40, 20, this));
		frame.getLabels().add(this.getSpeech1Label());
		frame.getLabels().add(this.getSpeech2Label());
		frame.getLabels().add(this.getCorrect());
		frame.getLabels().add(this.getCountRight());
		frame.getLabels().add(this.getCountWrong());
		frame.getLabels().add(this.getAverage());

		this.speech1Text = new JTextField(this.vokabel);
		this.speech1Text.setBounds(120, 200, 200, 40);
		this.speech1Text.setOpaque(true);
		this.speech1Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.speech1Text.setEditable(false);
		this.add(this.speech1Text);

		this.speech2Text = new JTextField("");
		this.speech2Text.setBounds(120, 260, 200, 40);
		this.speech2Text.setOpaque(true);
		this.speech2Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.speech2Text.setEditable(true);
		this.add(this.speech2Text);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	protected String getSprache1() {
		return this.sprache1;
	}

	protected void setSprache1(String sprache1) {
		this.sprache1 = sprache1;
	}

	protected String getSprache2() {
		return this.sprache2;
	}

	protected void setSprache2(String sprache2) {
		this.sprache2 = sprache2;
	}

	protected String getVokabel() {
		return this.vokabel;
	}

	protected void setVokabel(String vokabel) {
		this.vokabel = vokabel;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getCounts() {
		return this.counts;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getRight() {
		return this.right;
	}

	protected TransparentButton getCheck() {
		return this.check;
	}

	protected void setCheck(TransparentButton check) {
		this.check = check;
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentLabel getSpeech2Label() {
		return this.speech2Label;
	}

	public void setSpeech2Label(TransparentLabel speech2Label) {
		this.speech2Label = speech2Label;
	}

	public TransparentLabel getSpeech1Label() {
		return this.speech1Label;
	}

	public void setSpeech1Label(TransparentLabel speech1Label) {
		this.speech1Label = speech1Label;
	}

	public TransparentLabel getCorrect() {
		return this.correct;
	}

	public void setCorrect(TransparentLabel correct) {
		this.correct = correct;
	}

	public TransparentLabel getCountRight() {
		return this.countRight;
	}

	public void setCountRight(TransparentLabel countRight) {
		this.countRight = countRight;
	}

	public TransparentLabel getCountWrong() {
		return this.countWrong;
	}

	public void setCountWrong(TransparentLabel countWrong) {
		this.countWrong = countWrong;
	}

	public TransparentLabel getAverage() {
		return this.average;
	}

	public void setAverage(TransparentLabel average) {
		this.average = average;
	}

}
