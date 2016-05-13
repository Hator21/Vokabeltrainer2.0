package NewGui;

import java.awt.Color;
import java.awt.Component;
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
import Trainer.Vokabel;
import utils.CoordSearching;

@SuppressWarnings("serial")
public class SearchingPanel extends JPanel {
	private MainFrame						frame;
	private BufferedImage					image;
	private TransparentButton				nextcorrect;
	private TransparentLabel				vokabel;
	private ArrayList<TransparentButton>	vocabels		= new ArrayList<TransparentButton>();
	Random									random			= new Random();
	private VokabelButtonListener			buttonListener	= new VokabelButtonListener();
	private Vokabel							askedVoc		= null;
	private ArrayList<CoordSearching>		coords			= new ArrayList<CoordSearching>();

	public SearchingPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiﬂ.png"));
		} catch (IOException ex) {}
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				this.coords.add(new CoordSearching(x, y, false));
			}
		}

		this.setNextcorrect(TransparentButton.createButton("N‰chste", 828, 600, 200, 44, 20, 0, (e -> {
			for (Component c : this.getComponents()) {
				if (!((TransparentButton) (e.getSource())).equals(c))
					this.remove(c);
			}
			vocabels.clear();
			this.revalidate();
			frame.getSearchingPanel().createButtons();
			frame.getSearchingPanel().createLabel();
			this.repaint();

		}), this));
		frame.getButtons().add(this.getNextcorrect());
		frame.getLabels().add(this.getVokabel());
	}

	public void createButtons() {
		ArrayList<Vokabel> vocs = this.frame.getTestVokabeln();
		if (vocs.size() < 25) {
			// TODO: Verteilen
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					int random = this.zufallszahl(0, 60) - 30;
					if (((x * 5) + y) < vocs.size()) {
						this.vocabels.add(TransparentButton.createButton(vocs.get(((x * 5) + y)).getVocabTranslation(), (210 * x) + 4, (115 * y) + 4, 200, 115, 20, 0, random, this.buttonListener, vocs.get(((x * 5) + y)).getVocabTranslation(), this));
					}
				}
			}
		} else {
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					int random = this.zufallszahl(0, 60) - 30;
					if (((x * 5) + y) < vocs.size()) {
						this.vocabels.add(TransparentButton.createButton(vocs.get(((x * 5) + y)).getVocabTranslation(), (205 * x) + 4, (115 * y) + 4, 200, 115, 20, 0, random, this.buttonListener, vocs.get(((x * 5) + y)).getVocabTranslation(), this));
					}
				}
			}
		}
		this.frame.getButtons().addAll(this.vocabels);
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

	public int zufallszahl(int min, int max) {
		return this.random.nextInt((max - min) + 1) + min;
	}

	public TransparentButton getNextcorrect() {
		return this.nextcorrect;
	}

	public void setNextcorrect(TransparentButton nextcorrect) {
		this.nextcorrect = nextcorrect;
	}

	public TransparentLabel getVokabel() {
		return this.vokabel;
	}

	public void setVokabel(TransparentLabel vokabel) {
		this.vokabel = vokabel;
	}

	private class VokabelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(((TransparentButton) (e.getSource())).getText());
			if (SearchingPanel.this.askedVoc.getVocabTranslation().equalsIgnoreCase(((TransparentButton) (e.getSource())).getText())) {
				// TODO: richtig
				System.out.println("RICHTIG!");
				((TransparentButton) e.getSource()).setBackgroundColor(Color.GREEN);
			} else {
				System.out.println("FALSCH FAK ME!");
				((TransparentButton) e.getSource()).setBackgroundColor(Color.RED);
			}
		}
	}

	public void createLabel() {
		if (this.frame.getTestVokabeln().size() > 0) {
			this.askedVoc = this.frame.getCheck().vok(1, this.frame.getBear().getPr‰1(), this.frame.getBear().getPr‰2()).get(this.frame.getCheck().random(this.frame.getTestVokabeln().size()));
			this.setVokabel(TransparentLabel.createLabel("Suche: " + this.askedVoc.getVocabOrigin(), 0, 600, 200, 44, 20, this));
		}
	}
}
