package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class SearchingPanel extends JPanel {
	private MainFrame						frame;
	private BufferedImage					image;
	private TransparentButton				nextcorrect;
	private TransparentLabel				vokabel;
	private ArrayList<TransparentButton>	vocabels		= new ArrayList<TransparentButton>();
	Random									random			= new Random();
	private VokabelButtonListener			buttonListener	= new VokabelButtonListener();

	public SearchingPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiß.png"));
		} catch (IOException ex) {}
		createButtons();
		setNextcorrect(TransparentButton.createButton("Prüfen", 828, 600, 200, 44, 20, 0, (e -> {
			System.out.println("Du Hurensohn!!!!1111elf");
		}), this));
		frame.getButtons().add(getNextcorrect());

		setVokabel(TransparentLabel.createLabel("Suche: vokabel", 0, 600, 200, 44, 20, this));
		frame.getLabels().add(getVokabel());

	}

	public void createButtons() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int random = zufallszahl(0, 60) - 30;
				vocabels.add(TransparentButton.createButton("Vokabel " + i + "-" + j, 205 * i + 4, 115 * j + 4, 200, 115, 20, 0, random, buttonListener, "vokabel_" + i + "_" + j, this));
			}
		}
		frame.getButtons().addAll(vocabels);
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

	public int zufallszahl(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	public TransparentButton getNextcorrect() {
		return nextcorrect;
	}

	public void setNextcorrect(TransparentButton nextcorrect) {
		this.nextcorrect = nextcorrect;
	}

	public TransparentLabel getVokabel() {
		return vokabel;
	}

	public void setVokabel(TransparentLabel vokabel) {
		this.vokabel = vokabel;
	}

	private class VokabelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if (actionCommand.startsWith("vokabel_")) {
				int x = Integer.valueOf(actionCommand.split("_")[1]);
				int y = Integer.valueOf(actionCommand.split("_")[2]);
				System.out.println(((TransparentButton) (e.getSource())).getText());
			}
		}
	}
}
