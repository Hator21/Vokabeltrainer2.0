package mainGui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
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
		this.setBounds(0, 0, 1280, 21);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				initialClick = e.getPoint();
				getComponentAt(initialClick);
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
				int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});

		TransperantButton x = new TransperantButton("X", 1235, -19, 35, 40, 17, 8);
		this.add(x);
		
		x.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(1);
			}
		});
		buttons.add(x);

		TransperantButton minimize = new TransperantButton("_", 1200, -19, 35, 40, 17, 5);
		this.add(minimize);
		buttons.add(minimize);
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});

		for (TransperantButton b : buttons)
			System.out.println(b.getText() + b.getBounds());
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		for (TransperantButton b : buttons)
			b.render(g);
	}
}
