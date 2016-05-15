package Trainer;

public class StatHelper {
	private String	date;
	private int		right;
	private int		wrong;
	private String	note;

	private StatHelper(String date, int right, int wrong, String note) {
		this.setDate(date);
		this.setRight(right);
		this.setWrong(wrong);
		this.setNote(note);

	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the right
	 */
	public int getRight() {
		return this.right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}

	/**
	 * @return the wrong
	 */
	public int getWrong() {
		return this.wrong;
	}

	/**
	 * @param wrong
	 *            the wrong to set
	 */
	public void setWrong(int wrong) {
		this.wrong = wrong;
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
