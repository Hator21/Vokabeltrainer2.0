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

	public boolean isUsed() {
		return this.used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
