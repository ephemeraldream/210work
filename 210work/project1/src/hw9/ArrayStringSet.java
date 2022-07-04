package hw9;
/**
 * ArrayStringSet objects store a st of strings.
 * 
 * @author Rick Mercer
 */

import java.util.Iterator;

// Add this to remove the rawtypes warning
@SuppressWarnings("rawtypes")
public class ArrayStringSet implements Iterable {

  private int n;
  private String[] data = null;

  // Construct an empty set (no elements yet)
  public ArrayStringSet(int capacity) {
    this.n = 0;
    data = new String[capacity];
  }

  // Add a string to this StringBag if it is not already in the set
  public boolean add(String stringToAdd) {
    if (this.contains(stringToAdd))
      return false;
    if (n >= data.length)
      growArray();
    this.data[n] = stringToAdd;
    this.n++;
    return true;
  }

  // Allow more elements to be added when the array if filled with meaningful
  // elements
  private void growArray() {
    String[] temp = new String[data.length + 10];
    // Copy all elements into temp
    for (int i = 0; i < n; i++) {
      temp[i] = data[i];
    }
    data = temp;
  }

  // Determine if stringToAdd is, or is not in this set
  public boolean contains(String stringToAdd) {
    for (int i = 0; i < n; i++) {
      if (stringToAdd.equals(data[i]))
        return true;
    }
    return false;
  }

  // Return how many meaningful elements are in the array
  public int size() {
    return n;
  }

  // Return true if there are no elements in this set
  public boolean isEmpty() {
    return size() == 0;
  }

  // Generate and return a new set that is the union of this set and the other ArrayStringSet. 
  // The union of two sets is a set containing all elements that are in A or in B (possibly both).
  // For example, {"one", "two"} ∪nion {"two","three"} = {"one", "two", "three"}.
  public ArrayStringSet union(ArrayStringSet other) {
    ArrayStringSet result = new ArrayStringSet(this.size() + other.size());
    // Get this set's elements into the result
    for (int i = 0; i < this.size(); i++) {
      result.add(this.data[i]);
    }
    for (int i = 0; i < other.size(); i++) {
      result.add(other.data[i]);
    }
    return result;
  }

  
  // Generate and return a new ArrayStringSet that is the intersection of this set and the other 
  // ArrayStringSet. The intersection of two sets A and B, denoted by A∩B, consists of all elements
  // that are both in A and B. For example, {"one", "two} intersection  {"two","three"} = {"two"}. 
 public ArrayStringSet intersection(ArrayStringSet other) {
    ArrayStringSet result = new ArrayStringSet(this.size() + other.size());
    for (int i = 0; i < this.size(); i++) {
      if (other.contains(this.data[i])) {
        result.add(this.data[i]);
      }
    }
    for (int i = 0; i < other.size(); i++) {
      if (this.contains(other.data[i])) {
        result.add(other.data[i]);
      }
    }
    return result;

  }

  // Make this class Iterable which means we need this one method named iterator
  public Iterator iterator() {
    return new ArraySetIterator();
  }

  private class ArraySetIterator implements Iterator {

    private int current;

    public ArraySetIterator() {
      current = 0;
    }

    public boolean hasNext() {
      return current != size();
    }

    public String next() {
      String result = data[current];
      current++;
      return result;
    }
  }
}