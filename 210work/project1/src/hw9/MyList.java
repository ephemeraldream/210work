package hw9;

// Ivan Akinfiev

public class MyList<E> implements SimpleList<E> {

	private class Node {
		private E data;
		private Node next;

		public Node(E element) {
			data = element;
			next = null;
		}

		public Node(E element, Node nextRef) {
			data = element;
			next = nextRef;
		}
	}

	private Node head;
	private int len = 0;
	private Node cur;

	public MyList() {
	}

	public void add(int insertIndex, E element) {
		if (head == null) {
			head = new Node(element);
		} else if (insertIndex > len) {
			System.exit(0);
		} else if (insertIndex == 0) {
			head = new Node(element, head);

		} else {
			Node cur = head;
			for (int i = 1; i < insertIndex; i++) {
				cur = cur.next;
			}
			cur.next = new Node(element, cur.next);
		}
		len++;
	}

	public int size() {
		return len;
	}

	public E get(int getIndex) {
		if (getIndex >= len)
			System.exit(0);
		else if (getIndex == 0) {
			return head.data;
		} else {
			Node cur = head;
			for (int i = 1; i <= getIndex; i++) {
				cur = cur.next;
				if (i == getIndex) {
					return cur.data;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		Node curForPrint = head;
		String str = "";
		while (curForPrint.next != null) {
			str = str + curForPrint.data + "->";
			curForPrint = curForPrint.next;
		}
		str = str + curForPrint.data;
		curForPrint = head;
		return str;
	}

	public void set(int insertIndex, E element) {
		if (insertIndex == 0) {
			head.data = element;
		} else {
			Node cur = head;
			for (int i = 1; i <= insertIndex; i++) {
				cur = cur.next;
			}
			cur.data = element;
		}

	}

	public E find(E search) {
		Node cur = head;
		for (int i = 0; i < len; i++) {
			if (cur.data instanceof String) {
				if (cur.data.equals(search)) {
					return cur.data;
				}
			} else if (cur.data == search) {
				return cur.data;
			}
			cur = cur.next;
		}
		return null;
	}

	public boolean remove(E element) {
		Node cur = head;
		if (head == null) {
			return false;
		} else {
			for (int i = 0; i < len - 1; i++) {

				if (cur.next.data instanceof String) {
					E xd = cur.next.data;
					if (head.data.equals(element)) {
						head = cur.next;
						return true;
					} else if (cur.next.data.equals(element)) {
						cur.next = cur.next.next;
						return true;
					}
				} else {
					if (head.data == element) {
						head = cur.next;
						return true;
					} else if (cur.next.data == element) {
						cur.next = cur.next.next;
						return true;
					}
				}
				cur = cur.next;
			}
		}
		return false;
	}
}
