package Trainer;

import java.util.ArrayList;
import java.util.Collection;

import NewGui.MainFrame;

public class Check {

	private MainFrame frame;

	public Check(MainFrame frame) {
		this.setFrame(frame);
	}

	public int random(ArrayList<Vokabel> list) {
		int rnd = (int) ((Math.random()) * list.size());
		return rnd;
	}

	public int random() {
		int rnd = (int) ((Math.random()) * 2);
		return rnd;
	}

	public ArrayList<Vokabel> vok(ArrayList<Vokabel> list) {
		ArrayList<Vokabel> test = new ArrayList<Vokabel>();
		Vokabel vok = new Vokabel();
		boolean exist = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsed() == false) {
				exist = true;
			}
		}
		for (int i = 0; i <= 10; i++) {
			if (exist == true) {
				int rnd = this.random(list);

				if (list.get(rnd).getUsed() == true) {
					rnd = this.random(list);
				} else if (list.get(rnd).getUsed() == false) {
					vok = list.get(rnd);
					test.addAll((Collection<? extends Vokabel>) vok);
					list.get(rnd).setUsed(true);
					list.get(rnd).setTested(list.get(rnd).getTested() + 1);
				}
			}
		}
		if (exist == false) {
			for (int i = 0; i <= 10; i++) {
				vok.setCountryOriginCode("Fertig");
				vok.setCountryDistinationCode("Fertig");
				test.addAll((Collection<? extends Vokabel>) vok);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUsed());
			list.get(i).setUsed(false);
		}

		return test;
	}

	public void check(String eingabe, ArrayList<Vokabel> list, String vokabel, int right) {
		String loesung = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVocabOrigin().equals(vokabel)) {
				loesung = list.get(i).getVocabTranslation();
			} else if (list.get(i).getVocabTranslation().equals(vokabel)) {
				loesung = list.get(i).getVocabOrigin();
			}
		}
		if (eingabe.equals(loesung)) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setCorrect(list.get(i).getCorrect() + 1);
			}

			System.out.println("Richtig :)");
		} else if (!eingabe.equals(loesung)) {
			right--;
			System.out.println("Falsch :(");
		}
	}

	public void newGame(ArrayList<Vokabel> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setUsed(false);
		}
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
