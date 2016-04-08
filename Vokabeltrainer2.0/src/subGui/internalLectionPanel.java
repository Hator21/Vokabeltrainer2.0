package subGui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import mainGui.Button;
import mainGui.LectionPanel;
import mainGui.MainFrame;

@SuppressWarnings("serial")
public class internalLectionPanel extends JPanel implements MouseListener {

	private MainFrame				frame;
	private LectionPanel			lPanel;
	private BufferedImage			image;
	private int						n		= 0;
	private ArrayList<Button>		buttons	= new ArrayList<Button>();
	private ArrayList<JCheckBox>	units	= new ArrayList<JCheckBox>();
	private JComboBox				combobox;

	public internalLectionPanel(MainFrame frame, LectionPanel lPanel) {
		this.frame = frame;
		this.lPanel = lPanel;
		this.setLayout(null);
		try {
			image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		this.setBounds(251, 66, 1028, 653);
		buttons.add(new Button(105, 550, 150, 40, "Lernen", "button15", 3.5, 30));
		for (int i = 0; i < 11; i++) {
			units.add(new JCheckBox("Lektion " + (i + 1)));
			units.get(i).setBounds(120, 40 * i + 100, 200, 40);
			units.get(i).setOpaque(false);
			units.get(i).setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			this.add(units.get(i));
		}
		combobox = new JComboBox();
		combobox.setBounds(80, 50, 200, 40);
		combobox.setOpaque(false);
		combobox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.add(combobox);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, 0, 0, null);
		for (Button p : buttons)
			p.draw(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		y -= 25;
		for (Button p : buttons)
			if (p.isInMe(x, y))
				this.frame.actionPerformed(new ActionEvent("button", ActionEvent.ACTION_PERFORMED, p.getCmd()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
