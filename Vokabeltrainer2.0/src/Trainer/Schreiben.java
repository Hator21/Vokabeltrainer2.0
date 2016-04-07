package Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Schreiben {
	public void write(ArrayList<Vokabeln> daten) throws IOException, WriteException {
		int z = 0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("data/Vokabeln.xls"));
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
}