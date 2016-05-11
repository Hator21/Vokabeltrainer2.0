package Trainer;

import java.util.ArrayList;

import NewGui.MainFrame;

public class Check {

	private MainFrame frame;

	public Check(MainFrame frame) {
		this.setFrame(frame);
	}

	public int random(int max) {
		int rnd = (int) ((Math.random()) * max);
		return rnd;
	}

	public int random() {
		int rnd = (int) ((Math.random()) * 2);
		return rnd;
	}

	public ArrayList<Vokabel> vok(int n) {
		ArrayList<Vokabel> leklist = new ArrayList<Vokabel>();
		ArrayList<Integer> lek = this.frame.getLek();
		ArrayList<Vokabel> list = this.frame.getVokabeln();

		for (int i = 0; i < list.size(); i++) {
			for (int y = 0; y < lek.size(); y++) {
				if (list.get(i).getLection() == lek.get(y)) {
					leklist.add(list.get(i));
				}
			}
		}
		if (n > leklist.size()) {
			return leklist;
		}
		return leklist;
	}

	public String vok(boolean d_e, boolean e_d) {
		boolean exist = false;
		boolean found = true;
		int rnd = 3;
		int rnd2 = this.random(this.frame.getTestVokabeln().size());
		String vok = "";
		if ((e_d && d_e) == true) {
			rnd = this.random();

		} else if (e_d == true) {
			rnd = 0;
		} else if (d_e == true) {
			rnd = 1;
		} else if ((e_d && d_e) == false) {
			rnd = this.random();
		}
		for (int y = 0; y < this.frame.getTestVokabeln().size(); y++) {
			if (this.frame.getTestVokabeln().get(y).getUsed() == false) {
				exist = true;
				y = this.frame.getTestVokabeln().size();
			}
		}

		if (exist == true) {
			while (found) {
				if (rnd == 0) {
					if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
						rnd2 = this.random(this.frame.getTestVokabeln().size());
					} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
						vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
						this.frame.getTestVokabeln().get(rnd2).setUsed(true);
						found = false;//brake wenn Vokabel gefunden
					}
				} else if (rnd == 1) {
					if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
						rnd2 = this.random(this.frame.getTestVokabeln().size());
					} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
						vok = this.frame.getTestVokabeln().get(rnd2).getVocabOrigin();
						this.frame.getTestVokabeln().get(rnd2).setUsed(true);
						found = false;//brake wenn Vokabel gefunden
					}
				}

			}
		} else if (exist == false) {
			return vok = "LÖL";
		}

		return vok;
	}

	public int check(String eingabe, String vokabel, int right) {
		ArrayList<Vokabel> list = this.frame.getTestVokabeln();
		if (!eingabe.equals("") && !vokabel.equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getVocabOrigin().equals(vokabel)) {
					if (eingabe.equals(list.get(i).getVocabTranslation())) {
						list.get(i).setCorrect(list.get(i).getCorrect() + 1);
						right++;
					}
				} else if (list.get(i).getVocabTranslation().equals(vokabel)) {
					if (eingabe.equals(list.get(i).getVocabOrigin())) {
						list.get(i).setCorrect(list.get(i).getCorrect() + 1);
						right++;
					}
				}
			}
		}
		return right;
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
