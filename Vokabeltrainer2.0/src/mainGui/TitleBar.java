package mainGui;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TitleBar extends JPanel {
	private Point							initialClick;
	private MainFrame						frame;
	private ArrayList<TransperantButton>	buttons	= new ArrayList<TransperantButton>();

	public TitleBar(final MainFrame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 21);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TitleBar.this.initialClick = e.getPoint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				int xMoved = (thisX + e.getX()) - (thisX + TitleBar.this.initialClick.x);
				int yMoved = (thisY + e.getY()) - (thisY + TitleBar.this.initialClick.y);

				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});

		TransperantButton.createButton("X", 1235, 0, 35, 21, 17, 8, (e -> {
			System.out.println("FUCK TITLE BAR");
			System.exit(1);
		}), this);

		TransperantButton.createButton("_", 1200, 0, 35, 21, 17, 5, (e -> {
			System.out.println("FUCK TITLE BAR 2");
			frame.setState(Frame.ICONIFIED);
		}), this);
	}

	@Override
	public void paintComponent(Graphics g) {
		//		g.setColor(new Color(0, 0, 0, 0));
		//		g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		//		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		/*
		 * for (TransperantButton b : this.buttons) {
		 * b.render(g);
		 * }
		 */
	}
}
