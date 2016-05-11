/**
 *
 */
package Trainer;

/**
 * @author Alexander
 *
 */
public class Vokabel {

	private String	countryOriginCode		= "";
	private String	countryDistinationCode	= "";

	private String	vocabOrigin				= "";
	private String	vocabTranslation		= "";

	private int		lection					= 0;

	private int		tested					= 0;
	private int		correct					= 0;

	private boolean	used					= false;

	public Vokabel() {}

	public Vokabel(String original, String translation) {
		this.setVocabOrigin(original);
		this.setVocabTranslation(translation);
	}

	public Vokabel(String countryOriginCode, String countryDistinationCode, String originalLanguage, String translationLanguage, int lection, int tested, int correct, boolean used) {
		this.setCountryOriginCode(countryOriginCode);
		this.setCountryDistinationCode(countryDistinationCode);
		this.setVocabOrigin(originalLanguage);
		this.setVocabTranslation(translationLanguage);
		this.setLection(lection);
		this.setTested(tested);
		this.setCorrect(correct);
		this.setUsed(used);
	}

	@Override
	public String toString() {
		return "[" + this.countryOriginCode + "]" + "[" + this.countryDistinationCode + "]" + "[" + this.vocabOrigin + "]" + "[" + this.vocabTranslation + "]" + "[" + this.lection + "]" + "[" + this.tested + "]" + "[" + this.correct + "]" + "[" + this.used + "]";
	}

	/**
	 * @return the countryOriginCode
	 */
	public String getCountryOriginCode() {
		return this.countryOriginCode;
	}

	/**
	 * @param countryOriginCode
	 *            the countryOriginCode to set
	 */
	public void setCountryOriginCode(String countryOriginCode) {
		this.countryOriginCode = countryOriginCode;
	}

	/**
	 * @return the countryDistinationCode
	 */
	public String getCountryDistinationCode() {
		return this.countryDistinationCode;
	}

	/**
	 * @param countryDistinationCode
	 *            the countryDistinationCode to set
	 */
	public void setCountryDistinationCode(String countryDistinationCode) {
		this.countryDistinationCode = countryDistinationCode;
	}

	/**
	 * @return the vocabOrigin
	 */
	public String getVocabOrigin() {
		return this.vocabOrigin;
	}

	/**
	 * @param vocabOrigin
	 *            the vocabOrigin to set
	 */
	public void setVocabOrigin(String vocabOrigin) {
		this.vocabOrigin = vocabOrigin;
	}

	/**
	 * @return the vocabTranslation
	 */
	public String getVocabTranslation() {
		return this.vocabTranslation;
	}

	/**
	 * @param vocabTranslation
	 *            the vocabTranslation to set
	 */
	public void setVocabTranslation(String vocabTranslation) {
		this.vocabTranslation = vocabTranslation;
	}

	/**
	 * @return the lection
	 */
	public int getLection() {
		return this.lection;
	}

	/**
	 * @param lection
	 *            the lection to set
	 */
	public void setLection(int lection) {
		this.lection = lection;
	}

	/**
	 * @return the tested
	 */
	public int getTested() {
		return this.tested;
	}

	/**
	 * @param tested
	 *            the tested to set
	 */
	public void setTested(int tested) {
		this.tested = tested;
	}

	/**
	 * @return the correct
	 */
	public int getCorrect() {
		return this.correct;
	}

	/**
	 * @param correct
	 *            the correct to set
	 */
	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public boolean getUsed() {
		return this.used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
