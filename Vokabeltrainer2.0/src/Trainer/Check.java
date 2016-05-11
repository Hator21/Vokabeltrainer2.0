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

	public String vok() {
		boolean exist = false;
		int rnd = this.random();
		int rnd2 = this.random(this.frame.getTestVokabeln().size());
		String vok = "";
		for (int y = 0; y < this.frame.getTestVokabeln().size(); y++) {}

		for (int y = 0; y < this.frame.getTestVokabeln().size(); y++) {
			if (this.frame.getTestVokabeln().get(y).getUsed() == false) {
				exist = true;
			}
		}
		for (int i = 0; i < this.frame.getTestVokabeln().size(); i++) {
			if (exist == true) {
				if (rnd == 0) {
					if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
						rnd2 = this.random(this.frame.getTestVokabeln().size());
					} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
						vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
						this.frame.getTestVokabeln().get(rnd2).setUsed(true);
						i = this.frame.getTestVokabeln().size();//brake wenn Vokabel gefunden
					}
				} else if (rnd == 1) {
					if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
						rnd2 = this.random(this.frame.getTestVokabeln().size());
					} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
						vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
						this.frame.getTestVokabeln().get(rnd2).setUsed(true);
						i = this.frame.getTestVokabeln().size();//brake wenn Vokabel gefunden
					}

				}
			} else if (exist == false) {
				i = this.frame.getTestVokabeln().size();//brake wenn keine unUsedVokabel gefunden
				return vok = "";
			}
		}

		return vok;
	}

	public int check(String eingabe, String vokabel, int right) {
		ArrayList<Vokabel> list = this.frame.getTestVokabeln();
		String loesung = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVocabOrigin().equals(vokabel)) {
				loesung = list.get(i).getVocabTranslation();
			} else if (list.get(i).getVocabTranslation().equals(vokabel)) {
				loesung = list.get(i).getVocabOrigin();
			}
		}
		if (eingabe != "") {
			if (eingabe.equals(loesung)) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setCorrect(list.get(i).getCorrect() + 1);
				}
				right++;
			} else if (!eingabe.equals(loesung)) {}
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
