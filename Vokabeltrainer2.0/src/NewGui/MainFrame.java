package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TitleBar				titlebar;
	private JPanel					contentPane;
	private MenuPanel				menuPanel;
	private HeadingBar				headingbar;
	private MainMenuImage			mainMenuImage;
	private internalLearningPanel	iLearningPanel;
	private static MainFrame		instance;
	private Border					border;

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
		contentPane = new JPanel();
		titlebar = new TitleBar(this);
		menuPanel = new MenuPanel(this);
		headingbar = new HeadingBar(this);
		mainMenuImage = new MainMenuImage(this);
		iLearningPanel = new internalLearningPanel(this);
		this.setContentPane(contentPane);
		this.border = BorderFactory.createLineBorder(Color.black);
		contentPane.setBorder(border);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(titlebar);
		this.getContentPane().add(menuPanel);
		this.getContentPane().add(headingbar);
		// this.getContentPane().add(mainMenuImage);
		this.getContentPane().add(iLearningPanel);
		this.getContentPane().setBackground(Color.RED);

	}
}
