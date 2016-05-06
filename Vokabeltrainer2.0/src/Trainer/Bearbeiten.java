package Trainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import NewGui.MainFrame;

public class Bearbeiten {
	private String		aus, in;
	private MainFrame	frame;

	private static File	vocFile	= new File("data/Vokabeln.csv");
	private CSVParser	parser;
	private CSVWriter	writer;

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

	public void Hinzufügen(ArrayList<Vokabel> vokabeln) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inland = "";
		String ausland = "";

		System.out.println("Geben sie das Deutschewort ein.");
		try {
			inland = br.readLine();
		} catch (IOException e) {
			return;
		}
		System.out.println("Geben sie das Fremdsprachenwort ein.");
		try {
			ausland = br.readLine();
		} catch (IOException e) {
			return;
		}
		vokabeln.add(new Vokabel(ausland, inland));
		this.write(vokabeln);
	}
	public void Close(){
		try{
		this.write(frame.getVokabeln());
		}catch(Exception e){
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

	private static CSVReflectionMap mapper;

}
