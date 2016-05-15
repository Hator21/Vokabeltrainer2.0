package Trainer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Language implements Serializable {

	private String präfix, language;

	public Language(String präfix, String language) {
		this.setPräfix(präfix);
		this.setLanguage(language);
	}

	/**
	 * @return the präfix
	 */
	public String getPräfix() {
		return this.präfix;
	}

	/**
	 * @param präfix
	 *            the präfix to set
	 */
	public void setPräfix(String präfix) {
		this.präfix = präfix;
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
