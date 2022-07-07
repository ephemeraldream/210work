

// Ivan Akinfiev

package PriorityList.model;
import java.util.Iterator;

// PriorityList objects store a collection of elements as an indexed list.
public class ArrayPriorityList<E> implements PriorityList<E>, Iterable<E> {
 
  // Instance
  private Object[] data;
  private int n;

  // Create an empty list with zero elements
  public ArrayPriorityList(int capacity) {
    data = new Object[capacity];
    n = 0;
  }  
  
  /**
   * Return the number of elements currently in this PriorityList
   * 
   * @return The number of elements in this PriorityList
   */
  public int size(){
    return n;
  }

  /**
   * Return true if there are zero elements in this PriorityList
   * 
   * @return true if size() == 0 or false if size() > 0
   */
  public boolean isEmpty(){
    return n == 0;
  }

  /**
   * If possible, insert the element at the given index. If index is out of the
   * valid range of 0..size(), throw new IllegalArgumentException(); When size is
   * 3, the only possible values for index are 0, 1, 2, AND 3 because you can add
   * an element as the new last.
   * 
   * @param index
   *          The index of the element to move.
   * @param el
   *          The element to insert
   * @throws IllegalArgumentException
   */
  public void insertElementAt(int index, E el) throws IllegalArgumentException {
    if (index > n) {
      throw new IllegalArgumentException();
    }
    Object[] newArray = new Object[n+1];
    if (index == n){
      for (int i = 0; i < n; i++){
        newArray[i] = data[i];
      }
      newArray[n] = el;
      n++;
      data = newArray.clone();
    }
    else if (index == 0){
      for (int i = 0; i < n; i++){
        newArray[i+1] = data[i];
      }
      newArray[0] = el;
      n++;
      data = newArray.clone();
    }
    else {
      for (int i = 0; i < index; i++){
        newArray[i] = data[i];
      }
      newArray[index] = el;
      for (int i = index + 1; i < n+1; i++) {
        newArray[i] = data[i-1];
      }
      n++;
      data = newArray.clone();
    }


  }

  /**
   * If possible, return a reference to the element at the given index. If index
   * is out of the valid range of 0..size()-1, throw new
   * IllegalArgumentException(); When size is 3, the only possible values for
   * index are 0, 1, and 2.
   * 
   * @param index
   *          The index where the element gets inserted into. All other elements
   *          must remain this list.
   * @return A reference to the element at index index.
   * @throws IllegalArgumentException
   */
  public E getElementAt(int index) throws IllegalArgumentException {
    if (index > n || index < 0){
      throw  new IllegalArgumentException();
    }
    else return (E) data[index];
  }

  /**
   * If possible, remove the element at the given index. If index is out of the
   * valid range of 0..size()-1, throw new IllegalArgumentException(); When size
   * is 3, the only possible values for index are 0, 1, and 2.
   * 
   * @param index
   *          The index of the element to remove. All other elements must remain.
   * @throws IllegalArgumentException
   */
  public void removeElementAt(int index) throws IllegalArgumentException {
    if (index >= n || index < 0){
      throw new IllegalArgumentException();
    }
    Object[] newArray = new Object[n-1];
    if (index == 0){
      for (int i = 0; i < n-1; i++) {
        newArray[i] = data[i+1];
      }
      data = newArray.clone();
    }
    else if (index == n-1){
      for (int i = 0; i < n-1; i++) {
        newArray[i] = data[i];
      }
      data = newArray.clone();
    }
    else {
      for (int i = 0; i < index; i++) {
        newArray[i] = data[i];
      }
      for (int i = index+1; i < n; i++) {
        newArray[i-1] = data[i];
      }
    }
    n--;
    data = newArray.clone();
  }

