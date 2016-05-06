package Trainer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import NewGui.MainFrame;

public class Run {

	private MainFrame	frame;
	private Check		check;

	public Run(MainFrame frame, Check check) {
		this.frame = frame;
		this.setCheck(check);
		this.running();
	}

	public void running() {
		String eingabe;

		ArrayList<Vokabel> englisch = new ArrayList<Vokabel>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			englisch = this.frame.getBear().getdata();
		} catch (Exception e) { // lesen
			e.printStackTrace();
		}

		englisch.forEach((v) -> System.out.println(v));

		int rnd = (int) ((Math.random()) * englisch.size());
		int rnd2 = (int) ((Math.random()) * 2);

		String vokabel = "lol";
		if (rnd2 == 0) {
			vokabel = englisch.get(rnd).getVocabTranslation();
			System.out.println(vokabel);
		} else if (rnd2 == 1) {
			vokabel = englisch.get(rnd).getVocabOrigin();
			System.out.println(vokabel);

		}
		try {
			this.frame.getBear().write(englisch);
		} catch (Exception e) { // schreiben
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

	public Check getCheck() {
		return this.check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

}
