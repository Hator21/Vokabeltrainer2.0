package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Components.TimerLabel;
import Trainer.Bearbeiten;
import Trainer.Check;
import Trainer.Run;
import Trainer.Vokabel;

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
	private VocabeltestPanel		vocabeltestPanel;
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

	private TimerLabel				timer;

	private ArrayList<JPanel>		panelList	= new ArrayList<JPanel>();
	private ArrayList<Vokabel>		vokabeln	= new ArrayList<Vokabel>();

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
		setInstance(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);

		this.setBear(new Bearbeiten(this));
		this.setCheck(new Check(this));
		//this.setRun(new Run(this, this.getCheck()));
		this.setTimer(new TimerLabel(this, 15, 0));
		try {
			this.setVokabeln(this.getBear().getdata());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.contentPane = new JPanel();
		this.titlebar = new TitleBar(this);
		this.menuPanel = new MenuPanel(this);
		this.headingbar = new HeadingBar(this);
		this.mainMenuImage = new MainMenuImage(this);
		this.panelList.add(this.mainMenuImage);
		this.iLectionPanel = new internalLectionPanel(this);
		this.panelList.add(this.iLectionPanel);
		this.iLearningPanel = new internalLearningPanel(this);
		this.panelList.add(this.iLearningPanel);
		this.vocabelPrePanel = new VocabelPrePanel(this);
		this.panelList.add(this.vocabelPrePanel);
		this.vocabeltestPanel = new VocabeltestPanel(this);
		this.panelList.add(this.vocabeltestPanel);
		this.searchingPanel = new SearchingPanel(this);
		this.panelList.add(this.searchingPanel);
		this.spellingPanel = new SpellingPanel(this);
		this.panelList.add(this.spellingPanel);
		this.editSPanel = new EditSPanel(this);
		this.panelList.add(this.editSPanel);
		this.statisticsPanel = new StatisticsPanel(this);
		this.panelList.add(this.statisticsPanel);
		this.helpPanel = new HelpPanel(this);
		this.panelList.add(this.helpPanel);
		this.infoPanel = new InfoPanel(this);
		this.panelList.add(this.infoPanel);
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
		this.vocabeltestPanel.setVisible(false);
		this.getContentPane().add(this.vocabeltestPanel);
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
		return this.vocabelPrePanel;
	}

	public void setVocabelPrePanel(VocabelPrePanel vocabelPrePanel) {
		this.vocabelPrePanel = vocabelPrePanel;
	}

	public SearchingPanel getSearchingPanel() {
		return this.searchingPanel;
	}

	public void setSearchingPanel(SearchingPanel searchingPanel) {
		this.searchingPanel = searchingPanel;
	}

	public SpellingPanel getSpellingPanel() {
		return this.spellingPanel;
	}

	public void setSpellingPanel(SpellingPanel spellingPanel) {
		this.spellingPanel = spellingPanel;
	}

	public EditSPanel getEditSPanel() {
		return this.editSPanel;
	}

	public void setEditSPanel(EditSPanel editSPanel) {
		this.editSPanel = editSPanel;
	}

	public StatisticsPanel getStatisticsPanel() {
		return this.statisticsPanel;
	}

	public void setStatisticsPanel(StatisticsPanel statisticsPanel) {
		this.statisticsPanel = statisticsPanel;
	}

	public HelpPanel getHelpPanel() {
		return this.helpPanel;
	}

	public void setHelpPanel(HelpPanel helpPanel) {
		this.helpPanel = helpPanel;
	}

	public TitleBar getTitlebar() {
		return this.titlebar;
	}

	public void setTitlebar(TitleBar titlebar) {
		this.titlebar = titlebar;
	}

	public MenuPanel getMenuPanel() {
		return this.menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public InfoPanel getInfoPanel() {
		return this.infoPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public ArrayList<JPanel> getPanelList() {
		return this.panelList;
	}

	public void setPanelList(ArrayList<JPanel> panelList) {
		this.panelList = panelList;
	}

	protected TimerLabel getTimer() {
		return this.timer;
	}

	protected void setTimer(TimerLabel timer) {
		this.timer = timer;
	}

	public VocabeltestPanel getVocabeltestPanel() {
		return this.vocabeltestPanel;
	}

	public void setVocabeltestPanel(VocabeltestPanel vocabeltestPanel) {
		this.vocabeltestPanel = vocabeltestPanel;
	}

	public static MainFrame getInstance() {
		return instance;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public ArrayList<Vokabel> getVokabeln() {
		return this.vokabeln;
	}

	public void setVokabeln(ArrayList<Vokabel> vokabeln) {
		this.vokabeln = vokabeln;
	}

}
