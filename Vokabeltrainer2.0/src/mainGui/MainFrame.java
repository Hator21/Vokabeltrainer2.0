package mainGui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private MainmenuPanel	contentPane;
	private LectionPanel	lectionPanel;
	public static MainFrame	instance;
	private Border			border;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					final Dimension d = frame.getToolkit().getScreenSize();
					frame.setLocation((int) ((d.getWidth() - frame.getWidth()) / 2), (int) ((d.getHeight() - frame.getHeight()) / 2));
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		instance = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		border = BorderFactory.createRaisedBevelBorder();
		lectionPanel = new LectionPanel(this);
		lectionPanel.setBorder(border);
		lectionPanel.setLayout(null);
		setContentPane(lectionPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
