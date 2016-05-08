package Trainer;

import java.util.HashMap;

public class Language {

	private String							präfix, language;
	static private HashMap<String, String>	languageCombi	= new HashMap<String, String>();

	public Language(String präfix, String language) {
		this.setPräfix(präfix);
		this.setLanguage(language);
	}

	public String getPräfix() {
		return präfix;
	}

	public void setPräfix(String präfix) {
		this.präfix = präfix;
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
