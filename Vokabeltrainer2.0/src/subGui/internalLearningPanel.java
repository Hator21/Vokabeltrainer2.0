package subGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainGui.LectionPanel;
import mainGui.MainFrame;
import mainGui.TransperantButton;

@SuppressWarnings("serial")
public class internalLearningPanel extends JPanel {

	private MainFrame						frame;
	private LectionPanel					lPanel;
	private BufferedImage					image;
	private int								n			= 0;
	private ArrayList<TransperantButton>	buttons		= new ArrayList<TransperantButton>();
	private ArrayList<JTextField>			units		= new ArrayList<JTextField>();
	private ArrayList<JLabel>				labels		= new ArrayList<JLabel>();
	private String							sprache1	= "Deutsch",
													sprache2 = "Englisch", vokabel = "vokabel";

	public internalLearningPanel(MainFrame frame, LectionPanel lPanel) {
		this.frame = frame;
		this.lPanel = lPanel;
		this.setLayout(null);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.setBounds(251, 66, 1028, 653);
		TransperantButton.createButton("�berpr�fen", 120, 320, 200, 40, 30, 0, (e -> {
			System.out.println("ICHB BIN KACKE");
		}), this);
		this.labels.add(new JLabel(this.sprache1));
		this.labels.get(0).setBounds(20, 200, 100, 40);
		this.labels.add(new JLabel(this.sprache2));
		this.labels.get(1).setBounds(20, 260, 100, 40);
		this.labels.add(new JLabel("Richtig"));
		this.labels.get(2).setBounds(330, 260, 50, 40);
		this.labels.add(new JLabel("richtige.."));
		this.labels.get(3).setBounds(50, 550, 100, 40);
		this.labels.add(new JLabel("falsche.."));
		this.labels.get(4).setBounds(170, 550, 100, 40);
		this.labels.add(new JLabel("durchschnitt.."));
		this.labels.get(5).setBounds(290, 550, 150, 40);
		this.units.add(new JTextField(this.vokabel));
		this.units.add(new JTextField(""));
		for (int i = 0; i < 2; i++) {
			this.units.get(i).setBounds(120, (60 * i) + 200, 200, 40);
			this.units.get(i).setOpaque(true);
			this.units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.units.get(i));
			this.labels.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.labels.get(i));

		}
		this.units.get(0).setEditable(false);
		this.add(this.labels.get(2));
		this.labels.get(2).setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.add(this.labels.get(3));
		this.labels.get(3).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.labels.get(4));
		this.labels.get(4).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.labels.get(5));
		this.labels.get(5).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
		/*
		 * for (TransperantButton p : buttons)
		 * p.render(g);
		 */
	}

	protected ArrayList<TransperantButton> getButtons() {
		return this.buttons;
	}

	protected void setButtons(ArrayList<TransperantButton> buttons) {
		this.buttons = buttons;
	}

	protected ArrayList<JTextField> getUnits() {
		return this.units;
	}

	protected void setUnits(ArrayList<JTextField> units) {
		this.units = units;
	}

	protected ArrayList<JLabel> getLabels() {
		return this.labels;
	}

	protected void setLabels(ArrayList<JLabel> labels) {
		this.labels = labels;
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

}