package Trainer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Language implements Serializable {

	private String pr�fix, language;

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
}
