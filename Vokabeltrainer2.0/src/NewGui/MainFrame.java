package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import mainGui.MainmenuPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private MainmenuPanel	mainmenuPanel;
	private TitleBar		titlebar;
	private LectionPanel	lectionPanel;
	private JPanel			contentPane;
	private MenuPanel		menuPanel;
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
		this.contentPane = new JPanel();
		this.titlebar = new TitleBar(this);
		this.menuPanel = new MenuPanel(this);
		this.setContentPane(this.contentPane);
		this.border = BorderFactory.createLineBorder(Color.black);
		this.contentPane.setBorder(this.border);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(this.titlebar);
		this.getContentPane().add(this.menuPanel);
		this.getContentPane().setBackground(Color.BLACK);

	}
}
