package utils;

public class CoordSearching {
	private int		x;
	private int		y;
	private boolean	used;

	public CoordSearching(int x, int y, boolean used) {
		this.setX(x);
		this.setY(y);
		this.setUsed(used);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
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
