package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

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
	private internalLectionPanel	iLectionPanel;
	private VocabelPrePanel			vocabelPrePanel;
	private SearchingPanel			searchingPanel;
	private SpellingPanel			spellingPanel;
	private EditSPanel				editSPanel;
	private StatisticsPanel			statisticsPanel;
	private HelpPanel				helpPanel;
	private InfoPanel				infoPanel;
	private static MainFrame		instance;
	private Border					border;

	private Bearbeiten				bear;
	private Check					check;
	private Run						run;
	
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();

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

		this.setBear(new Bearbeiten(this));
		this.setCheck(new Check(this));
		this.setRun(new Run(this, this.getCheck()));

		this.contentPane = new JPanel();
		this.titlebar = new TitleBar(this);
		this.menuPanel = new MenuPanel(this);
		this.headingbar = new HeadingBar(this);
		this.mainMenuImage = new MainMenuImage(this);
		panelList.add(mainMenuImage);
		this.iLearningPanel = new internalLearningPanel(this);
		panelList.add(iLearningPanel);
		this.iLectionPanel = new internalLectionPanel(this);
		panelList.add(iLectionPanel);
		this.vocabelPrePanel = new VocabelPrePanel(this);
		panelList.add(vocabelPrePanel);
		this.searchingPanel = new SearchingPanel(this);
		panelList.add(searchingPanel);
		this.spellingPanel = new SpellingPanel(this);
		panelList.add(spellingPanel);
		this.editSPanel = new EditSPanel(this);
		panelList.add(editSPanel);
		this.statisticsPanel = new StatisticsPanel(this);
		panelList.add(statisticsPanel);
		this.helpPanel = new HelpPanel(this);
		panelList.add(helpPanel);
		this.infoPanel = new InfoPanel(this);
		panelList.add(infoPanel);
		this.setContentPane(this.contentPane);
		this.border = BorderFactory.createLineBorder(Color.black);
		this.contentPane.setBorder(this.border);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(this.titlebar);
		this.getContentPane().add(this.menuPanel);
		this.getContentPane().add(this.headingbar);
		this.getContentPane().add(this.mainMenuImage);
		this.iLearningPanel.setVisible(false);
		this.getContentPane().add(this.iLearningPanel);
		this.iLectionPanel.setVisible(false);
		this.getContentPane().add(this.iLectionPanel);
		this.vocabelPrePanel.setVisible(false);
		this.getContentPane().add(this.vocabelPrePanel);
		this.searchingPanel.setVisible(false);
		this.getContentPane().add(this.searchingPanel);
		this.spellingPanel.setVisible(false);
		this.getContentPane().add(this.spellingPanel);
		this.editSPanel.setVisible(false);
		this.getContentPane().add(this.editSPanel);
		this.statisticsPanel.setVisible(false);
		this.getContentPane().add(this.statisticsPanel);
		this.helpPanel.setVisible(false);
		this.getContentPane().add(this.helpPanel);
		this.infoPanel.setVisible(false);
		this.getContentPane().add(this.infoPanel);
		this.getContentPane().setBackground(Color.RED);
	}

	public Bearbeiten getBear() {
		return this.bear;
	}

	public void setBear(Bearbeiten bear) {
		this.bear = bear;
	}

	public Check getCheck() {
		return this.check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public Run getRun() {
		return this.run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public MainMenuImage getMainMenuImage() {
		return this.mainMenuImage;
	}

	public void setMainMenuImage(MainMenuImage mainMenuImage) {
		this.mainMenuImage = mainMenuImage;
	}

	public internalLearningPanel getiLearningPanel() {
		return this.iLearningPanel;
	}

	public void setiLearningPanel(internalLearningPanel iLearningPanel) {
		this.iLearningPanel = iLearningPanel;
	}

	public HeadingBar getHeadingbar() {
		return this.headingbar;
	}

	public void setHeadingbar(HeadingBar headingbar) {
		this.headingbar = headingbar;
	}

	public internalLectionPanel getiLectionPanel() {
		return this.iLectionPanel;
	}

	public void setiLectionPanel(internalLectionPanel iLectionPanel) {
		this.iLectionPanel = iLectionPanel;
	}

	public VocabelPrePanel getVocabelPrePanel() {
		return vocabelPrePanel;
	}

	public void setVocabelPrePanel(VocabelPrePanel vocabelPrePanel) {
		this.vocabelPrePanel = vocabelPrePanel;
	}

	public SearchingPanel getSearchingPanel() {
		return searchingPanel;
	}

	public void setSearchingPanel(SearchingPanel searchingPanel) {
		this.searchingPanel = searchingPanel;
	}

	public SpellingPanel getSpellingPanel() {
		return spellingPanel;
	}

	public void setSpellingPanel(SpellingPanel spellingPanel) {
		this.spellingPanel = spellingPanel;
	}

	public EditSPanel getEditSPanel() {
		return editSPanel;
	}

	public void setEditSPanel(EditSPanel editSPanel) {
		this.editSPanel = editSPanel;
	}

	public StatisticsPanel getStatisticsPanel() {
		return statisticsPanel;
	}

	public void setStatisticsPanel(StatisticsPanel statisticsPanel) {
		this.statisticsPanel = statisticsPanel;
	}

	public HelpPanel getHelpPanel() {
		return helpPanel;
	}

	public void setHelpPanel(HelpPanel helpPanel) {
		this.helpPanel = helpPanel;
	}

	public TitleBar getTitlebar() {
		return titlebar;
	}

	public void setTitlebar(TitleBar titlebar) {
		this.titlebar = titlebar;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public ArrayList<JPanel> getPanelList() {
		return panelList;
	}

	public void setPanelList(ArrayList<JPanel> panelList) {
		this.panelList = panelList;
	}
	
}
