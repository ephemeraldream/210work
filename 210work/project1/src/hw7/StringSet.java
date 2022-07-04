/*
 * A collection class that maintains unique String elements.
 * By definition, sets are not sorted or in any particular order.
 * There can be no String get(int index) method, only contains(String str)
 *
 * @author Rick Mercer and Ivan Akinfiev
 */
public class StringSet {

	private String[] set;
	private int len;

	// Construct an empty set that can store any number of String elements
	public StringSet(int capacity) {
		set = new String[0];
		len = 0;
	}

	// Return true if there are zero elements in this set
	public boolean isEmpty() {
		return (len == 0);
	}

	// Return the number of unique String elements that are in this set
	public int size() {
		return len;
	}

	// If element exists, return false. Otherwise, place element anywhere in the set
	// and return true. If there is no more room because the String[] is filled to
	// capacity, grow the String[] by 10 elements before inserting the new element.
	public boolean add(String element) {
		for (String s : set) {
			if (s.equals(element)) {
				return false;
			}
		}
		String[] temp = new String[len + 1];
		len++;
		for (int i = 0; i < len - 1; i++) {
			temp[i] = set[i];
		}
		temp[len - 1] = element;
		set = temp;
		return true;
	}

	// Return true if element is in this StringSet
	public boolean contains(String element) {
		for (String s : set) {
			if (s.equals(element)) {
				return true;
			}
		}
		return false;
	}

	// toString shows all elements surrounded by square brackets [ ] and
	// all elements separated by ", " as shown in this @Test method.
	//
	// @Test
	// public void testToString() {
	// StringSet names = new StringSet(10);
	// assertEquals("[]", names.toString());
	// assertTrue(names.add("Kim"));
	// assertEquals("[Kim]", names.toString());
	// assertTrue(names.add("Chris"));
	// assertEquals("[Kim, Chris]", names.toString());
	// assertTrue(names.add("Devon"));
	// assertEquals("[Kim, Chris, Devon]", names.toString());
	// assertTrue(names.add("Ali"));
	// assertEquals("[Kim, Chris, Devon, Ali]", names.toString());
	// }
	//
	public String toString() {
		if (len == 0) {
			return "[]";
		} else {

			String str = "[";
			for (int i = 0; i < len - 1; i++) {
				str = str + set[i] + ", ";
			}
			str = str + set[len - 1] + ']';
			return str;
		}
	}

	// Remove element if it is in this set, otherwise return false
	public boolean remove(String element) {
		int removingLocation;
		for (int i = 0; i < len; i++) {
			if (set[i].equals(element)) {
				String[] temp = new String[len - 1];
				removingLocation = i;
				for (int j = 0; j < removingLocation; j++) {
					temp[j] = set[j];
				}
				for (int k = removingLocation; k < len - 1; k++) {
					temp[k] = set[k + 1];
				}
				set = temp;
				len--;
				return true;
			}
		}
		return false;
	}

}