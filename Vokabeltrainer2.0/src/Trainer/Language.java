package Trainer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Language implements Serializable {

	private String pr�fix, language;

	public Language(String pr�fix, String language) {
		this.setPr�fix(pr�fix);
		this.setLanguage(language);
	}

	/**
	 * @return the pr�fix
	 */
	public String getPr�fix() {
		return this.pr�fix;
	}

	/**
	 * @param pr�fix
	 *            the pr�fix to set
	 */
	public void setPr�fix(String pr�fix) {
		this.pr�fix = pr�fix;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}
