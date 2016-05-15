package Trainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 *
 * @author Marcel Benning (c) 2016
 *
 */

public class CSVParser {

	private ArrayList<String>	lines;
	private File				file;

	public CSVParser(File f) throws IOException {
		if (!f.exists()) {
			throw new IOException("File does not exists!");
		}
		this.file = f;
	}

	/**
	 * parse the daten to a list
	 * 
	 * @param mapper
	 * @param c
	 * @param skipFirstLine
	 * @return
	 * @throws Exception
	 */
	public <T> ArrayList<T> parse(CSVReflectionMap mapper, Class<T> c, boolean skipFirstLine) throws Exception {
		this.lines = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(this.file));
		String line1 = "";
		while ((line1 = reader.readLine()) != null) {
			this.lines.add(line1);
		}
		reader.close();
		ArrayList<T> instances = new ArrayList<>();
		boolean skipped = false;
		for (String line : this.lines) {
			if (!skipped && skipFirstLine) {
				skipped = true;
				continue;
			}
			String[] values = line.split(";");
			T instance = c.newInstance();
			for (int i = 0; i < values.length; i++) {
				if (mapper.getFieldNameByIndex(i) == null) {
					throw new Exception("Undeclared field: " + i);
				}
				try {
					Field f = instance.getClass().getDeclaredField(mapper.getFieldNameByIndex(i));
					boolean acc = Modifier.isPrivate(f.getModifiers());
					f.setAccessible(true);
					f.set(instance, this.convertFieldValueToObject(f.getType(), values[i]));
					f.setAccessible(!acc);
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
			instances.add(instance);
		}
		return instances;
	}

	private Object convertFieldValueToObject(Class<?> destinationClass, String value) {
		Object objectValue = null;
		switch (destinationClass.getName()) {

			case "java.lang.String": {
				objectValue = value;
				break;
			}

			case "int":
			case "java.lang.Integer": {
				objectValue = Integer.valueOf(value);
				break;
			}

			case "double":
			case "java.lang.Double": {
				objectValue = Double.valueOf(value);
				break;
			}

			case "float":
			case "java.lang.Float": {
				objectValue = Float.valueOf(value);
				break;
			}

			case "long":
			case "java.lang.Long": {
				objectValue = Long.valueOf(value);
				break;
			}

			case "short":
			case "java.lang.Short": {
				objectValue = Short.valueOf(value);
				break;
			}

			case "char":
			case "java.lang.Character": {
				objectValue = Character.valueOf(value.charAt(0));
				break;
			}

			case "boolean":
			case "java.lang.Boolean": {
				objectValue = Boolean.valueOf(value);
				break;
			}

			default:
				break;
		}
		return objectValue;
	}

}
