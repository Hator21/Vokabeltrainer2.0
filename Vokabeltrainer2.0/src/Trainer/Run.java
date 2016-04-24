package Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import jxl.write.WriteException;

public class Run {
	public static void main(String[] args) {
		String eingabe;

		Bearbeiten bear = new Bearbeiten();
		Check check = new Check();
		ArrayList<Vokabeln> englisch = new ArrayList<Vokabeln>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			bear.getdata(englisch);
		} catch (IOException e) { //lesen
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

		int rnd = (int) ((Math.random()) * englisch.size());
		int rnd2 = (int) ((Math.random()) * 2);

		String vokabel = "lol";
		if (rnd2 == 0) {
			vokabel = englisch.get(rnd).getausland();
		} else if (rnd2 == 1) {
			vokabel = englisch.get(rnd).getinland();

		}
		try {
			bear.write(englisch);
		} catch (WriteException e) { //schreiben
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Geben sie die Übersetzung von " + vokabel + " ein");
		try {
			eingabe = br.readLine();
		} catch (IOException e) {
			return;
		}
		check.check(eingabe, englisch, vokabel);

	}

}
