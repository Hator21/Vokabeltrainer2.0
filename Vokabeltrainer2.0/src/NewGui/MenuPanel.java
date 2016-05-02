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

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	private MainFrame frame;
	private BufferedImage image;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(this.isr);

	public MenuPanel(MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(1, 31, 250, 688);

		try {
			this.image = ImageIO.read(new File("img/menu.png"));
		} catch (IOException ex) {
		}

		TransparentButton.createButton("Lektionen", 0, 45, 250, 45, 20, 0, (e -> {
			for(JPanel p : frame.getPanelList()){
				p.setVisible(false);
			}
			frame.getPanelList().get(0).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
		}), this);

		TransparentButton.createButton("Lernen", 0, 0, 250, 44, 30, 0, (e -> {
			
		}), this);

		TransparentButton.createButton("Vokabeltest", 0, 90, 250, 45, 20, 0, (e -> {
			frame.getVocabelPrePanel().setVisible(true);
			frame.getiLectionPanel().setVisible(false);
			frame.getMainMenuImage().setVisible(false);
			frame.getiLearningPanel().setVisible(false);
			frame.getHeadingbar().getHeadingLabelL().setText("Lektion auswählen");
			frame.getHeadingbar().getHeadingLabelR().setText("Einstellungen");
		}), this);

		TransparentButton.createButton("Suchspiel", 0, 135, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Buchstabieren", 0, 180, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Sprache Verwalten", 0, 229, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Einstellungen", 0, 274, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Statistiken", 0, 319, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Hilfe", 0, 364, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Info", 0, 409, 250, 45, 20, 0, (e -> {
			System.out.println("FUCK ME");
		}), this);

		TransparentButton.createButton("Beenden", 0, 627, 250, 60, 30, 0, (e -> {

			System.exit(1);
		}), this);
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
}
