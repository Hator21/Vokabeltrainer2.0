package NewGui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel {
	private MainFrame		frame;
	private BufferedImage	image;
	private JPanel			panel;
	private JScrollPane		scrollPane;
	private JEditorPane		textPane;
	private Document		doc;
	private StyleSheet		styleSheet;
	private HTMLEditorKit	kit;

	public HelpPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/Hintergrund-weiﬂ.png"));
		} catch (IOException ex) {}
		createPane();
	}

	public void createPane() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(1, 0));
		this.panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.panel.setBounds(1, 1, 1026, 642);
		this.add(this.panel);
		textPane = new JEditorPane();
		textPane.setEditable(false);

		kit = new HTMLEditorKit();
		textPane.setEditorKit(kit);

		styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");

		styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
		doc = kit.createDefaultDocument();
		textPane.setDocument(doc);
		textPane.setText("<h1 style=\"text-align: center;\">Hilfe</h1><p>&nbsp;</p><h2 style=\"font-size: 20px;\">Sprache Verwalten</h2><h3>Um eine Sprache zu verwalten, klickt man in der Menuleiste auf &bdquo;Sprache Verwalten&ldquo;.</h3><h2>Sprache Anlegen:</h2><h3 style=\"padding-left: 30px;\">1. Klicke auf &bdquo;Sprache anlegen&ldquo;</h3><h3 style=\"padding-left: 30px;\">2. Gib deine Sprachen ein und gib eine L&auml;nderkennung f&uuml;r eine Sprache ein (z.B.: Deutsch -&gt; de_de, Englisch -&gt;en_en, etc.)</h3><h3 style=\"padding-left: 30px;\">3. Klicke auf &bdquo;OK&ldquo;</h3><h2>Sprache l&ouml;schen:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle in der ComboBox die zu l&ouml;schende Sprache</h3><h3 style=\"padding-left: 30px;\">2. Klicke auf &bdquo;Sprache l&ouml;schen&ldquo; (Alle Lektionen und Vokabeln dieser Sprache werden gel&ouml;scht)</h3><h2>Lektion anlegen:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle im Sprache-Breich in der ComboBox die Sprache aus, in der die Lektion angelegt werden soll</h3><h3 style=\"padding-left: 30px;\">2. Klicke auf &bdquo;Lektion anlegen&ldquo;</h3><h3 style=\"padding-left: 30px;\">3. Gib ein Lektion ein (Achtung: Format f&uuml;r jede Lektion ist: Lektion x wobei (1&lt;=x&lt;=10))</h3><h3 style=\"padding-left: 30px;\">4. Klicke auf &bdquo;Ok&ldquo;</h3><h2>Lektion l&ouml;schen:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle im Sprache-Breich in der ComboBox die Sprache aus, aus der die Lektion gel&ouml;scht werden soll</h3><h3 style=\"padding-left: 30px;\">2. W&auml;hle im Lektion-Breich in der ComboBox die Lektion aus, die Lektion gel&ouml;scht werden soll</h3><h3 style=\"padding-left: 30px;\">3. Klicke auf &bdquo;Lektion l&ouml;schen&ldquo;</h3><h2>Vokabel anlegen:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle im Sprache-Breich in der ComboBox die Sprache aus, in der die Vokabel erstellt werden soll</h3><h3 style=\"padding-left: 30px;\">2. W&auml;hle im Lektion-Breich in der ComboBox die Lektion aus, in der die Vokabel erstellt werden soll</h3><h3 style=\"padding-left: 30px;\">3. Klicke auf &bdquo;Vokabel anlegen&ldquo;</h3><h3 style=\"padding-left: 30px;\">4. Gib die Vokabel und die &Uuml;bersetzung ein</h3><h3 style=\"padding-left: 30px;\">5. Klicke auf &bdquo;OK&ldquo;</h3><h2>Vokabel l&ouml;schen:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle im Sprache-Breich in der ComboBox die Sprache aus, aus der die Vokabel gel&ouml;scht werden soll2. W&auml;hle im Lektion-Breich in der ComboBox die Lektion aus, die Vokabel gel&ouml;scht werden soll</h3><h3 style=\"padding-left: 30px;\">3. W&auml;hle in der unten angezeigten List eine Vokabel aus</h3><h3 style=\"padding-left: 30px;\">4. Klicke auf &bdquo;Vokabel l&ouml;schen&ldquo;</h3><h2>Vokabel &auml;ndern:</h2><h3 style=\"padding-left: 30px;\">1. W&auml;hle im Sprache-Breich in der ComboBox die Sprache aus, aus der die Vokabel ge&auml;ndert werden soll</h3><h3 style=\"padding-left: 30px;\">2. W&auml;hle im Lektion-Breich in der ComboBox die Lektion aus, die Vokabel ge&auml;ndert werden soll</h3><h3 style=\"padding-left: 30px;\">3. W&auml;hle in der unten angezeigten List eine Vokabel aus</h3><h3 style=\"padding-left: 30px;\">4. Klicke auf &bdquo;Vokabel &auml;ndern&ldquo;</h3><h3 style=\"padding-left: 30px;\">5. Gib nun deine &Auml;nderung ein</h3><h3 style=\"padding-left: 30px;\">6. Klicke auf &bdquo;OK&ldquo;</h3><p>&nbsp;</p><h2 style=\"font-size: 20px;\">Einstellungen</h2><h3>Um in die Einstellungen zu gelangen, klicke in der Menuleiste auf \"Einstellungen\"</h3><h2>Aktiviere Hilfe-Funktion</h2><h3>Aktiviert in allen Lernspielen zus&auml;tzliche Hilfe</h3><h2>Zeige Button- und Textgrenzen</h2><h3>Zeigt bei allen Buttons und Labels die Grenzen (Button: Rot, Labels: Blau)</h3><p>&nbsp;</p><h2 style=\"font-size: 20px;\">Statistik</h2><h3>Um in die Statistik zu gelangen, klicke in der Menuleiste auf \"Statistik\"</h3><h3>Zeigt die Ergebnisse eins jeden Vokabeltests</h3><h3 style=\"padding-left: 30px;\">Datum:&nbsp;&nbsp;&nbsp; Zeigt das Datum und die Uhrzeit des Vokabeltests</h3><h3 style=\"padding-left: 30px;\">Sprache: Zeigt in welcher Sprache der Vokabeltest durchgef&uuml;hrt wurde</h3><h3 style=\"padding-left: 30px;\">Richtig:&nbsp;&nbsp; Zeigt wie viele Vokabeln richtig waren</h3><h3 style=\"padding-left: 30px;\">Falsch:&nbsp;&nbsp; Zeigt wie viele Vokabeln falsch waren</h3><h3 style=\"padding-left: 30px;\">Note:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Zeigt die Note des Vokabeltests</h3><p>&nbsp;</p><h2 style=\"font-size: 20px;\">Info</h2><h3>Um in die Infos zu gelangen, klicke in der Menuleiste auf \"Info\"</h3><h3 style=\"padding-left: 30px;\">Zeigt die Versionsnummer</h3><h3 style=\"padding-left: 30px;\">Zeigt die Build-ID (Datum der letzten &Auml;nderung - Anzahl der Commits in Github)</h3><h3 style=\"padding-left: 30px;\">Zeigt die Autoren des Programms</h3><h2 style=\"font-size: 20px;\">Beenden</h2><p>&nbsp;</p><h3>Um das Programm zu beenden, klicke in der Menuleiste auf \"Beenden\" oder klicke in der rechten oberen Ecke des Fensters auf \"X\"</h3><h3 style=\"padding-left: 30px;\">Speichert alle Sprachen, Lektionen, Vokabeln und Statistiken</h3><h2 style=\"font-size: 20px;\">Hauptmenu</h2><h3>Um in das Hauptmenu zu gelangen, klicke in der Titelleiste auf \"Vokabeltrainer 2.0\"</h3><p>&nbsp;</p><p>&nbsp;</p>");

		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
