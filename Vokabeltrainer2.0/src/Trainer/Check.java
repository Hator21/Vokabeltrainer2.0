package Trainer;

import java.util.ArrayList;

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

	public String vok(ArrayList<Vokabel> list) {
		boolean exist = false;
		String vokabel = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsed() == false) {
				exist = true;
			}
		}
		if (exist == true) {
			int rnd = this.random(list);
			int rnd2 = this.random();

			if (rnd2 == 0) {
				if (list.get(rnd).getUsed() == true) {
					rnd = this.random(list);
				} else if (list.get(rnd).getUsed() == false) {
					vokabel = list.get(rnd).getVocabTranslation();
					list.get(rnd).setUsed(true);
					list.get(rnd).setTested(list.get(rnd).getTested() + 1);
				}
			} else if (rnd2 == 1) {
				if (list.get(rnd).getUsed() == true) {
					rnd = this.random(list);
				} else if (list.get(rnd).getUsed() == false) {

					vokabel = list.get(rnd).getVocabOrigin();
					list.get(rnd).setUsed(true);
					list.get(rnd).setTested(list.get(rnd).getTested() + 1);
				}
			}

			if (exist == false) {
				vokabel = "Fertig";
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getUsed());
				list.get(i).setUsed(false);
			}

		}
		return vokabel;
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
