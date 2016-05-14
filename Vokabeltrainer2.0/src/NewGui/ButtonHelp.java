package NewGui;

public class ButtonHelp {
	private int		button;
	private boolean	used;

	public ButtonHelp(int button, boolean used) {
		this.setButton(this.button);
		this.setUsed(this.used);
	}

	/**
	 * @return the button
	 */
	public int getButton() {
		return this.button;
	}

	/**
	 * @param button
	 *            the button to set
	 */
	public void setButton(int button) {
		this.button = button;
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return this.used;
	}

	/**
	 * @param used
	 *            the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
}
