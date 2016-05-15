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
public class VocabeltestPanel extends JPanel {

	private MainFrame			frame;
	private BufferedImage		image;
	private JTextField			speech1Text, speech2Text;
	private TransparentLabel	speech1Label, speech2Label, timerLabel;
	private String				sprache1	= "Deutsch", sprache2 = "Englisch", vokabel = "vokabel";
	private TransparentButton	start, next;
	private int					right, counts = 10;

	/**
	 * creats the pannel
	 * 
	 * @param frame
	 */
	public VocabeltestPanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}

		this.setNext(TransparentButton.createButton("weiter", 120, 320, 200, 40, 30, 0, (e -> {

			if (this.getNext().getText().equals("Neustart")) {
				frame.getTestVokabeln().clear();
				frame.getLek().clear();
				frame.getCheck().newGame(frame.getVokabeln());
				this.speech2Text.setEditable(true);
				this.getNext().setText("Überprüfen");

				for (JPanel p : frame.getPanelList()) {
					p.setVisible(false);
				}
				frame.getPanelList().get(3).setVisible(true);
				frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
				frame.getHeadingbar().getHeadingLabelR().setText("Einstellungen");
			}
			if (this.counts == 1) {
				this.right = frame.getCheck().check(this.speech2Text.getText(), this.speech1Text.getText(), this.right);
				this.counts--;
				this.speech1Text.setText("");
				this.speech2Text.setText("");
				this.speech2Text.setEditable(false);
				this.getNext().setText("Neustart");
			} else if (this.counts != 0) {
				this.right = frame.getCheck().check(this.speech2Text.getText(), this.speech1Text.getText(), this.right);
				this.counts--;
				this.speech1Text.setText(frame.getCheck().vok(frame.getVocabelPrePanel().getDeengCheckBox().isSelected(), frame.getVocabelPrePanel().getEngdeCheckBox().isSelected()));
				this.speech2Text.setText("");
			}

		}), this));
		frame.getButtons().add(this.getNext());

		this.setStart(TransparentButton.createButton("start", 120, 140, 200, 40, 30, 0, (e -> {
			frame.getTimer().startTimer();
			this.getStart().setEnabled(false);
			this.speech2Text.setEditable(true);
			this.getNext().setEnabled(true);
		}), this));

		frame.getButtons().add(this.getStart());
		this.getStart().setEnabled(true);

		this.setSpeech1Label(TransparentLabel.createLabel(this.sprache1, 20, 200, 100, 40, 20, this));
		frame.getLabels().add(this.getSpeech1Label());
		this.setSpeech2Label(TransparentLabel.createLabel(this.sprache2, 20, 260, 100, 40, 20, this));
		frame.getLabels().add(this.getSpeech2Label());
		this.setTimerLabel(TransparentLabel.createLabel("Übrige Zeit: " + String.valueOf(frame.getVocabelPrePanel().getTimeSlider().getValue()) + ":00", 120, 80, 200, 40, 20, this));
		frame.getLabels().add(this.getTimerLabel());

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
		this.speech2Text.setEditable(false);
		this.add(this.speech2Text);

		this.createHelp();
	}

	/**
	 * paint Component
	 */
	@Override
	public void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public String getSprache1() {
		return this.sprache1;
	}

	public void setSprache1(String sprache1) {
		this.sprache1 = sprache1;
	}

	public String getSprache2() {
		return this.sprache2;
	}

	public void setSprache2(String sprache2) {
		this.sprache2 = sprache2;
	}

	public String getVokabel() {
		return this.vokabel;
	}

	public void setVokabel(String vokabel) {
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

	public TransparentButton getNext() {
		return this.next;
	}

	public void setNext(TransparentButton next) {
		this.next = next;
	}

	public TransparentLabel getTimerLabel() {
		return this.timerLabel;
	}

	public void setTimerLabel(TransparentLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public TransparentLabel getSpeech1Label() {
		return this.speech1Label;
	}

	public void setSpeech1Label(TransparentLabel speech1Label) {
		this.speech1Label = speech1Label;
	}

	public TransparentLabel getSpeech2Label() {
		return this.speech2Label;
	}

	public void setSpeech2Label(TransparentLabel speech2Label) {
		this.speech2Label = speech2Label;
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentButton getStart() {
		return this.start;
	}

	public void setStart(TransparentButton start) {
		this.start = start;
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
		this.frame.getHelper().add(TransparentLabel.createLabel("1. Drücke auf \"Start\" um den Test zu starten!", 10, 30, 425, 30, 18, this));
		this.frame.getHelper().add(TransparentLabel.createLabel("2. Klicke auf \"Weiter\"!", 0, 380, 444, 30, 18, this));
	}
}
