package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Trainer.Bearbeiten;
import Trainer.Check;
import Trainer.Run;

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

	private Bearbeiten				bear;
	private Check					check;
	private Run						run;

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
		this.headingbar = new HeadingBar(this);
		this.mainMenuImage = new MainMenuImage(this);
		this.iLearningPanel = new internalLearningPanel(this);
		this.setContentPane(this.contentPane);
		this.border = BorderFactory.createLineBorder(Color.black);
		this.contentPane.setBorder(this.border);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(this.titlebar);
		this.getContentPane().add(this.menuPanel);
		this.getContentPane().add(this.headingbar);
		// this.getContentPane().add(mainMenuImage);
		this.getContentPane().add(this.iLearningPanel);
		this.getContentPane().setBackground(Color.RED);

		this.setBear(new Bearbeiten(this));
		this.setCheck(new Check(this));
		this.setRun(new Run(this, getCheck()));

	}

	public Bearbeiten getBear() {
		return bear;
	}

	public void setBear(Bearbeiten bear) {
		this.bear = bear;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

}
