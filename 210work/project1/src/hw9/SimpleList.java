package hw9;

/**
 * This interface specifies the methods for a generic List ADT. It is designed
 * to have classes use a type parameter <E> so any type element can be stored.
 * Some methods will be implemented with an array data structure in this chapter
 * and then as a linked structure in the chapter that follows.
 *
 * These six methods are a subset of the 25 methods specified in the interface
 * that comes with Java's interface java.util.List<E>
 * 
 * @author Rick Mercer
 */
public interface SimpleList<E> {
 
  // Insert an element at the specified location.
  // Precondition: insertIndex >= 0 and insertIndex <= size().
  public void add(int insertIndex, E element);
 
  // Return the number of elements currently in the list.
  public int size();
 
  // Get the element stored at a specific index.
  // Precondition: insertIndex >= 0 and insertIndex < size()
  public E get(int getIndex);

  // Replace the element at a specific index with element.
  // Precondition: insertIndex >= 0 and insertIndex < size().
  public void set(int insertIndex, E element);
 
  // Return a reference to search in the list or return null if not found.
  public E find(E search);
 
  // Remove the first occurrence of element and return true. 
  // If element is not found leave the list unchanged and return false
  public boolean remove(E element);
}
 
