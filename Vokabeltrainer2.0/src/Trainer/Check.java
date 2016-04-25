package Trainer;

import java.util.ArrayList;

import NewGui.MainFrame;

public class Check {

	private MainFrame frame;

	public Check(MainFrame mainFrame) {
		this.frame = frame;
	}

	public static String vok(String vokabel, ArrayList<Vokabeln> list) {

		int rnd = (int) ((Math.random()) * list.size());
		int rnd2 = (int) ((Math.random()) * 2);

		if (rnd2 == 0) {
			vokabel = list.get(rnd).getausland();
		} else if (rnd2 == 1) {
			vokabel = list.get(rnd).getinland();
		}
		return vokabel;

	}

	public static void check(String eingabe, ArrayList<Vokabeln> list, String vokabel) {
		String loesung = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getinland().equals(vokabel)) {
				loesung = list.get(i).getinland();
			} else if (list.get(i).getausland().equals(vokabel)) {
				loesung = list.get(i).getausland();
			}
		}
		if (eingabe.equals(loesung)) {
			System.out.println("Richtig :)");
		} else if (!eingabe.equals(loesung)) {
			System.out.println("Leider Falsch :(, richtig wäre " + loesung + " gewesen.");
		}
	}
}
