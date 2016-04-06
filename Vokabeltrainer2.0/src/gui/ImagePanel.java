package gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel implements MouseListener {

	private MainFrame				frame;
	private BufferedImage			image;
	private ArrayList<PanelButton>	buttons	= new ArrayList<PanelButton>();

	public ImagePanel(MainFrame frame) {
		this.frame = frame;
		try {
			image = ImageIO.read(new File("img/Hauptmenuleer.png"));
		} catch (IOException ex) {}
		buttons.add(new PanelButton(1235, -19, 35, 40, "X", "button0", 1.5));
		buttons.add(new PanelButton(1200, -19, 35, 40, "O", "button1", 1.5));
		buttons.add(new PanelButton(1165, -19, 35, 40, "_", "button2", 1.7));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		for (PanelButton p : buttons)
			p.draw(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		y -= 25;
		for (PanelButton p : buttons)
			if (p.isInMe(x, y))
				this.frame.actionPerformed(new ActionEvent("button", ActionEvent.ACTION_PERFORMED, p.getCmd()));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
