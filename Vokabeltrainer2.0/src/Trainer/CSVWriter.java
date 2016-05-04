package Trainer;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 *
 * @author Marcel Benning (c) 2016
 *
 */

public class CSVWriter {

	private File file;

	public CSVWriter(File f) {
		this.file = f;
	}

	public <T> void save(CSVReflectionMap mapper, ArrayList<T> list, Class<T> c, boolean writeMapperNames) throws Exception {
		@SuppressWarnings("resource")
		PrintWriter writer = new PrintWriter(this.file);
		if (writeMapperNames) {
			for (int i = 0; i < mapper.size(); i++) {
				writer.print(mapper.getFieldNameByIndex(i) + (i != (mapper.size() - 1) ? ";" : ""));
			}
		}
		writer.println();
		for (T obj : list) {
			String line = "";
			for (int i = 0; i < mapper.size(); i++) {
				String fieldName = mapper.getFieldNameByIndex(i);
				if (fieldName == null) {
					throw new Exception("Undeclared field : " + i);
				}
				Field f = obj.getClass().getDeclaredField(fieldName);
				boolean acc = Modifier.isPrivate(f.getModifiers());
				f.setAccessible(true);
				String fieldValue = f.get(obj).toString();
				f.setAccessible(!acc);
				line += fieldValue + (i != (mapper.size() - 1) ? ";" : "");
			}
			writer.println(line);
		}
		writer.flush();
		writer.close();
	}

}
