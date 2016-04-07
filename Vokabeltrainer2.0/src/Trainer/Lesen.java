package Trainer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Lesen {
	private String aus, in;

	public void getdata(ArrayList<Vokabeln> vokabeln) throws IOException, WriteException {
		Workbook workbook;
		int z = 0;
		try {
			workbook = Workbook.getWorkbook(new File("data/Vokabeln.xls"));
			Sheet sheet = workbook.getSheet(0);
			for (int r = 0; r < sheet.getRows(); r++) {
				while (z <=1) {
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
				z=0;
			}
			workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
}