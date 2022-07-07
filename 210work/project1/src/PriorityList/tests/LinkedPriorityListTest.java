package PriorityList.tests;

/** 
 * Unit test for LinkedPriorityList.
 * 
 *@author Ivan Akinfiev
*/

// Using JUnit 4
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PriorityList.model.LinkedPriorityList;

public class LinkedPriorityListTest {

  @Test
  public void testSizeAndEmpty(){
      LinkedPriorityList<String> lsit = new LinkedPriorityList<String>();
      lsit.insertElementAt(0, "123");
      lsit.insertElementAt(1, "123");
      assertEquals(2, lsit.size());
      assertFalse(lsit.isEmpty());

  }
  @Test void testMoveToLast(){
      LinkedPriorityList<String> list = new LinkedPriorityList<>();
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
      LinkedPriorityList<String> list = new LinkedPriorityList<>();
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
     LinkedPriorityList<String> list = new LinkedPriorityList<>();
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
    LinkedPriorityList<String> list = new LinkedPriorityList<String>();
    list.insertElementAt(0, "1st");
    list.insertElementAt(0, "2nd");
    list.insertElementAt(0, "3rd");
    assertEquals("3rd", list.getElementAt(0));
    list.moveToLast(3);
  }
  
  // Add many more @Tests
  @Test
  public void testInsert(){
      LinkedPriorityList<String> list = new LinkedPriorityList<String>();
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
     LinkedPriorityList<String> list = new LinkedPriorityList<String>();
     list.insertElementAt(0, "BOB");
     list.insertElementAt(1, "Alice");
     list.insertElementAt(2, "Mark");
     assertEquals("BOB",list.getElementAt(0));
     assertEquals("Alice", list.getElementAt(1));
      assertSame("Alice", list.getElementAt(1));


  }
  @Test
    public void testRemoveAtIndex(){
      LinkedPriorityList<String> list = new LinkedPriorityList<String>();
      list.insertElementAt(0, "BOB");
      list.insertElementAt(1, "Alice");
      list.insertElementAt(2, "Mark");
      list.removeElementAt(0);
      assertEquals("Alice", list.getElementAt(0));
      assertEquals("Mark", list.getElementAt(1));
    }
  @Test
    public void testLowerPriority(){
      LinkedPriorityList<String> lowprio = new LinkedPriorityList<String>();
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