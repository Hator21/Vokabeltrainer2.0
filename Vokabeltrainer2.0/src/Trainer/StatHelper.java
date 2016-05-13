package Trainer;

public class StatHelper {
	private String	date;
	private String	voktest;
	private String	lektions;
	private String	note;

	private StatHelper(String date, String voktest, String lektions, String note) {
		this.setData(date);
		this.setLektions(lektions);
		this.setVoktest(voktest);
		this.setNote(note);

	}

	/**
	 * @return the data
	 */
	public String getData() {
		return this.date;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String date) {
		this.date = date;
	}

	/**
	 * @return the voktest
	 */
	public String getVoktest() {
		return this.voktest;
	}

	/**
	 * @param voktest
	 *            the voktest to set
	 */
	public void setVoktest(String voktest) {
		this.voktest = voktest;
	}

	/**
	 * @return the lektions
	 */
	public String getLektions() {
		return this.lektions;
	}

	/**
	 * @param lektions
	 *            the lektions to set
	 */
	public void setLektions(String lektions) {
		this.lektions = lektions;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
