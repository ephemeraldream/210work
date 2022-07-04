package hw9;
import java.util.Iterator;

/**
 * A collection class to represent a Set ADT the store String objects only.
 * LinkedSet objects can be iterated over with hasNext() and next() using a cast
 * to String.
 *
 * @author Rick Mercer and Ivan Akinfiev
 */
@SuppressWarnings("rawtypes")
public class LinkedStringSet implements Iterable {

	private class Node {
		private String data;
		private Node next;

		// Use either constructor
		public Node(String element) {
			data = element;
			next = null;
		}

		public Node(String element, Node nextRef) {
			data = element;
			next = nextRef;
		}
	}

	private Node head;
	private Node cur;
	private Node curForIterator;
	private Node curForPrint;
	private int n;

	// Create a new empty set
	public LinkedStringSet() {
		n = 0;
		head = new Node(null);
		cur = head;
		curForIterator = head;
		curForPrint = head;

	}

	// Return the number of elements in this set
	public int size() {
		return n;
	}

	// Add an element to this set if it does not already exist.
	// If this set has an element that equals element, return false.
	public boolean add(String element) {
		if (n == 0) {
			head.data = element;
			n++;
			return true;
		} else if (contains(element)) {
			return false;
		} else {
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = new Node(element);
			cur = head;
			n++;
			return true;
		}
	}

	// Return true if element is in this set.
	public boolean contains(String element) {
		cur = head;
		while (cur.next != null) {
			if (cur.data.equals(element)) {
				return true;
			}
			cur = cur.next;
		}
		if (cur.data.equals(element))
			return true;
		cur = head;
		return false;
	}

	// Return true if there are no elements in this set
	public boolean isEmpty() {
		return (n == 0);
	}

	@Override
	public String toString() {
		String str = "";
		while (curForPrint.next != null) {
			str = str + curForPrint.data + "->";
			curForPrint = curForPrint.next;
		}
		str = str + curForPrint.data;
		curForPrint = head;
		return str;
	}

	// Generate and return a new set that is the union of this set and the other
	// LinkedStringSet.
	// The union of two sets is a set containing all elements that are in A or in B
	// (possibly both).
	// For example, {"one", "two"} ∪nion {"two","three"} = {"one", "two", "three"}.
	public LinkedStringSet union(LinkedStringSet other) {
		LinkedStringSet newSet = this;
		Iterator iteratorB = other.iterator();
		Iterator iteratorA = this.iterator();
		if (this.isEmpty() && other.isEmpty()) {
			return new LinkedStringSet();
		} else if (this.isEmpty())
			return other;
		else if (other.isEmpty())
			return this;
		else
			while (iteratorB.hasNext()) {
				String elementB = (String) iteratorB.next();
				if (!this.contains(elementB)) {
					newSet.add(elementB);
				}
			}
		while (iteratorA.hasNext()) {
			String elementA = (String) iteratorA.next();
			if (!other.contains(elementA)) {
				newSet.add(elementA);
			}
		}
		return newSet;

	}

	// Generate and return a new LinkedStringSet that is the intersection of this
	// set and the other
	// LinkedStringSet. The intersection of two sets A and B, denoted by A∩B,
	// consists of all elements
	// that are both in A and B. For example, {"one", "two} intersection
	// {"two","three"} = {"two"}.
	public LinkedStringSet intersection(LinkedStringSet other) {
		LinkedStringSet newSet = new LinkedStringSet();
		Iterator iteratorB = other.iterator();
		Iterator iteratorA = this.iterator();
		if (this.isEmpty() && other.isEmpty()) {
			return new LinkedStringSet();
		} else if (this.isEmpty())
			return new LinkedStringSet();
		else if (other.isEmpty())
			return new LinkedStringSet();
		else
			while (iteratorB.hasNext()) {
				String elementB = (String) iteratorB.next();
				if (this.contains(elementB)) {
					newSet.add(elementB);
				}
			}
		while (iteratorA.hasNext()) {
			String elementA = (String) iteratorA.next();
			if (other.contains(elementA)) {
				newSet.add(elementA);
			}
		}
		return newSet;

	}

	// This is the one method in interface Iterator
	public Iterator iterator() {
		return new LinkedStringSetIterator();
	}

	// This private inner class has access to the private instance variable front.
	private class LinkedStringSetIterator implements Iterator {

		public boolean hasNext() {
			if (curForIterator == null) {
				cur = head; // Can I reset an iterator here? If so, here it is.
				return false;
			} else
				return true;
		}

		@Override
		public Object next() {
			if (hasNext()) {
				String data = curForIterator.data;
				curForIterator = curForIterator.next;
				return data;
			}
			return null;
		}

	} // end class LinkedStringSetIterator

} // end class LinkedStringSet