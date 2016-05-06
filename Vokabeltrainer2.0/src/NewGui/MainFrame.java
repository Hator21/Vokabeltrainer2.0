package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Components.TimerLabel;
import Components.TransparentButton;
import Components.TransparentLabel;
import Trainer.Bearbeiten;
import Trainer.Check;
import Trainer.Run;
import Trainer.Vokabeln;
import jxl.write.WriteException;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TitleBar						titlebar;
	private JPanel							contentPane;
	private MenuPanel						menuPanel;
	private HeadingBar						headingbar;
	private MainMenuImage					mainMenuImage;
	private LearningPanel					learningPanel;
	private LearningPrePanel				learningPrePanel;
	private VocabelPrePanel					vocabelPrePanel;
	private VocabeltestPanel				vocabeltestPanel;
	private SearchingPrePanel				searchingPrePanel;
	private SearchingPanel					searchingPanel;
	private SpellingPrePanel				spellingPrePanel;
	private SpellingPanel					spellingPanel;
	private EditSPanel						editSPanel;
	private SettingsPanel					settingsPanel;
	private StatisticsPanel					statisticsPanel;
	private HelpPanel						helpPanel;
	private InfoPanel						infoPanel;
	private static MainFrame				instance;
	private Border							border;

	private Bearbeiten						bear;
	private Check							check;
	private Run								run;

	private TimerLabel						timer;

	private ArrayList<JPanel>				panelList	= new ArrayList<JPanel>();
	private ArrayList<Vokabeln>				vokabeln	= new ArrayList<Vokabeln>();
	private ArrayList<TransparentButton>	buttons		= new ArrayList<TransparentButton>();
	private ArrayList<TransparentLabel>		labels		= new ArrayList<TransparentLabel>();

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
		this.setRun(new Run(this, this.getCheck()));
		this.setTimer(new TimerLabel(this, 15, 0));
		try {
			this.getBear().getdata(getVokabeln());
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}

		this.contentPane = new JPanel();
		this.titlebar = new TitleBar(this);
		this.menuPanel = new MenuPanel(this);
		this.headingbar = new HeadingBar(this);
		this.mainMenuImage = new MainMenuImage(this);
		panelList.add(mainMenuImage);
		this.learningPrePanel = new LearningPrePanel(this);
		panelList.add(learningPrePanel);
		this.learningPanel = new LearningPanel(this);
		panelList.add(learningPanel);
		this.vocabelPrePanel = new VocabelPrePanel(this);
		panelList.add(vocabelPrePanel);
		this.vocabeltestPanel = new VocabeltestPanel(this);
		panelList.add(vocabeltestPanel);
		this.searchingPrePanel = new SearchingPrePanel(this);
		panelList.add(searchingPrePanel);
		this.searchingPanel = new SearchingPanel(this);
		panelList.add(searchingPanel);
		this.spellingPrePanel = new SpellingPrePanel(this);
		panelList.add(spellingPrePanel);
		this.spellingPanel = new SpellingPanel(this);
		panelList.add(spellingPanel);
		this.editSPanel = new EditSPanel(this);
		panelList.add(editSPanel);
		this.settingsPanel = new SettingsPanel(this);
		panelList.add(settingsPanel);
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
		this.learningPanel.setVisible(false);
		this.getContentPane().add(this.learningPanel);
		this.learningPrePanel.setVisible(false);
		this.getContentPane().add(this.learningPrePanel);
		this.vocabelPrePanel.setVisible(false);
		this.getContentPane().add(this.vocabelPrePanel);
		this.vocabeltestPanel.setVisible(false);
		this.getContentPane().add(this.vocabeltestPanel);
		this.searchingPrePanel.setVisible(false);
		this.getContentPane().add(this.searchingPrePanel);
		this.searchingPanel.setVisible(false);
		this.getContentPane().add(this.searchingPanel);
		this.spellingPrePanel.setVisible(false);
		this.getContentPane().add(this.spellingPrePanel);
		this.spellingPanel.setVisible(false);
		this.getContentPane().add(this.spellingPanel);
		this.editSPanel.setVisible(false);
		this.getContentPane().add(this.editSPanel);
		this.settingsPanel.setVisible(false);
		this.getContentPane().add(this.settingsPanel);
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

	public LearningPanel getLearningPanel() {
		return this.learningPanel;
	}

	public void setLearningPanel(LearningPanel iLearningPanel) {
		this.learningPanel = iLearningPanel;
	}

	public HeadingBar getHeadingbar() {
		return this.headingbar;
	}

	public void setHeadingbar(HeadingBar headingbar) {
		this.headingbar = headingbar;
	}

	public LearningPrePanel getLectionPanel() {
		return this.learningPrePanel;
	}

	public void setLectionPanel(LearningPrePanel iLectionPanel) {
		this.learningPrePanel = iLectionPanel;
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

	protected TimerLabel getTimer() {
		return timer;
	}

	protected void setTimer(TimerLabel timer) {
		this.timer = timer;
	}

	public VocabeltestPanel getVocabeltestPanel() {
		return vocabeltestPanel;
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

	public ArrayList<Vokabeln> getVokabeln() {
		return vokabeln;
	}

	public void setVokabeln(ArrayList<Vokabeln> vokabeln) {
		this.vokabeln = vokabeln;
	}

	public SettingsPanel getSettingsPanel() {
		return settingsPanel;
	}

	public void setSettingsPanel(SettingsPanel settingsPanel) {
		this.settingsPanel = settingsPanel;
	}

	public ArrayList<TransparentButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<TransparentButton> buttons) {
		this.buttons = buttons;
	}

	public ArrayList<TransparentLabel> getLabels() {
		return labels;
	}

	public void setLabels(ArrayList<TransparentLabel> labels) {
		this.labels = labels;
	}

	public SearchingPrePanel getSearchingPrePanel() {
		return searchingPrePanel;
	}

	public void setSearchingPrePanel(SearchingPrePanel searchingPrePanel) {
		this.searchingPrePanel = searchingPrePanel;
	}

	public SpellingPrePanel getSpellingPrePanel() {
		return spellingPrePanel;
	}

	public void setSpellingPrePanel(SpellingPrePanel spellingPrePanel) {
		this.spellingPrePanel = spellingPrePanel;
	}

}
