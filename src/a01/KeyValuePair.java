package a01;

public class KeyValuePair {
	final Integer key;
	String value;
	KeyValuePair next;

	KeyValuePair(Integer key, String value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	/**
	 * @return the key
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the next
	 */
	public KeyValuePair getNext() {
		return next;
	}
}