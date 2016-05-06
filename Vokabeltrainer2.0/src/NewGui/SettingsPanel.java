package NewGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel {
	private MainFrame		frame;
	private BufferedImage	image;
	private JCheckBox		helpActiv, borderActiv;

	public SettingsPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Settings-Hintergrund3.png"));
		} catch (IOException ex) {}

		createCheckBox();

	}

	public void createCheckBox() {
		helpActiv = new JCheckBox("Aktiviere Hilfe-Funktion");
		helpActiv.setBounds(70, 100, 500, 60);
		helpActiv.setOpaque(false);
		helpActiv.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		this.add(helpActiv);
		helpActiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JCheckBox) e.getSource()).isSelected()) {

				}
			}
		});

		borderActiv = new JCheckBox("Zeige Button- und Textgrenzen");
		borderActiv.setBounds(70, 170, 500, 60);
		borderActiv.setOpaque(false);
		borderActiv.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		this.add(borderActiv);
		borderActiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JCheckBox) e.getSource()).isSelected()) {
					for (TransparentLabel t : frame.getLabels())
						t.setColor(new Color(0, 0, 255, 255));
					for (TransparentButton t : frame.getButtons())
						t.setColor(new Color(255, 0, 0, 255));
				} else {
					for (TransparentLabel t : frame.getLabels())
						t.setColor(new Color(0, 0, 255, 0));
					for (TransparentButton t : frame.getButtons())
						t.setColor(new Color(255, 0, 0, 0));
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g.drawImage(image, 0, 0, null);
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
