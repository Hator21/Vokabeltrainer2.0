package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	InputStreamReader			isr	= new InputStreamReader(System.in);
	BufferedReader				br	= new BufferedReader(this.isr);

	private TransparentButton	lection, vocabeltest, searching, spelling, editS, settings, statistics, help, info, exit;
	private TransparentLabel	learn;

	public MenuPanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(1, 31, 250, 688);

		try {
			this.image = ImageIO.read(new File("img/menu.png"));
		} catch (IOException ex) {}

		setLearn(TransparentLabel.createLabel("Lernen", 0, 0, 250, 44, 30, this));

		setLection(TransparentButton.createButton("Lektionen", 0, 45, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(1).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
		}), this));

		setVocabeltest(TransparentButton.createButton("Vokabeltest", 0, 90, 250, 45, 20, 0, 10, (e -> {
			frame.getVocabelPrePanel().setVisible(true);
			frame.getiLectionPanel().setVisible(false);
			frame.getMainMenuImage().setVisible(false);
			frame.getiLearningPanel().setVisible(false);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("Einstellungen");
		}), this));

		setSearching(TransparentButton.createButton("Suchspiel", 0, 135, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(5).setVisible(true);
		}), this));

		setSpelling(TransparentButton.createButton("Buchstabieren", 0, 180, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setEditS(TransparentButton.createButton("Sprache Verwalten", 0, 229, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setSettings(TransparentButton.createButton("Einstellungen", 0, 274, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setStatistics(TransparentButton.createButton("Statistiken", 0, 319, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setHelp(TransparentButton.createButton("Hilfe", 0, 364, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setInfo(TransparentButton.createButton("Info", 0, 409, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this));

		setExit(TransparentButton.createButton("Beenden", 0, 627, 250, 60, 30, 0, (e -> {
			System.exit(1);
		}), this));
	}

	public TransparentButton getLection() {
		return lection;
	}

	public void setLection(TransparentButton lection) {
		this.lection = lection;
	}

	public TransparentButton getVocabeltest() {
		return vocabeltest;
	}

	public void setVocabeltest(TransparentButton vocabeltest) {
		this.vocabeltest = vocabeltest;
	}

	public TransparentButton getSearching() {
		return searching;
	}

	public void setSearching(TransparentButton searching) {
		this.searching = searching;
	}

	public TransparentButton getSpelling() {
		return spelling;
	}

	public void setSpelling(TransparentButton spelling) {
		this.spelling = spelling;
	}

	public TransparentButton getEditS() {
		return editS;
	}

	public void setEditS(TransparentButton editS) {
		this.editS = editS;
	}

	public TransparentButton getSettings() {
		return settings;
	}

	public void setSettings(TransparentButton settings) {
		this.settings = settings;
	}

	public TransparentButton getStatistics() {
		return statistics;
	}

	public void setStatistics(TransparentButton statistics) {
		this.statistics = statistics;
	}

	public TransparentButton getHelp() {
		return help;
	}

	public void setHelp(TransparentButton help) {
		this.help = help;
	}

	public TransparentButton getInfo() {
		return info;
	}

	public void setInfo(TransparentButton info) {
		this.info = info;
	}

	public TransparentButton getExit() {
		return exit;
	}

	public void setExit(TransparentButton exit) {
		this.exit = exit;
	}

	public TransparentLabel getLearn() {
		return learn;
	}

	public void setLearn(TransparentLabel learn) {
		this.learn = learn;
	}

	@Override
	protected void paintComponent(Graphics g_) {
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
}
