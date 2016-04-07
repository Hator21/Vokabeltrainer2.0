package Trainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Bearbeiten {
	private String aus, in;

	public void getdata(ArrayList<Vokabeln> vokabeln) throws IOException, WriteException {
		Workbook workbook;
		int z = 0;
		try {
			workbook = Workbook.getWorkbook(new File("Vokabeln.xls"));
			Sheet sheet = workbook.getSheet(0);
			for (int r = 0; r < sheet.getRows(); r++) {
				while (z <= 1) {
					Cell cell = sheet.getCell(z, r);

					if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						if (z == 0)
							in = lc.getString();
						if (z == 1)
							aus = lc.getString();
					}
					z++;
				}
				vokabeln.add(new Vokabeln(in, aus));
				z = 0;
			}
			workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	public void write(ArrayList<Vokabeln> daten) throws IOException, WriteException {
		int z = 0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("Vokabeln.xls"));
			WritableSheet sheet = workbook.createSheet("Englisch", 0);
			Iterator<Vokabeln> it = daten.iterator();
			while (it.hasNext()) {
				Vokabeln vok = it.next();
				String aus = vok.getausland();
				String in = vok.getinland();

				Label label = new Label(0, z, aus);
				sheet.addCell(label);
				Label label2 = new Label(1, z, in);
				sheet.addCell(label2);
				z++;
			}
			workbook.write();
			workbook.close();
		} catch (FileNotFoundException e) {
			System.out.println("Mach Excel zu!");
		}
	}
	public void Hinzufügen(ArrayList<Vokabeln> vokabeln){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inland="";
		String ausland="";
		
		System.out.println("Geben sie das Deutschewort ein.");
		try{
			inland = br.readLine();
		}catch(IOException e){
			return;
		}
		System.out.println("Geben sie das Fremdsprachenwort ein.");
		try{
			ausland = br.readLine();
		}catch(IOException e){
			return;
		}
		vokabeln.add(new Vokabeln(ausland,inland));
	}
}
