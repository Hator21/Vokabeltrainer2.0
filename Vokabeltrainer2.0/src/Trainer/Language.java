package Trainer;

import java.util.HashMap;

public class Language {

	private String							pr�fix, language;
	static private HashMap<String, String>	languageCombi	= new HashMap<String, String>();

	public Language(String pr�fix, String language) {
		this.setPr�fix(pr�fix);
		this.setLanguage(language);
	}

	public String getPr�fix() {
		return pr�fix;
	}

	public void setPr�fix(String pr�fix) {
		this.pr�fix = pr�fix;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public static HashMap<String, String> getLanguageCombi() {
		return languageCombi;
	}

	public static void setLanguageCombi(HashMap<String, String> languageCombi) {
		Language.languageCombi = languageCombi;
	}

}
