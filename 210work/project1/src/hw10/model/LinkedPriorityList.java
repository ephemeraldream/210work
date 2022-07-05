package hw10.model;

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
  }

  private Node first;
  private int n;

  // Create an empty list with zero elements
  public LinkedPriorityList() {
    first = null;
    n = 0;
  }
  
  
}