  /**
   * If possible, swap the element located at index with the element at index + 1.
   * An attempt to lower the priority of the element at index size()-1 has no
   * effect. If index is out of the valid range of 0..size()-1, throw new
   * IllegalArgumentException(); When size is 3, the only possible values for
   * index are 0, 1, and 2.
   * 
   * @param index
   *          The index of the element to be changed with one next to it.
   * @throws IllegalArgumentException
   */
  public void lowerPriorityOf(int index) throws IllegalArgumentException {
    if (index >= n || index < 0 ){
      throw new IllegalArgumentException();
    }
    if (index == n-1){
      ;
    }
    else{
      Object tempPlusOne = data[index+1];
      Object temp = data[index];
      data[index] = tempPlusOne;
      data[index+1] = temp;
    }

  }

  /**
   * If possible, swap the element located at index with the element at index-1.
   * An attempt to raise the priority at index 0 has no effect. If index is out of
   * the valid range of 0..size()-1, throw new IllegalArgumentException(); When
   * size is 3, the only possible values for index are 0, 1, and 2.
   * 
   * @param index
   *          The index of the element to be changed with one next to it.
   * @throws IllegalArgumentException
   */
  public void raisePriorityOf(int index) throws IllegalArgumentException {
    if (index >= n || index < 0 ){
      throw new IllegalArgumentException();
    }
    if (index == 0){
      ;
    }
    else{
      Object tempPlusOne = data[index-1];
      Object temp = data[index];
      data[index] = tempPlusOne;
      data[index-1] = temp;
    }

  }

   /**
   * Return a copy of all elements as an array of Objects that is the size of this
   * PriorityList and in the same order. If there are no elements in this list,
   * return new Object[0]; A change to the return value must not affect this
   * PriorityList object.
   * 
   * @return An array of Objects where capacity == size()
   */
  public Object[] toArray(){
    if (n == 0){
      return new Object[0];
    }
    else{
      Object[] temp = new Object[n];
      for (int i = 0; i < n; i++) {
        temp[i] = data[i];
      }
      return temp;
    }
  }


  /**
   * If possible, move the element at the given index to the end of this list. An
   * attempt to move the last element to the last has no effect. If the index is
   * out of the valid range 0..size()-1 throw new IllegalArgumentException(); When
   * size is 3, the only possible values for index are 0, 1, and 2.
   * 
   * @param index
   *          The index of the element to be changed to be the last index.
   * @throws IllegalArgumentException
   */
  public void moveToLast(int index) throws IllegalArgumentException {
    if (index >= n || index < 0 ){
      throw new IllegalArgumentException();
    }
    if (index == n-1){
      ;
    }
    else{
      Object[] newArray = new Object[n];
      Object element = data[index];
      for (int i = 0; i < index; i++) {
        newArray[i] = data[i];
      }
      for (int i = index+1; i < n; i++) {
        newArray[i-1] = data[i];
      }
      newArray[n-1] = element;
      data = newArray.clone();
    }
  }

  /**
   * If possible, move the element at the given index to the front of this list An
   * attempt to move the top element to the top has no effect. If the index is out
   * of the valid range of 0..size()-1, throw new IllegalArgumentException(); When
   * size is 3, the only possible values for index are 0, 1, and 2.
   * 
   * @param index
   *          The index of the element to be changed to the first index.
   * @throws IllegalArgumentException
   */
  public void moveToTop(int index) throws IllegalArgumentException {

    if (index >= n || index < 0 ){
      throw new IllegalArgumentException();
    }
    if (index == 0){
      ;
    }
    else{
      Object[] newArray = new Object[n];
      Object element = data[index];
      for (int i = 0; i < index; i++) {
        newArray[i+1] = data[i];
      }
      for (int i = index+1; i < n; i++) {
        newArray[i] = data[i];
      }
      newArray[0] = element;
      data = newArray.clone();

    }
  }

  @Override
  public String toString(){
    String str = "";
    for (int i = 0; i < n; i++) {
      str += " " + data[i];
    }
    return str;
  }

  @Override
  public Iterator<E> iterator() {
    return new ArrayPriorityListIterator<E>();
  }
  private class ArrayPriorityListIterator<E> implements Iterator<E>{

    private int length = 0;
    @Override
    public boolean hasNext() {
      return length != size();
    }

    @Override
    public E next() {
      E result = (E) data[length];
      length++;
      return result;
    }
  }



}