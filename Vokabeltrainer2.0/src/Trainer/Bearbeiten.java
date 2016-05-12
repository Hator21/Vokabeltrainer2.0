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
	private String pr�1,pr�2;

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

	//	public void Hinzuf�gen(ArrayList<Vokabel> vokabeln) throws Exception {
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

	public ArrayList<String> getLektionList(String pr�1, String pr�2) {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (frame.getVokabeln().get(i).getCountryOriginCode().equals(pr�1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(pr�2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
				liste.add("Lektion " + this.frame.getVokabeln().get(i).getLection());
			}
		}
		return liste;
	}
	public ArrayList<Integer> getLektions() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < this.frame.getVokabeln().size(); i++) {
			if (frame.getVokabeln().get(i).getCountryOriginCode().equals(pr�1) && frame.getVokabeln().get(i).getCountryDistinationCode().equals(pr�2) && !liste.contains(this.frame.getVokabeln().get(i).getLection())) {
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
	public void putPr�fix(JComboBox cb) {
		String language = cb.getSelectedItem().toString();
		String lang1 = language.split("-")[0];
		String lang2 = language.split("-")[1];
		pr�1 = getPr�fix1(lang1);
		pr�2 = getPr�fix2(lang2);
	}
	public String getPr�fix1(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (key.getLanguage().equals(lang))
				pr�1 = key.getPr�fix();
		}
		return pr�1;
	}

	public String getPr�fix2(String lang) {
		for (Language key : frame.getLanguageCombi().keySet()) {
			if (frame.getLanguageCombi().get(key).getLanguage().equals(lang))
				pr�2 = frame.getLanguageCombi().get(key).getPr�fix();
		}
		return pr�2;
	}

	private static CSVReflectionMap mapper;

	public String getPr�1() {
		return pr�1;
	}

	public void setPr�1(String pr�1) {
		this.pr�1 = pr�1;
	}

	public String getPr�2() {
		return pr�2;
	}

	public void setPr�2(String pr�2) {
		this.pr�2 = pr�2;
	}

}
