package Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import NewGui.MainFrame;
import jxl.write.WriteException;

public class Run {

	private MainFrame	frame;
	private Check		check;

	public Run(MainFrame frame, Check check) {
		this.frame = frame;
		this.check = check;
		running();
	}

	public void running() {
		String eingabe;

		ArrayList<Vokabeln> englisch = new ArrayList<Vokabeln>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			frame.getBear().getdata(englisch);
		} catch (IOException e) { // lesen
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
			frame.getBear().write(englisch);
		} catch (WriteException e) { // schreiben
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println("Geben sie die Übersetzung von " + vokabel + " ein");
		// try {
		// eingabe = br.readLine();
		// } catch (IOException e) {
		// return;
		// }
		// frame.getCheck().check(eingabe, englisch, vokabel);

	}

}
