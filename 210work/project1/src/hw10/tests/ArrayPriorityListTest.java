package hw10.tests;

/** 
 * Unit test for ArrayPriorityList.
 * 
 *@author YOUR NAME
*/ 

// Using
import static org.junit.Assert.*;  // Using JUnit 4
import org.junit.Test;

// We must import files when in a different package
import model.ArrayPriorityList;

public class ArrayPriorityListTest {
  
  @Test
  public void testToArrayReturnsACloneOfTheInstanceVariable() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 77);
    list.insertElementAt(1, 88);
    list.insertElementAt(2, 99);

    Object[] result = list.toArray();
    // Make sure the new array built in toArray has capacity == n
    assertEquals(3, result.length);
    // Make sure the elements and indexes match in the Object[]
    assertEquals(77, result[0]);
    assertEquals(88, result[1]);
    assertEquals(99, result[2]);

    // Make sure you did simply not return a reference to data
    // because a change to result should NOT affect data
    result[0] = 12345678;
    result[1] = Integer.MAX_VALUE;
    result[2] = Integer.MIN_VALUE;
    assertEquals(77, (int) list.getElementAt(0));
    assertEquals(88, (int) list.getElementAt(1));
    assertEquals(99, (int) list.getElementAt(2));
  }
  
  // Add many more @Tests
  
}
// End unit test for PriorityList