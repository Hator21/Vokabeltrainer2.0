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

	/**
	 * 
	 * What this stupid function does:
	 * Returns @param n random unsed vocs from the pool of available vocs ( @param list ) froml the selected lections ( @param lek )
	 * 
	 * @param list
	 *            - List of all vocabularies
	 * @param n
	 *            - number of requested vocabularies
	 * @param lek
	 *            - list of selected lections
	 * @param markUsed
	 *            - mark the requested voc. as used
	 * @return list of requested vocs.
	 */
	public ArrayList<Vokabel> vok(int n, ArrayList<Integer> lek, boolean markUsed) {
		ArrayList<Vokabel> list = frame.getVokabeln();

		ArrayList<Vokabel> returnList = new ArrayList<>();

		if (n > list.size()) {
			return list;
		}

		boolean empty = false;
		while (!empty) {
			Vokabel v = list.get(random(list.size()));

			if (returnList.contains(v)) {
				if (returnList.size() == list.size()) {
					empty = true;
				}
			} else {
				returnList.add(v);

				if (markUsed) {
					v.setUsed(true);
					v.setTested(v.getTested() + 1);
				}
			}

			if (returnList.size() >= n) {
				empty = true;
			}

		}
		return returnList;
	}

	public String vok() {
		boolean exist = false;
		int rnd = this.random();
		int rnd2 = this.random(this.frame.getTestVokabeln().size());
		String vok = "";

		for (int y = 0; y < this.frame.getTestVokabeln().size(); y++) {
			if (this.frame.getTestVokabeln().get(y).getUsed() == false) {
				exist = true;
			}
		}
		if (exist == true) {
			if (rnd == 0) {
				if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
					rnd2 = this.random(this.frame.getTestVokabeln().size());
				} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
					vok = this.frame.getTestVokabeln().get(rnd2).getVocabTranslation();
					this.frame.getTestVokabeln().get(rnd2).setUsed(true);
				}
			} else if (rnd == 1) {
				if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
					rnd2 = this.random(this.frame.getTestVokabeln().size());
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
