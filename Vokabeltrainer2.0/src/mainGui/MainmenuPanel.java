package mainGui;

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
public class MainmenuPanel extends JPanel implements MouseListener {

	private MainFrame				frame;
	private BufferedImage			image;
	private ArrayList<Button>	buttons	= new ArrayList<Button>();

	public MainmenuPanel(MainFrame frame) {
		this.frame = frame;
		try {
			image = ImageIO.read(new File("img/Hauptmenuleer.png"));
		} catch (IOException ex) {}
		buttons.add(new Button(1235, -19, 35, 40, "X", "button0", 1.5, 17));
		buttons.add(new Button(1200, -19, 35, 40, "O", "button1", 1.5, 17));
		buttons.add(new Button(1165, -19, 35, 40, "_", "button2", 1.7, 17));
		buttons.add(new Button(0, 21, 250,44, "Lernen", "button3", 2.5, 30));
		buttons.add(new Button(0, 65, 250, 45, "Lektionen", "button4", 2.5, 20));
		buttons.add(new Button(0, 110, 250, 45, "Vokabeltest", "button5", 2.5, 20));
		buttons.add(new Button(0, 155, 250, 45, "Suchspiel", "button6", 2.5, 20));
		buttons.add(new Button(0, 200, 250, 45, "Buchstabieren", "button7", 2.5, 20));
		buttons.add(new Button(0, 247, 250, 45, "Sprache Verwalten", "button8", 2.5, 20));
		buttons.add(new Button(0, 292, 250, 45, "Einstellungen", "button9", 2.5, 20));
		buttons.add(new Button(0, 337, 250, 45, "Statistiken", "button10", 2.5, 20));
		buttons.add(new Button(0, 382, 250, 45, "Hilfe", "button11", 2.5, 20));
		buttons.add(new Button(0, 427, 250, 45, "Info", "button12", 2.5, 20));
		buttons.add(new Button(0, 660, 250, 60, "Beenden", "button13", 2.5, 30));
		// buttons
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
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
