package Trainer;

public class StatHelper {
	private String	date;
	private String	right;
	private String	wrong;
	private String	note;
	private String	sprache;

	public StatHelper() {
		this("", "", "", "", "");
	}

	public StatHelper(String date, String sprache, String right, String wrong, String note) {
		this.setDate(date);
		this.setSprache(sprache);
		this.setNote(note);
		this.setRight(right);
		this.setWrong(wrong);

	}

	/**
	 * @return the data
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the right
	 */
	public String getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(String right) {
		this.right = right;
	}

	/**
	 * @return the wrong
	 */
	public String getWrong() {
		return wrong;
	}

	/**
	 * @param wrong
	 *            the wrong to set
	 */
	public void setWrong(String wrong) {
		this.wrong = wrong;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the sprache
	 */
	public String getSprache() {
		return sprache;
	}

	/**
	 * @param sprache
	 *            the sprache to set
	 */
	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

}
