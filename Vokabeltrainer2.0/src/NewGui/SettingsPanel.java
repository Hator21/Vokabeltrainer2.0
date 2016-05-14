package NewGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

		this.createCheckBox();

	}

	public void createCheckBox() {
		this.helpActiv = new JCheckBox("Aktiviere Hilfe-Funktion");
		this.helpActiv.setBounds(70, 100, 500, 60);
		this.helpActiv.setOpaque(false);
		this.helpActiv.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		this.add(this.helpActiv);
		this.helpActiv.addActionListener(e -> {
			if (((JCheckBox) e.getSource()).isSelected()) {
				for (TransparentLabel t : SettingsPanel.this.frame.getHelper())
					t.setVisible(true);
			} else
				for (TransparentLabel t : SettingsPanel.this.frame.getHelper())
					t.setVisible(false);
		});

		this.borderActiv = new JCheckBox("Zeige Button- und Textgrenzen");
		this.borderActiv.setBounds(70, 170, 500, 60);
		this.borderActiv.setOpaque(false);
		this.borderActiv.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		this.add(this.borderActiv);
		this.borderActiv.addActionListener(e -> {
			if (((JCheckBox) e.getSource()).isSelected()) {
				for (TransparentLabel t1 : SettingsPanel.this.frame.getLabels()) {
					if (t1 != null) {
						t1.setColor(new Color(0, 0, 255, 255));
						System.out.println(t1);
					}
				}
				for (TransparentButton t2 : SettingsPanel.this.frame.getButtons()) {
					if (t2 != null)
						t2.setBorderColor(new Color(255, 0, 0, 255));
				}
			} else {
				for (TransparentLabel t3 : SettingsPanel.this.frame.getLabels()) {
					if (t3 != null)
						t3.setColor(new Color(0, 0, 255, 0));
				}
				for (TransparentButton t4 : SettingsPanel.this.frame.getButtons()) {
					if (t4 != null)
						t4.setBorderColor(new Color(255, 0, 0, 0));
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

		g.drawImage(this.image, 0, 0, null);
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
