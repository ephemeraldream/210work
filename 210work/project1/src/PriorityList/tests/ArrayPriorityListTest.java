package PriorityList.tests;

/** 
 * Unit test for ArrayPriorityList.
 * 
 *@author Ivan Akinfiev
*/ 

// Using

import PriorityList.model.ArrayPriorityList;
import PriorityList.model.LinkedPriorityList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayPriorityListTest {
  
  @Test
  public void testSizeAndEmpty(){
    ArrayPriorityList<String> lsit = new ArrayPriorityList<String>(10);
    lsit.insertElementAt(0, "123");
    lsit.insertElementAt(1, "123");
    assertEquals(2, lsit.size());
    assertFalse(lsit.isEmpty());

  }
  @Test void testMoveToLast(){
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "A");
    list.insertElementAt(1, "B");
    list.insertElementAt(2, "C");
    list.insertElementAt(3, "end");
    list.moveToLast(2);
    assertEquals("C", list.getElementAt(3));
    list.moveToLast(1);
    assertEquals("B", list.getElementAt(3));
    list.moveToTop(2);
    assertEquals("C",list.getElementAt(0));
  }
  @Test
  public void testLowerOrHigherPrio(){
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "A");
    list.insertElementAt(1, "B");
    list.insertElementAt(2, "C");
    list.insertElementAt(3, "end");
    list.lowerPriorityOf(2);
    assertEquals("C", list.getElementAt(3));
    list.lowerPriorityOf(0);
    assertEquals("A", list.getElementAt(1));
  }
  @Test
  public void testLinked() {
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "A");
    list.insertElementAt(1, "B");
    list.insertElementAt(2, "C");
    list.insertElementAt(3, "end");

    String result = "";
    for(String str : list) {
      result += str;
    }
    assertEquals("ABCend", result);
  }

  @Test //(expected = IllegalArgumentException.class)
  public void testDidNotThrowExceptionDuringMoveToLastWithArgumentEqualToSize() {
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "1st");
    list.insertElementAt(0, "2nd");
    list.insertElementAt(0, "3rd");
    assertEquals("3rd", list.getElementAt(0));
    list.moveToLast(3);
  }

  // Add many more @Tests
  @Test
  public void testInsert(){
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "BOB");
    list.insertElementAt(1, "Alice");
    list.insertElementAt(2, "Mark");
    list.insertElementAt(3,"Lucy");
    System.out.println(list.toString());
    assertEquals("Alice", list.getElementAt(1));
    assertEquals("BOB", list.getElementAt(0));
  }

  @Test
  public void testGet(){
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "BOB");
    list.insertElementAt(1, "Alice");
    list.insertElementAt(2, "Mark");
    assertEquals("BOB",list.getElementAt(0));
    assertEquals("Alice", list.getElementAt(1));
    assertSame("Alice", list.getElementAt(1));


  }
  @Test
  public void testRemoveAtIndex(){
    ArrayPriorityList<String> list = new ArrayPriorityList<String>(10);
    list.insertElementAt(0, "BOB");
    list.insertElementAt(1, "Alice");
    list.insertElementAt(2, "Mark");
    list.removeElementAt(0);
    assertEquals("Alice", list.getElementAt(0));
    assertEquals("Mark", list.getElementAt(1));
  }
  @Test
  public void testLowerPriority(){
    ArrayPriorityList<String> lowprio = new ArrayPriorityList<String>(10);
    lowprio.insertElementAt(0, "BOB");
    lowprio.insertElementAt(1, "Alice");
    lowprio.insertElementAt(2, "Mark");
    lowprio.insertElementAt(3, "David");
    lowprio.insertElementAt(4, "Clark");

    System.out.println(lowprio.toString());
    lowprio.moveToTop(3);
    System.out.println(lowprio.toString());

  }

}
// End unit test for PriorityList