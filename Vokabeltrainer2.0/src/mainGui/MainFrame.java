package mainGui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private MainmenuPanel	contentPane;
	private TitleBar		titlebar;
	private LectionPanel	lectionPanel;
	public static MainFrame	instance;
	private Border			border;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainFrame frame = new MainFrame();
				final Dimension d = frame.getToolkit().getScreenSize();
				frame.setLocation((int) ((d.getWidth() - frame.getWidth()) / 2), (int) ((d.getHeight() - frame.getHeight()) / 2));
				frame.setUndecorated(true);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		instance = this;
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		this.border = BorderFactory.createRaisedBevelBorder();
		this.titlebar = new TitleBar(this);
		this.lectionPanel = new LectionPanel(this);
		//lectionPanel.setBorder(border);
		this.lectionPanel.setLayout(null);
		this.setContentPane(this.lectionPanel);
		this.getContentPane().add(this.titlebar);
	}
}
