package Trainer;

import java.util.ArrayList;

/**
 *
 * @author Marcel Benning (c) 2016
 *
 */

public class CSVReflectionMap {

	private ArrayList<String> fields = new ArrayList<>();

	public CSVReflectionMap() {}

	public void setField(int index, String name) {
		this.ensureCapacity(index + 1);
		this.fields.set(index, name);
	}

	private void ensureCapacity(int size) {
		while (this.fields.size() < size) {
			this.fields.add("");
		}
	}

	public String getFieldNameByIndex(int index) {
		if ((index >= this.fields.size()) || (index < 0)) {
			return null;
		}
		return this.fields.get(index);
	}

	public int size() {
		return this.fields.size();
	}

}
