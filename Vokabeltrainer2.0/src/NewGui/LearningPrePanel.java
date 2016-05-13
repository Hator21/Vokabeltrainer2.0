package NewGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Components.TransparentButton;

@SuppressWarnings("serial")
public class LearningPrePanel extends JPanel {

	private MainFrame				frame;
	private BufferedImage			image;
	private TransparentButton		learning;
	private ArrayList<JCheckBox>	units	= new ArrayList<JCheckBox>();
	private JComboBox<String>		combobox;
	// private String[] comboBoxListe;

	public LearningPrePanel(MainFrame frame) {

		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);

		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.createComboBox(frame.add2Language());
		frame.getBear().putPr�fix(this.combobox);
		this.createCheckboxes(frame.getBear().getLektions());

		this.setLearning(TransparentButton.createButton("Lernen", 105, 550, 150, 40, 30, 0, (e -> {
			frame.getLek().clear();
			for (int i = 0; i < frame.getBear().getLektion(); i++) {
				if (this.units.get(i).isSelected() == true) {
					frame.getLek().add(i + 1);
				}
			}

			frame.getTestVokabeln().clear();
			frame.getCheck().newGame(frame.getVokabeln());
			frame.getTestVokabeln().addAll(frame.getCheck().vok(frame.getLek().size(), frame.getBear().getPr�1(), frame.getBear().getPr�2()));
			frame.getLearningPanel().setCounts(frame.getTestVokabeln().size());
			frame.getLearningPanel().getSpeech1Text().setText(frame.getCheck().vok(true, true));

			for (JPanel p : frame.getPanelList()) {
				p.setVisible(false);
			}

			frame.getPanelList().get(2).setVisible(true);
			frame.getHeadingbar().getHeadingLabelL().setText("Lernen");
		}), this));
		frame.getButtons().add(this.getLearning());

	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public void createCheckboxes(ArrayList<Integer> list) {
		for (int i = 0; i < 11; i++) {
			this.units.add(new JCheckBox("Lektion " + (i + 1)));
			this.units.get(i).setBounds(120, (40 * i) + 100, 200, 40);
			if (list.contains(i + 1)) {
				this.units.get(i).setVisible(true);
			} else {
				this.units.get(i).setVisible(false);
			}
			this.units.get(i).setOpaque(false);
			this.units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(this.units.get(i));
		}
	}

	public void createComboBox(String[] list) {
		this.combobox = new JComboBox<String>(list);
		this.combobox.setBounds(80, 50, 200, 40);
		this.combobox.setOpaque(false);
		this.combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(this.combobox);
		this.combobox.addActionListener(arg0 -> {
			LearningPrePanel.this.frame.getBear().putPr�fix(LearningPrePanel.this.combobox);
			ArrayList<Integer> list1 = LearningPrePanel.this.frame.getBear().getLektions();
			System.out.println("list -> " + list1);
			for (int i = 0; i < LearningPrePanel.this.units.size(); i++) {
				if (list1.contains(i + 1)) {
					LearningPrePanel.this.units.get(i).setVisible(true);
				} else {
					LearningPrePanel.this.units.get(i).setVisible(false);
				}
			}
			this.repaint();
		});
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	protected TransparentButton getLearning() {
		return this.learning;
	}

	protected void setLearning(TransparentButton learning) {
		this.learning = learning;
	}

}
