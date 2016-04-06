package Trainer;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel implements MouseListener {

	private MainFrame		frame;
	private BufferedImage	image;

	public ImagePanel(MainFrame frame) {
		this.frame = frame;
		try {
			image = ImageIO.read(new File("img/Hauptmenuleer.png"));
		} catch (IOException ex) {}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		y -= 25;
		// for (int i = 0; i < field[0].length; i++) {
		// for (int j = 0; j < field.length; j++) {
		// if (field[j][i].isInMe(x, y)) {
		// this.parent.actionPerformed(new ActionEvent("button", ActionEvent.ACTION_PERFORMED, field[j][i].getCmd()));
		// }
		// }
		// }
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
