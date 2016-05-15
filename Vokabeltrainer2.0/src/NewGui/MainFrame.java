package NewGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Components.TimerLabel;
import Components.TransparentButton;
import Components.TransparentLabel;
import Trainer.Bearbeiten;
import Trainer.Check;
import Trainer.Language;
import Trainer.StatHelper;
import Trainer.Statistik;
import Trainer.Vokabel;

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
	private Statistik						stats;

	private TimerLabel						timer;

	private ArrayList<TransparentButton>	buttons			= new ArrayList<TransparentButton>();
	private ArrayList<TransparentLabel>		labels			= new ArrayList<TransparentLabel>();
	private ArrayList<TransparentLabel>		helper			= new ArrayList<TransparentLabel>();
	private ArrayList<JPanel>				panelList		= new ArrayList<JPanel>();
	private ArrayList<Vokabel>				vokabeln		= new ArrayList<Vokabel>();
	private HashMap<Language, Language>		languageCombi	= new HashMap<Language, Language>();
	private ArrayList<Integer>				lek				= new ArrayList<Integer>();
	private ArrayList<Vokabel>				testvokabeln	= new ArrayList<Vokabel>();
	ArrayList<String>						languages		= new ArrayList<String>();

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
	 * 
	 * @throws Exception
	 */
	public MainFrame() throws Exception {

		setInstance(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);

		FileInputStream fis;
		try {
			fis = new FileInputStream("data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.languageCombi = (HashMap<Language, Language>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {}

		this.setBear(new Bearbeiten(this));
		this.setCheck(new Check(this));
		this.setStats(new Statistik(this));
		this.setTimer(new TimerLabel(this, 15, 0));
		try {
			this.setVokabeln(this.getBear().getdata());
		} catch (FileNotFoundException e) {}

		this.contentPane = new JPanel();
		this.titlebar = new TitleBar(this);
		this.menuPanel = new MenuPanel(this);
		this.headingbar = new HeadingBar(this);
		this.mainMenuImage = new MainMenuImage(this);
		this.panelList.add(this.mainMenuImage);
		this.learningPrePanel = new LearningPrePanel(this);
		this.panelList.add(this.learningPrePanel);
		this.learningPanel = new LearningPanel(this);
		this.panelList.add(this.learningPanel);
		this.vocabelPrePanel = new VocabelPrePanel(this);
		this.panelList.add(this.vocabelPrePanel);
		this.vocabeltestPanel = new VocabeltestPanel(this);
		this.panelList.add(this.vocabeltestPanel);
		this.searchingPrePanel = new SearchingPrePanel(this);
		this.panelList.add(this.searchingPrePanel);
		this.searchingPanel = new SearchingPanel(this);
		this.panelList.add(this.searchingPanel);
		this.spellingPrePanel = new SpellingPrePanel(this);
		this.panelList.add(this.spellingPrePanel);
		this.spellingPanel = new SpellingPanel(this);
		this.panelList.add(this.spellingPanel);
		this.editSPanel = new EditSPanel(this);
		this.panelList.add(this.editSPanel);
		this.settingsPanel = new SettingsPanel(this);
		this.panelList.add(this.settingsPanel);
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
		for (TransparentLabel t : this.getHelper()) {
			t.setVisible(false);
		}
		try {
			Object[] data;
			this.getStats().setStat(this.getStats().getData());
			for (StatHelper s : this.getStats().getStat()) {
				data = new Object[] {
						s.getDate(), s.getSprache(), s.getRight(), s.getWrong(), s.getNote()
				};
				this.getStatisticsPanel().getTableModel().addRow(data);
			}
		} catch (FileNotFoundException e) {}
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

	public ArrayList<Integer> getLek() {
		return this.lek;
	}

	public void setLek(ArrayList<Integer> lek) {
		this.lek = lek;
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

	public ArrayList<Vokabel> getTestVokabeln() {
		return this.testvokabeln;
	}

	public void setTestVokabeln(ArrayList<Vokabel> Testvokabeln) {
		this.testvokabeln = Testvokabeln;
	}

	public SettingsPanel getSettingsPanel() {
		return this.settingsPanel;
	}

	public void setSettingsPanel(SettingsPanel settingsPanel) {
		this.settingsPanel = settingsPanel;
	}

	public ArrayList<TransparentButton> getButtons() {
		return this.buttons;
	}

	public void setButtons(ArrayList<TransparentButton> buttons) {
		this.buttons = buttons;
	}

	public ArrayList<TransparentLabel> getLabels() {
		return this.labels;
	}

	public void setLabels(ArrayList<TransparentLabel> labels) {
		this.labels = labels;
	}

	public SearchingPrePanel getSearchingPrePanel() {
		return this.searchingPrePanel;
	}

	public void setSearchingPrePanel(SearchingPrePanel searchingPrePanel) {
		this.searchingPrePanel = searchingPrePanel;
	}

	public SpellingPrePanel getSpellingPrePanel() {
		return this.spellingPrePanel;
	}

	public void setSpellingPrePanel(SpellingPrePanel spellingPrePanel) {
		this.spellingPrePanel = spellingPrePanel;
	}

	public HashMap<Language, Language> getLanguageCombi() {
		return this.languageCombi;
	}

	public void setLanguageCombi(HashMap<Language, Language> languageCombi) {
		this.languageCombi = languageCombi;
	}

	public String[] add2Language() {
		boolean b = false;
		for (Language s : this.getLanguageCombi().keySet()) {
			Language t = this.getLanguageCombi().get(s);
			if (this.languages.size() != 0) {
				for (String st : this.languages) {
					if ((s.getLanguage() + "-" + t.getLanguage()).equals(st) || (t.getLanguage() + "-" + s.getLanguage()).equals(st)) {
						b = true;
					}
				}
				if (b == false) {
					this.languages.add(s.getLanguage() + "-" + t.getLanguage());
				}
				b = false;
			} else {
				this.languages.add(s.getLanguage() + "-" + t.getLanguage());
			}
		}

		return this.languages.toArray(new String[this.languages.size()]);
	}

	public ArrayList<TransparentLabel> getHelper() {
		return this.helper;
	}

	public void setHelper(ArrayList<TransparentLabel> helper) {
		this.helper = helper;
	}

	/**
	 * @return the stats
	 */
	public Statistik getStats() {
		return this.stats;
	}

	/**
	 * @param stats
	 *            the stats to set
	 */
	public void setStats(Statistik stats) {
		this.stats = stats;
	}

}
