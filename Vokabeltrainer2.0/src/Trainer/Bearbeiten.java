package Trainer;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;

import NewGui.MainFrame;

public class Bearbeiten {
	private String		aus, in;
	private MainFrame	frame;

	private static File	vocFile	= new File("data/Vokabeln.csv");
	private CSVParser	parser;
	private CSVWriter	writer;
	private String prä1,prä2;

	public Bearbeiten(MainFrame frame) {
		this.setFrame(frame);
	}

	public ArrayList<Vokabel> getdata() throws Exception {
		this.parser = new CSVParser(vocFile);
		return this.parser.parse(getMapper(), Vokabel.class, true);
	}

	public void write(ArrayList<Vokabel> daten) throws Exception {
		this.writer = new CSVWriter(vocFile);
		this.writer.save(getMapper(), daten, Vokabel.class, true);
	}

	//	public void Hinzufügen(ArrayList<Vokabel> vokabeln) throws Exception {
	//		InputStreamReader isr = new InputStreamReader(System.in);
	//		BufferedReader br = new BufferedReader(isr);
	//		String inland = "";
	//		String ausland = "";
	//
	//		System.out.println("Geben sie das Deutschewort ein.");
	//		try {
	//			inland = br.readLine();
	//		} catch (IOException e) {
	//			return;
	//		}
	//		System.out.println("Geben sie das Fremdsprachenwort ein.");
	//		try {
	//			ausland = br.readLine();
	//		} catch (IOException e) {
	//			return;
	//		}
	//		vokabeln.add(new Vokabel(ausland, inland));
	//		this.write(vokabeln);
	//	}
	public int getLektion() {
		int z = 0;
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (z < this.frame.getVokabeln().get(i).getLection()) {
				z = this.frame.getVokabeln().get(i).getLection();
			}
		}
		return z;
	}

	public void clear(ArrayList<?> list) {
		list.clear();

	}

	public ArrayList<String> getLektionList(String prä1, String prä2) {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (frame.getVokabeln().get(i).getCountryOriginCode().equals(prä1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(prä2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
				liste.add("Lektion " + this.frame.getVokabeln().get(i).getLection());
			}
		}
		return liste;
	}
	public ArrayList<Integer> getLektions() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (frame.getVokabeln().get(i).getCountryOriginCode().equals(prä1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(prä2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
				liste.add(this.frame.getVokabeln().get(i).getLection());
			}
		}
		return liste;
	}

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
	public void putPräfix(JComboBox cb) {
		String language = cb.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		prä1 = getPräfix1(lang1);
		prä2 = getPräfix2(lang2);
	}
	public String getPräfix1(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang))
				prä1 = key.getPräfix();
		}
		return prä1;
	}

	public String getPräfix2(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (frame.getLanguageCombi().get(key).getLanguage().equals(lang))
				prä2 = frame.getLanguageCombi().get(key).getPräfix();
		}
		return prä2;
	}

	private static CSVReflectionMap mapper;

	public String getPrä1() {
		return prä1;
	}

	public void setPrä1(String prä1) {
		this.prä1 = prä1;
	}

	public String getPrä2() {
		return prä2;
	}

	public void setPrä2(String prä2) {
		this.prä2 = prä2;
	}

}
