package Trainer;

import java.util.ArrayList;

public class Check {

	public void check(String eingabe, String vokabel, int rnd, int rnd2, ArrayList<Vokabeln> list) {
		String loesung="";
		if (rnd2 == 0) {
			loesung = list.get(rnd).getinland();
		} else if (rnd2 == 1) {
			loesung = list.get(rnd).getausland();
		}
		if(eingabe.equals(loesung)){
			System.out.println("Richtig :)");
		}else if(!eingabe.equals(loesung)){
			System.out.println("Leider Falsch :(, richtig wäre "+loesung+" gewesen.");
		}
	}
}
		


