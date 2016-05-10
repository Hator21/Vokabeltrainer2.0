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

	public ArrayList<Vokabel> vok(ArrayList<Vokabel> list, int n, ArrayList<Integer> lek) {
		ArrayList<Vokabel> test = new ArrayList<Vokabel>();
		ArrayList<Vokabel> lesvok = new ArrayList<Vokabel>();
		Vokabel vok = new Vokabel();
		int p = n;

		for (int i = 0; i < n; i++) {
			boolean exist = false;
			for (int y = 0; y < list.size(); y++) {
				if (list.get(y).getUsed() == false) {
					exist = true;
					p--;
				}
			}
			if (exist == true) {
				for (int x = 0; x < list.size(); x++) {
					for (int k = 0; k < lek.size(); k++) {
						if (list.get(x).getLection() == lek.get(k)) {
							lesvok.add(list.get(x));

						}
					}
				}
				int rnd = this.random(list);

				if (list.get(rnd).getUsed() == true) {
					rnd = this.random(list);
				} else if (list.get(rnd).getUsed() == false) {
					vok = list.get(rnd);
					test.add(vok);
					list.get(rnd).setUsed(true);
					list.get(rnd).setTested(list.get(rnd).getTested() + 1);
				}
			}

			if (exist == false) {
				for (int k = 0; k < p; k++) {
					vok.setCountryOriginCode("Fertig");
					vok.setCountryDistinationCode("Fertig");
					test.add(vok);
				}
			}

		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setUsed(false);
		}

		return test;
	}

	public String vok() {
		boolean exist = false;
		int rnd = this.random();
		int rnd2 = this.random(this.frame.getTestVokabeln());
		String vok = "";

		for (int y = 0; y < this.frame.getTestVokabeln().size(); y++) {
			if (this.frame.getTestVokabeln().get(y).getUsed() == false) {
				exist = true;
			}
		}
		if (exist == true) {
			if (rnd == 0) {
				if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
					rnd2 = this.random(this.frame.getTestVokabeln());
				} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
					vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
					this.frame.getTestVokabeln().get(rnd2).setUsed(true);
				}
			} else if (rnd == 1) {
				if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
					rnd2 = this.random(this.frame.getTestVokabeln());
				} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
					vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
					this.frame.getTestVokabeln().get(rnd2).setUsed(true);
				}

			}
		} else if (exist == false) {
			vok = "Fertig";

		}

		return vok;
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
