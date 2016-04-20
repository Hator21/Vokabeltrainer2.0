package subGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
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
	private String							sprache1	= "Deutsch", sprache2 = "Englisch", vokabel = "vokabel";

	public internalLearningPanel(MainFrame frame, LectionPanel lPanel) {
		this.frame = frame;
		this.lPanel = lPanel;
		this.setLayout(null);
		try {
			image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.setBounds(251, 66, 1028, 653);
		buttons.add(new TransperantButton("Überprüfen", 120, 320, 200, 40, 30, 0));
		this.add(buttons.get(0));
		buttons.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("Überprüfen!");
			}
		});
		labels.add(new JLabel(sprache1));
		labels.get(0).setBounds(20, 200, 100, 40);
		labels.add(new JLabel(sprache2));
		labels.get(1).setBounds(20, 260, 100, 40);
		labels.add(new JLabel("Richtig"));
		labels.get(2).setBounds(330, 260, 50, 40);
		labels.add(new JLabel("richtige.."));
		labels.get(3).setBounds(50, 550, 100, 40);
		labels.add(new JLabel("falsche.."));
		labels.get(4).setBounds(170, 550, 100, 40);
		labels.add(new JLabel("durchschnitt.."));
		labels.get(5).setBounds(290, 550, 150, 40);
		units.add(new JTextField(vokabel));
		units.add(new JTextField(""));
		for (int i = 0; i < 2; i++) {
			units.get(i).setBounds(120, 60 * i + 200, 200, 40);
			units.get(i).setOpaque(true);
			units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(units.get(i));
			labels.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(labels.get(i));

		}
		units.get(0).setEditable(false);
		this.add(labels.get(2));
		labels.get(2).setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.add(labels.get(3));
		labels.get(3).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(labels.get(4));
		labels.get(4).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(labels.get(5));
		labels.get(5).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
		for (TransperantButton p : buttons)
			p.render(g);
	}

	protected ArrayList<TransperantButton> getButtons() {
		return buttons;
	}

	protected void setButtons(ArrayList<TransperantButton> buttons) {
		this.buttons = buttons;
	}

	protected ArrayList<JTextField> getUnits() {
		return units;
	}

	protected void setUnits(ArrayList<JTextField> units) {
		this.units = units;
	}

	protected ArrayList<JLabel> getLabels() {
		return labels;
	}

	protected void setLabels(ArrayList<JLabel> labels) {
		this.labels = labels;
	}

	protected String getSprache1() {
		return sprache1;
	}

	protected void setSprache1(String sprache1) {
		this.sprache1 = sprache1;
	}

	protected String getSprache2() {
		return sprache2;
	}

	protected void setSprache2(String sprache2) {
		this.sprache2 = sprache2;
	}

	protected String getVokabel() {
		return vokabel;
	}

	protected void setVokabel(String vokabel) {
		this.vokabel = vokabel;
	}

}
