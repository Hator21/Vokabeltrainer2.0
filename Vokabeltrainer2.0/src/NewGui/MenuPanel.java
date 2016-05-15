package NewGui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

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

	/**
	 * create the frame
	 * 
	 * @param frame
	 */
	public MenuPanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(1, 31, 250, 688);

		try {
			this.image = ImageIO.read(new File("img/menu.png"));
		} catch (IOException ex) {}

		this.setLearn(TransparentLabel.createLabel("Lernen", 0, 0, 250, 44, 30, this));
		frame.getLabels().add(this.getLearn());

		this.setLection(TransparentButton.createButton("Lektionen", 0, 45, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(1).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getLection());

		this.setVocabeltest(TransparentButton.createButton("Vokabeltest", 0, 90, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(3).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("Einstellungen");
		}), this));
		frame.getButtons().add(this.getVocabeltest());

		this.setSearching(TransparentButton.createButton("Suchspiel", 0, 135, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(5).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getSearching());

		this.setSpelling(TransparentButton.createButton("Buchstabieren", 0, 180, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(7).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getSpelling());

		this.setEditS(TransparentButton.createButton("Sprache Verwalten", 0, 229, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(9).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Verwalten");
			frame.getHeadingbar().getHeadingLabelR().setText("");
			frame.getEditSPanel().createLectionList();
			frame.getEditSPanel().loadTable();
		}), this));
		frame.getButtons().add(this.getEditS());

		this.setSettings(TransparentButton.createButton("Einstellungen", 0, 274, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(10).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Einstellungen");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getSettings());

		this.setStatistics(TransparentButton.createButton("Statistiken", 0, 319, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(11).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Statistiken");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getStatistics());

		this.setHelp(TransparentButton.createButton("Hilfe", 0, 364, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(12).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Hilfe");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getHelp());

		this.setInfo(TransparentButton.createButton("Info", 0, 409, 250, 45, 20, 0, (e -> {
			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}
			frame.getPanelList().get(13).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Info");
			frame.getHeadingbar().getHeadingLabelR().setText("");
		}), this));
		frame.getButtons().add(this.getInfo());

		this.setExit(TransparentButton.createButton("Beenden", 0, 627, 250, 60, 30, 0, (e -> {
			frame.getBear().Close();
			try {
				FileOutputStream fos = new FileOutputStream("data/data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(frame.getLanguageCombi());
				oos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				frame.getStats().write(frame.getStats().getStat());
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			System.exit(1);
		}), this));
		frame.getButtons().add(this.getExit());
	}

	/**
	 * renders the graphics object
	 */
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
	 * @return the isr
	 */
	public InputStreamReader getIsr() {
		return this.isr;
	}

	/**
	 * @param isr
	 *            the isr to set
	 */
	public void setIsr(InputStreamReader isr) {
		this.isr = isr;
	}

	/**
	 * @return the br
	 */
	public BufferedReader getBr() {
		return this.br;
	}

	/**
	 * @param br
	 *            the br to set
	 */
	public void setBr(BufferedReader br) {
		this.br = br;
	}

	/**
	 * @return the lection
	 */
	public TransparentButton getLection() {
		return this.lection;
	}

	/**
	 * @param lection
	 *            the lection to set
	 */
	public void setLection(TransparentButton lection) {
		this.lection = lection;
	}

	/**
	 * @return the vocabeltest
	 */
	public TransparentButton getVocabeltest() {
		return this.vocabeltest;
	}

	/**
	 * @param vocabeltest
	 *            the vocabeltest to set
	 */
	public void setVocabeltest(TransparentButton vocabeltest) {
		this.vocabeltest = vocabeltest;
	}

	/**
	 * @return the searching
	 */
	public TransparentButton getSearching() {
		return this.searching;
	}

	/**
	 * @param searching
	 *            the searching to set
	 */
	public void setSearching(TransparentButton searching) {
		this.searching = searching;
	}

	/**
	 * @return the spelling
	 */
	public TransparentButton getSpelling() {
		return this.spelling;
	}

	/**
	 * @param spelling
	 *            the spelling to set
	 */
	public void setSpelling(TransparentButton spelling) {
		this.spelling = spelling;
	}

	/**
	 * @return the editS
	 */
	public TransparentButton getEditS() {
		return this.editS;
	}

	/**
	 * @param editS
	 *            the editS to set
	 */
	public void setEditS(TransparentButton editS) {
		this.editS = editS;
	}

	/**
	 * @return the settings
	 */
	public TransparentButton getSettings() {
		return this.settings;
	}

	/**
	 * @param settings
	 *            the settings to set
	 */
	public void setSettings(TransparentButton settings) {
		this.settings = settings;
	}

	/**
	 * @return the statistics
	 */
	public TransparentButton getStatistics() {
		return this.statistics;
	}

	/**
	 * @param statistics
	 *            the statistics to set
	 */
	public void setStatistics(TransparentButton statistics) {
		this.statistics = statistics;
	}

	/**
	 * @return the help
	 */
	public TransparentButton getHelp() {
		return this.help;
	}

	/**
	 * @param help
	 *            the help to set
	 */
	public void setHelp(TransparentButton help) {
		this.help = help;
	}

	/**
	 * @return the info
	 */
	public TransparentButton getInfo() {
		return this.info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(TransparentButton info) {
		this.info = info;
	}

	/**
	 * @return the exit
	 */
	public TransparentButton getExit() {
		return this.exit;
	}

	/**
	 * @param exit
	 *            the exit to set
	 */
	public void setExit(TransparentButton exit) {
		this.exit = exit;
	}

	/**
	 * @return the learn
	 */
	public TransparentLabel getLearn() {
		return this.learn;
	}

	/**
	 * @param learn
	 *            the learn to set
	 */
	public void setLearn(TransparentLabel learn) {
		this.learn = learn;
	}

}
