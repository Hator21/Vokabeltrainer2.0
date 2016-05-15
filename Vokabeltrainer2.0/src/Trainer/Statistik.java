package Trainer;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public ArrayList<StatHelper> getData() throws Exception {
		this.parser = new CSVParser(data);
		return this.parser.parse(getMapper(), StatHelper.class, true);
	}

	public void write(ArrayList<StatHelper> daten) throws Exception {
		this.writer = new CSVWriter(data);
		this.writer.save(getMapper(), daten, StatHelper.class, true);
	}

	public String getNote() {
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
		return note;
	}

	/**
	 * 
	 * @return currend date
	 */
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = new Date();
		String date = dateFormat.format(data);
		return date;
	}

	public String getRight() {
		return frame.getVocabeltestPanel().getRight() + "";
	}

	public String getWrong() {
		return (frame.getVocabelPrePanel().getCoundSlider().getValue() - frame.getVocabeltestPanel().getRight()) + "";
	}

	public String getLanguage() {
		return frame.getVocabelPrePanel().getCombobox().getSelectedItem().toString();
	}

	static CSVReflectionMap getMapper() {
		if (mapper == null) {
			mapper = new CSVReflectionMap();
			mapper.setField(0, "date");
			mapper.setField(1, "sprache");
			mapper.setField(2, "right");
			mapper.setField(3, "wrong");
			mapper.setField(4, "note");

		}
		return mapper;
	}

	public void retDateForTable() {
		stat.add(new StatHelper(getDate(), getLanguage(), getRight(), getWrong(), getNote()));
		Object[] data = new Object[] {
				getDate(), getLanguage(), getRight(), getWrong(), getNote()
		};
		frame.getStatisticsPanel().getTableModel().addRow(data);
	}

	public MainFrame getFrame() {
		return this.frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the stat
	 */
	public ArrayList<StatHelper> getStat() {
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(ArrayList<StatHelper> stat) {
		this.stat = stat;
	}

}
