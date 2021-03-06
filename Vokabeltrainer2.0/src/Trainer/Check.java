package Trainer;

import java.util.ArrayList;

import NewGui.MainFrame;

public class Check {

	private MainFrame frame;

	public Check(MainFrame frame) {
		this.setFrame(frame);
	}

	/**
	 * Gets a random number from 0 to max
	 * 
	 * @param max
	 * @return random number
	 */
	public int random(int max) {
		int rnd = (int) ((Math.random()) * max);
		return rnd;
	}

	/**
	 * Gets a random number from 0 to 2
	 * 
	 * @param max
	 * @return random number
	 */
	public int random() {
		int rnd = (int) ((Math.random()) * 2);
		return rnd;
	}

	/**
	 * gets max 25 Vocables as a List
	 * 
	 * @param n
	 * @param speach
	 * @param speach2
	 * @return list of max 25 Vocables
	 */
	public ArrayList<Vokabel> vok1(int n, String speach, String speach2) {
		ArrayList<Vokabel> leklist = new ArrayList<Vokabel>();
		ArrayList<Integer> lek = this.frame.getLek();
		ArrayList<Vokabel> list = this.frame.getVokabeln();

		for (int i = 0; i < list.size(); i++) {
			for (int y = 0; y < lek.size(); y++) {
				if (leklist.size() < 25) {
					if (list.get(i).getCountryOriginCode().equals(speach) && list.get(i).getCountryDistinationCode().equals(speach2) && (list.get(i).getLection() == lek.get(y))) {
						leklist.add(list.get(i));
					}
				}
			}
		}

		return leklist;

	}

	/**
	 * gets Vocables as a List
	 * 
	 * @param n
	 * @param speach
	 * @param speach2
	 * @return list of Vocables
	 */
	public ArrayList<Vokabel> vok(int n, String speach, String speach2) {
		ArrayList<Vokabel> leklist = new ArrayList<Vokabel>();
		ArrayList<Integer> lek = this.frame.getLek();
		ArrayList<Vokabel> list = this.frame.getVokabeln();

		for (int i = 0; i < list.size(); i++) {
			for (int y = 0; y < lek.size(); y++) {
				if (list.get(i).getCountryOriginCode().equals(speach) && list.get(i).getCountryDistinationCode().equals(speach2) && (list.get(i).getLection() == lek.get(y))) {
					leklist.add(list.get(i));
				}
			}
		}
		if (n > leklist.size()) {
			return leklist;
		}

		return leklist;

	}

	/**
	 * gets only one Speach Vocable for the test
	 * 
	 * @param d_e
	 * @param e_d
	 * @return Vocable <String>
	 */
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
						found = false;// brake wenn Vokabel gefunden
					}
				} else if (rnd == 1) {
					if (this.frame.getTestVokabeln().get(rnd2).getUsed() == true) {
						rnd2 = this.random(this.frame.getTestVokabeln().size());
					} else if (this.frame.getTestVokabeln().get(rnd2).getUsed() == false) {
						vok = this.frame.getTestVokabeln().get(rnd2).getVocabOrigin();
						this.frame.getTestVokabeln().get(rnd2).setUsed(true);
						found = false;// brake wenn Vokabel gefunden
					}
				}

			}
		} else if (exist == false) {
			return vok = "L�L";
		}

		return vok;
	}

	/**
	 * Equals the Check Vocable with the right in the list
	 * and if (match) right ++
	 * 
	 * @param eingabe
	 * @param vokabel
	 * @param right
	 * @return right
	 */
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

	/**
	 * set all Vocables to Unused
	 * 
	 * @param list
	 */
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
