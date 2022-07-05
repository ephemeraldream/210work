package hw10.tests;

/** 
 * Unit test for LinkedPriorityList.
 * 
 *@author Rick Mercer
*/

// Using JUnit 4
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.LinkedPriorityList;

public class LinkedPriorityListTest {
    
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

  @Test(expected = IllegalArgumentException.class)
  public void testDidNotThrowExceptionDuringMoveToLastWithArgumentEqualToSize() {
    LinkedPriorityList<String> list = new LinkedPriorityList<String>();
    list.insertElementAt(0, "1st");
    list.insertElementAt(0, "2nd");
    list.insertElementAt(0, "3rd");
    assertEquals("3rd", list.getElementAt(0));
    list.moveToLast(3);
  }
  
  // Add many more @Tests

}
// End unit test for PriorityList