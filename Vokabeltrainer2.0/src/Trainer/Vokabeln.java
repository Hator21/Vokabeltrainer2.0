package Trainer;

public class Vokabeln {
	private String	ausland;
	private String	inland;

	public Vokabeln(String ausland, String inland) {
		this.ausland = ausland;
		this.inland = inland;
	}

	public void setausland(String a) {
		this.ausland = a;
	}

	public String getausland() {
		return ausland;
	}

	public void setinland(String a) {
		this.inland = a;
	}

	public String getinland() {
		return inland;
	}
}
