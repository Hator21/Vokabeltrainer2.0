package NewGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private String				sprache1	= "Deutsch", sprache2 = "Englisch", vokabel = "";
	private String				test		= "Überprüfen";
	private TransparentButton	check;
	private int					right		= 0, bright = 0, wrong = 0, counts = 10;
	private ImageIcon			right_wrong;

	public LearningPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}

		this.setCheck(TransparentButton.createButton(this.test, 120, 320, 200, 40, 30, 0, (e -> {
			if (this.getCheck().getText().equals("Neustart")) {
				frame.getTestVokabeln().clear();
				frame.getLek().clear();
				frame.getCheck().newGame(frame.getVokabeln());
				this.speech2Text.setEditable(true);
				this.getCheck().setText("Überprüfen");

				for (JPanel p : frame.getPanelList()) {
					p.setVisible(false);
				}
				frame.getPanelList().get(1).setVisible(true);
				frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
				frame.getHeadingbar().getHeadingLabelR().setText("");
			}
			if (this.counts == 1) {
				this.bright = this.right;
				this.right = frame.getCheck().check(this.speech2Text.getText(), this.speech1Text.getText(), this.right);
				if (this.right > this.bright) {
					this.getCorrect().setImage("img/right.png");
					this.getCountRight().setText("Richtige: " + this.right);
				} else {
					this.wrong++;
					this.getCorrect().setImage("img/wrong.png");
					this.getCountWrong().setText("Falsche: " + this.wrong);
				}
				if (this.right != 0) {
					this.getAverage().setText("Durchschnitt: " + (((this.wrong + this.right) * 100) / this.right) + "%");
				} else {
					this.getAverage().setText("Durchschnitt: 0%");
				}
				this.counts--;
				this.speech1Text.setText("");
				this.speech2Text.setText("");
				this.speech2Text.setEditable(false);
				this.getCheck().setText("Neustart");
			} else if (this.counts != 0) {
				this.bright = this.right;
				this.right = frame.getCheck().check(this.speech2Text.getText(), this.speech1Text.getText(), this.right);
				if (this.right > this.bright) {
					this.getCorrect().setImage("img/right.png");
					this.getCountRight().setText("Richtige: " + this.right);
				} else {
					this.wrong++;
					this.getCorrect().setImage("img/wrong.png");
					this.getCountWrong().setText("Falsche: " + this.wrong);
				}
				if (this.right != 0) {
					this.getAverage().setText("Durchschnitt: " + ((this.right * 100) / (this.wrong + this.right)) + "%");
				} else {
					this.getAverage().setText("Durchschnitt: 0%");
				}
				this.counts--;
				this.speech1Text.setText(frame.getCheck().vok(true, true));
				this.speech2Text.setText("");
			}
			this.repaint();

		}), this));
		frame.getButtons().add(this.getCheck());

		this.setSpeech1Label(TransparentLabel.createLabel("Deutsch", 20, 200, 100, 40, 20, this));
		this.setSpeech2Label(TransparentLabel.createLabel("Englisch", 20, 260, 100, 40, 20, this));
		this.setCorrect(TransparentLabel.createLabel("hallo", 320, 260, 40, 40, 20, true, this));
		this.setCountRight(TransparentLabel.createLabel("Richtige: 0", 50, 550, 120, 40, 20, this));
		this.setCountWrong(TransparentLabel.createLabel("Falsche: 0", 170, 550, 120, 40, 20, this));
		this.setAverage(TransparentLabel.createLabel("Durchschnitt: 0", 290, 550, 200, 40, 20, this));
		frame.getLabels().add(this.getSpeech1Label());
		frame.getLabels().add(this.getSpeech2Label());
		frame.getLabels().add(this.getCorrect());
		frame.getLabels().add(this.getCountRight());
		frame.getLabels().add(this.getCountWrong());
		frame.getLabels().add(this.getAverage());

		this.speech1Text = new JTextField();
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
		this.createHelp();
	}

	/**
	 * @return the bright
	 */
	public int getBright() {
		return this.bright;
	}

	/**
	 * @param bright
	 *            the bright to set
	 */
	public void setBright(int bright) {
		this.bright = bright;
	}

	/**
	 * @return the wrong
	 */
	public int getWrong() {
		return this.wrong;
	}

	/**
	 * @param wrong
	 *            the wrong to set
	 */
	public void setWrong(int wrong) {
		this.wrong = wrong;
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

	/**
	 * @return the speech1Text
	 */
	public JTextField getSpeech1Text() {
		return this.speech1Text;
	}

	/**
	 * @param speech1Text
	 *            the speech1Text to set
	 */
	public void setSpeech1Text(JTextField speech1Text) {
		this.speech1Text = speech1Text;
	}

	/**
	 * @return the speech2Text
	 */
	public JTextField getSpeech2Text() {
		return this.speech2Text;
	}

	/**
	 * @param speech2Text
	 *            the speech2Text to set
	 */
	public void setSpeech2Text(JTextField speech2Text) {
		this.speech2Text = speech2Text;
	}

	public void createHelp() {
		this.frame.getHelper().add(TransparentLabel.createLabel("1. Gib die geforderte Vokabel ein!", 30, 150, 350, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("2. Klicke auf \"Überprüfen\"!", 70, 370, 300, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("3. Hier siehst du deine Statistik!", 50, 500, 400, 30, 18, this));
	}

}
