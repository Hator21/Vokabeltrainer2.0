package Trainer;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;

import NewGui.MainFrame;

public class Bearbeiten {
	private String		aus, in;
	private MainFrame	frame;

	private static File	vocFile	= new File("Vokabeln.csv");
	private CSVParser	parser;
	private CSVWriter	writer;
	private String		pr�1, pr�2;

	public Bearbeiten(MainFrame frame) {
		this.setFrame(frame);
	}

	/**
	 *
	 * Gets vocabulary from the file data/Vokabeln.csv
	 *
	 * @throws Exception
	 */
	public ArrayList<Vokabel> getdata() throws Exception {
		this.parser = new CSVParser(vocFile);
		return this.parser.parse(getMapper(), Vokabel.class, true);
	}

	/**
	 *
	 * writes vocabulary to the file data/Vokabeln.csv
	 *
	 * @throws Exception
	 */
	public void write(ArrayList<Vokabel> daten) throws Exception {
		this.writer = new CSVWriter(vocFile);
		this.writer.save(getMapper(), daten, Vokabel.class, true);
	}

	/**
	 *
	 * @return max int Lektion
	 */
	public int getLektion() {
		int z = 0;
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (z < this.frame.getVokabeln().get(i).getLection()) {
				z = this.frame.getVokabeln().get(i).getLection();
			}
		}
		return z;
	}

	/**
	 * get a List of all Lections
	 *
	 * @param pr�1
	 * @param pr�2
	 * @return list of Strings
	 */
	public ArrayList<String> getLektionList(String pr�1, String pr�2) {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(pr�1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(pr�2) && !liste.contains("Lektion " + this.frame.getVokabeln().get(i).getLection())) {
				liste.add("Lektion " + this.frame.getVokabeln().get(i).getLection());
			}
		}
		return liste;
	}

	/**
	 * get al List of all Lections
	 * 
	 * @return list of Integers
	 */
	public ArrayList<Integer> getLektions() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(this.pr�1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(this.pr�2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
				liste.add(this.frame.getVokabeln().get(i).getLection());
			}
		}
		return liste;
	}

	/**
	 * write Vocable list to file
	 */
	public void Close() {
		try {
			this.write(this.frame.getVokabeln());
		} catch (Exception e) {
			return;
		}
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	static CSVReflectionMap getMapper() {
		if (mapper == null) {
			mapper = new CSVReflectionMap();
			mapper.setField(0, "countryOriginCode");
			mapper.setField(1, "countryDistinationCode");
			mapper.setField(2, "vocabOrigin");
			mapper.setField(3, "vocabTranslation");
			mapper.setField(4, "lection");
			mapper.setField(5, "tested");
			mapper.setField(6, "correct");
		}
		return mapper;
	}

	/**
	 * gets the pr�fixes of the selectet languages
	 * and set it to pr�1 and pr�2
	 * 
	 * @param cb->
	 *            Combobox
	 */
	public void putPr�fix(JComboBox cb) {
		String language = cb.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		this.pr�1 = this.getPr�fix1(lang1);
		this.pr�2 = this.getPr�fix2(lang2);
	}

	/**
	 * get pr�1
	 * 
	 * @param lang
	 * @return pr�1 <String>
	 */
	public String getPr�fix1(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang)) {
				this.pr�1 = key.getPr�fix();
			}
		}
		return this.pr�1;
	}

	/**
	 * get pr�12
	 * 
	 * @param lang
	 * @return pr�2 <String>
	 */
	public String getPr�fix2(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (this.frame.getLanguageCombi().get(key).getLanguage().equals(lang)) {
				this.pr�2 = this.frame.getLanguageCombi().get(key).getPr�fix();
			}
		}
		return this.pr�2;
	}

	private static CSVReflectionMap mapper;

	public String getPr�1() {
		return this.pr�1;
	}

	public void setPr�1(String pr�1) {
		this.pr�1 = pr�1;
	}

	public String getPr�2() {
		return this.pr�2;
	}

	public void setPr�2(String pr�2) {
		this.pr�2 = pr�2;
	}

}
