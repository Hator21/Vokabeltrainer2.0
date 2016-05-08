package Trainer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Language implements Serializable {

	private String präfix, language;

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
}
