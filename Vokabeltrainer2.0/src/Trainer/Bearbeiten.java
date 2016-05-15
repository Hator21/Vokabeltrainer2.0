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
	private String		prä1, prä2;

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
	 * @param prä1
	 * @param prä2
	 * @return list of Strings
	 */
	public ArrayList<String> getLektionList(String prä1, String prä2) {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(prä1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(prä2) && !liste.contains("Lektion " + this.frame.getVokabeln().get(i).getLection())) {
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
			if (this.frame.getVokabeln().get(i).getCountryOriginCode().equals(this.prä1) && this.frame.getVokabeln().get(i).getCountryDistinationCode().equals(this.prä2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
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
	 * gets the präfixes of the selectet languages
	 * and set it to prä1 and prä2
	 * 
	 * @param cb->
	 *            Combobox
	 */
	public void putPräfix(JComboBox cb) {
		String language = cb.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		this.prä1 = this.getPräfix1(lang1);
		this.prä2 = this.getPräfix2(lang2);
	}

	/**
	 * get prä1
	 * 
	 * @param lang
	 * @return prä1 <String>
	 */
	public String getPräfix1(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang)) {
				this.prä1 = key.getPräfix();
			}
		}
		return this.prä1;
	}

	/**
	 * get prä12
	 * 
	 * @param lang
	 * @return prä2 <String>
	 */
	public String getPräfix2(String lang) {
		for (Language key : this.frame.getLanguageCombi().keySet()) {
			if (this.frame.getLanguageCombi().get(key).getLanguage().equals(lang)) {
				this.prä2 = this.frame.getLanguageCombi().get(key).getPräfix();
			}
		}
		return this.prä2;
	}

	private static CSVReflectionMap mapper;

	public String getPrä1() {
		return this.prä1;
	}

	public void setPrä1(String prä1) {
		this.prä1 = prä1;
	}

	public String getPrä2() {
		return this.prä2;
	}

	public void setPrä2(String prä2) {
		this.prä2 = prä2;
	}

}
