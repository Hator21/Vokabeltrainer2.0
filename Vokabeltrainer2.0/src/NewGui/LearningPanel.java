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
		this.vokabel = frame.getCheck().vok(this.vokabel, frame.getVokabeln());

		setCheck(TransparentButton.createButton(this.test, 120, 320, 200, 40, 30, 0, (e -> {
			frame.getCheck().check(speech2Text.getText(), frame.getVokabeln(), this.vokabel, this.right);
			speech1Text.setText(this.vokabel = frame.getCheck().vok(this.vokabel, frame.getVokabeln()));
			speech2Text.setText("");
		}), this));
		frame.getButtons().add(getCheck());

		setSpeech1Label(TransparentLabel.createLabel("Deutsch", 20, 200, 100, 40, 20, this));
		setSpeech2Label(TransparentLabel.createLabel("Englisch", 20, 260, 100, 40, 20, this));
		setCorrect(TransparentLabel.createLabel("Richtig", 320, 260, 70, 40, 20, this));
		setCountRight(TransparentLabel.createLabel("Richtige..", 50, 550, 100, 40, 20, this));
		setCountWrong(TransparentLabel.createLabel("Falsche..", 170, 550, 100, 40, 20, this));
		setAverage(TransparentLabel.createLabel("Durchschnitt..", 290, 550, 150, 40, 20, this));
		frame.getLabels().add(getSpeech1Label());
		frame.getLabels().add(getSpeech2Label());
		frame.getLabels().add(getCorrect());
		frame.getLabels().add(getCountRight());
		frame.getLabels().add(getCountWrong());
		frame.getLabels().add(getAverage());

		speech1Text = new JTextField(this.vokabel);
		speech1Text.setBounds(120, 200, 200, 40);
		speech1Text.setOpaque(true);
		speech1Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		speech1Text.setEditable(false);
		this.add(speech1Text);

		speech2Text = new JTextField("");
		speech2Text.setBounds(120, 260, 200, 40);
		speech2Text.setOpaque(true);
		speech2Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		speech2Text.setEditable(true);
		this.add(speech2Text);
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
		return check;
	}

	protected void setCheck(TransparentButton check) {
		this.check = check;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentLabel getSpeech2Label() {
		return speech2Label;
	}

	public void setSpeech2Label(TransparentLabel speech2Label) {
		this.speech2Label = speech2Label;
	}

	public TransparentLabel getSpeech1Label() {
		return speech1Label;
	}

	public void setSpeech1Label(TransparentLabel speech1Label) {
		this.speech1Label = speech1Label;
	}

	public TransparentLabel getCorrect() {
		return correct;
	}

	public void setCorrect(TransparentLabel correct) {
		this.correct = correct;
	}

	public TransparentLabel getCountRight() {
		return countRight;
	}

	public void setCountRight(TransparentLabel countRight) {
		this.countRight = countRight;
	}

	public TransparentLabel getCountWrong() {
		return countWrong;
	}

	public void setCountWrong(TransparentLabel countWrong) {
		this.countWrong = countWrong;
	}

	public TransparentLabel getAverage() {
		return average;
	}

	public void setAverage(TransparentLabel average) {
		this.average = average;
	}

}
