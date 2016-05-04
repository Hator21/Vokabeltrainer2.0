package Trainer;

import java.util.ArrayList;

import NewGui.MainFrame;

public class Check {

	private MainFrame frame;

	public Check(MainFrame frame) {
		this.setFrame(frame);
	}

	public String vok(String vokabel, ArrayList<Vokabel> list) {

		int rnd = (int) ((Math.random()) * list.size());
		int rnd2 = (int) ((Math.random()) * 2);

		if (rnd2 == 0) {
			vokabel = list.get(rnd).getVocabTranslation();
			System.out.println(vokabel);
		} else if (rnd2 == 1) {
			vokabel = list.get(rnd).getVocabOrigin();
			System.out.println(vokabel);
		}
		return vokabel;

	}

	public void check(String eingabe, ArrayList<Vokabel> list, String vokabel) {
		String loesung = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVocabOrigin().equals(vokabel)) {
				loesung = list.get(i).getVocabTranslation();
			} else if (list.get(i).getVocabTranslation().equals(vokabel)) {
				loesung = list.get(i).getVocabOrigin();
			}
		}
		if (eingabe.equals(loesung)) {
			System.out.println("Richtig :)");
		} else if (!eingabe.equals(loesung)) {
			System.out.println("Falsch :(");
		}
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
