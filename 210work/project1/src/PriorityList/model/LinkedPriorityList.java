package PriorityList.model;

import hw9.MyList;

import java.util.Iterator;

// PriorityList objects store a collection of elements as an indexed list.

public class LinkedPriorityList<E> implements PriorityList<E>, Iterable<E> {


  private class Node {
    private E data;
    private Node next;
    
    public Node(E element, Node link) {
      data = element;
      next = link;
    }
    public Node(E element){
      data = element;
      next = null;
    }
    @Override
    public String toString(){
      return (String) data;
    }
  }

  private Node head;
  private int n;


  public LinkedPriorityList() {
    head = null;
    n = 0;
  }



  @Override
  public int size() {
    return n;
  }


  @Override
  public boolean isEmpty() {
    return (n == 0);
  }

  @Override
  public void insertElementAt(int index, E el) throws IllegalArgumentException {
    if (index > n) {
      throw new IllegalArgumentException();
    } else if (head == null) {
        head = new Node(el);
    } else if (index == 0) {
      head = new Node(el, head);
    } else {
      Node cur = head;
      for (int i = 1; i < index; i++) {
        cur = cur.next;
      }
      cur.next = new Node(el, cur.next);
		}
    n++;
  }

  @Override
  public E getElementAt(int index) throws IllegalArgumentException {
    if (index >= n || index < 0) throw new IllegalArgumentException();
    else if (index == 0) {
      return head.data;
    } else {
      Node cur = head;
      for (int i = 1; i <= index; i++) {
        cur = cur.next;
        if (i == index) {
          return cur.data;
        }
      }
    }
    return null;
  }

  @Override
  public void removeElementAt(int index) throws IllegalArgumentException {
    if (index >= n || index < 0){
      throw new IllegalArgumentException();
    }
    Node cur = head;
    for (int i = 0; i < index-1; i++) {

      cur = cur.next;
    }
    cur.next = cur.next.next;
  }

  @Override
  public void lowerPriorityOf(int index) throws IllegalArgumentException {
    if (index < 0 || index >= n){
      throw new IllegalArgumentException();
    }
    if (index == n - 1 || n == 1){
      ;
    }
    else{
      Node cur = head;
      if (index == 0){
        E temp = head.data;
        head.data = cur.next.data;
        cur.next.data = temp;


      }
      else{
        for (int i = 0; i < index; i++) {
          cur = cur.next;
        }
        E temp = cur.data;
        cur.data = cur.next.data;
        cur.next.data = temp;
      }
    }


  }

  @Override
  public void raisePriorityOf(int index) throws IllegalArgumentException {
    if (index < 0 || index >= n){
      throw new IllegalArgumentException();
    }
    if (index == 0){
      ;
    }
    else {
      Node cur = head;
      for (int i = 0; i < index-1; i++) {
        cur = cur.next;
      }
      E temp = cur.data;
      cur.data = cur.next.data;
      cur.next.data = temp;
    }

  }

  @Override
  public Object[] toArray() {
    Node cur = head;
    Object[] myArray = new Object[n];
    for (int i = 0; i < n-1; i++) {
      myArray[i] = cur.data;
      cur = cur.next;

    }
    return myArray;
  }

  @Override
  public void moveToLast(int index) throws IllegalArgumentException {
    if (index < 0 || index >= n){
      throw new IllegalArgumentException();
    }
    if (index == n - 1){
      ;
    }
    else if (index == 0){
      Node cur = head;
      Node firstNode = head;
      for (int i = 0; i < n-1; i++) {
        cur = cur.next;
      }
      cur.next = new Node(firstNode.data);
      head = firstNode.next;
    }
    else {
      Node cur = head;
      Node end = head;
      for (int i = 0; i < index-1; i++) {
        cur = cur.next;
      }
      for (int i = 0; i < n-1; i++){
        end = end.next;
      }
      Node newNode = new Node(cur.next.data);
      cur.next = cur.next.next;
      end.next = newNode;

    }
  }

  @Override
  public void moveToTop(int index) throws IllegalArgumentException {
    if (index < 0 || index >= n){
      throw new IllegalArgumentException();
    }
    if (index == 0){
      ;
    }
    else {
      Node cur = head;
      for (int i = 0; i < index-1; i++) {
        cur = cur.next;
      }
      Node firstNode = new Node(cur.next.data, head);
      cur.next = cur.next.next;
      head = firstNode;
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedPriorityListIterator<E>();
  }

  private class LinkedPriorityListIterator<E> implements Iterator<E> {

    private Node cur = head;

    @Override
    public boolean hasNext() {
      return cur != null;
    }
    @Override
    public E next() {
      E data = (E) cur.data;
      cur = cur.next;
      return data;
    }
  }

  // Create an empty list with zero elements

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

}