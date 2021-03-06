package a01;

import java.util.LinkedList;

/**
 * 
 * @author Yejay Demirkan
 * @author Vasiliki Ioannidou
 *
 */
public class Hashtable implements IntStringMap {
	private int size;
	int count;
	private LinkedList<KeyValuePair>[] table;

	@SuppressWarnings("unchecked")
	public Hashtable(int size) {
		this.size = size;
		this.table = new LinkedList[size];
	}

	public int size() {
		return count;
	}

	/**
	 * Calculates the index of the given key with help from a hashing algorithm.
	 * 
	 * @param key
	 * @return an integer value, generated by a hashing algorithm
	 */
	private int getIndex(Integer key) {
		return Math.abs(key.hashCode() % size);
	}

	@Override
	public String put(Integer key, String value) {
		// Get the index
		int index = getIndex(key);

		// Create the linked list entry
		KeyValuePair e = new KeyValuePair(key, value);
		LinkedList<KeyValuePair> entry = new LinkedList<>();
		entry.add(e);

		// If no entry there - add it
		if (table[index] == null) {
			table[index] = entry;
			count++;
		} else {
			// Get element at given index
			KeyValuePair entries = table[index].element();
			// Save old value for return statement
			String old = entries.value;
			// Set new value
			entries.value = value;
			count++;
			return old;
		}
		return null;
	}

	@Override
	public String get(Integer key) {
		// Get the index
		int index = getIndex(key);
		// If given index is not allocated return null...
		if (table[index] == null) {
			return null;
		}
		// ...to avoid NullPointerException here
		// Get element at given index
		KeyValuePair e = table[index].element();
		// Check if element key is equals to given key
		if (e != null) {

			// Unnecassery code I think
//			while (!entries.key.equals(key) && entries.next != null) {
//				entries = entries.next;
//			}

			return e.value;
		}
		return null;
	}

	@Override
	public String remove(Integer key) {
		// Get the index
		int index = getIndex(key);
		// If given index is not allocated return null...
		if (table[index] == null) {
			return null;
		}
		// ...to avoid NullPointerException here
		// Get element at given index
		KeyValuePair e = table[index].element();
		// Check if element key is equals to given key
		if (e.key.equals(key)) {
			// Save old value for return statement
			String old = e.value;
			// remove old value
			e.value = null;
			count--;
			// return old value
			return old;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (table[i] == null) {
				sb.append("null");
			} else {
				sb.append("[");
			}
			for (KeyValuePair e : table[i]) {
				String index = String.format("INDEX = %3d", i);
				String value = String.format("VALUE = %10s", e.value);
				String key = String.format("KEY = %3d", e.key);
				sb.append(String.format("%4s", index));
				sb.append("]     [");
				sb.append(String.format(key));
				sb.append("]     [");
				sb.append(String.format(value));
			}
			if (!table[i].isEmpty()) {
				sb.append("]\n");
			} else {
				sb.append("null");
			}
		}
		return sb.toString();
	}
}
