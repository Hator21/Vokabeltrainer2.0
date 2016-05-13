package Trainer;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import NewGui.MainFrame;

public class Statistik {
	public Statistik(MainFrame frame) {
		this.setFrame(frame);
	}

	private static CSVReflectionMap	mapper;
	private MainFrame				frame;
	private static File				data	= new File("data/Statistik.csv");
	ArrayList<StatHelper>			stat	= new ArrayList<>();
	private CSVParser				parser;
	private CSVWriter				writer;

	public ArrayList<Vokabel> getdata() throws Exception {
		this.parser = new CSVParser(data);
		return this.parser.parse(getMapper(), Vokabel.class, true);
	}

	public void write(ArrayList<Vokabel> daten) throws Exception {
		this.writer = new CSVWriter(data);
		this.writer.save(getMapper(), daten, Vokabel.class, true);
	}

	public void NoteTest() {
		int right = this.frame.getVocabeltestPanel().getRight();
		String note = "";
		String date;
		String voctest;
		ArrayList<Integer> lections = new ArrayList<Integer>();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		date = day + "." + month + "." + year;
		voctest = this.frame.getVocabelPrePanel().getCombobox().getSelectedItem().toString();
		voctest = voctest.split("-")[1];
		lections = this.frame.getLek();

		right = (100 / 10) * right;
		if (right >= 95) {
			note = "1";
		}
		if ((right >= 90) && (right < 95)) {
			note = "1-";
		}
		if ((right >= 85) && (right < 90)) {
			note = "2+";
		}
		if ((right >= 80) && (right < 85)) {
			note = "2";
		}
		if ((right >= 75) && (right < 80)) {
			note = "2-";
		}
		if ((right >= 70) && (right < 75)) {
			note = "3+";
		}
		if ((right >= 65) && (right < 70)) {
			note = "3";
		}
		if ((right >= 60) && (right < 65)) {
			note = "3-";
		}
		if ((right >= 55) && (right < 60)) {
			note = "4+";
		}
		if ((right >= 50) && (right < 55)) {
			note = "4";
		}
		if ((right >= 45) && (right < 50)) {
			note = "4-";
		}
		if ((right >= 38) && (right < 45)) {
			note = "5+";
		}
		if ((right >= 31) && (right < 38)) {
			note = "5";
		}
		if ((right >= 25) && (right < 31)) {
			note = "5-";
		}
		if ((right >= 0) && (right < 25)) {
			note = "6";
		}

	}

	static CSVReflectionMap getMapper() {
		if (mapper == null) {
			mapper = new CSVReflectionMap();
			mapper.setField(0, "date");
			mapper.setField(1, "voktest");
			mapper.setField(2, "lections");
			mapper.setField(3, "note");

		}
		return mapper;
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
