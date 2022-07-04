package hw9;
/**
 * A unit test for ArrayStringSet
 * 
 * @author Rick Mercer
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class ArrayStringSetTest {

  @Test
  public void testGettersWhenEmpty() {
    ArrayStringSet set = new ArrayStringSet(10);
    assertEquals(0, set.size());
  }

  @Test
  public void testSizeAndAdd() {
    ArrayStringSet names = new ArrayStringSet(12);
    assertEquals(0, names.size());
    assertTrue(names.add("A"));
    assertEquals(1, names.size());
    assertTrue(names.add("B"));
    assertEquals(2, names.size());
    assertTrue(names.add("C"));
    assertEquals(3, names.size());
  }

  @Test
  public void testContainsWhenElementsAreNotAlreadyContained() {
    ArrayStringSet names = new ArrayStringSet(15);
    assertTrue(names.add("A"));
    assertTrue(names.add("B"));
    assertTrue(names.add("C"));
    assertTrue(names.contains("A"));
    assertTrue(names.contains("B"));
    assertTrue(names.contains("C"));
    assertFalse(names.contains("Not here"));
  }

  @Test
  public void testContainsWhenElementsAreNotAlreadyContained2() {
    ArrayStringSet strings = new ArrayStringSet(10);
    assertTrue(strings.add("5"));
    assertTrue(strings.add("2"));
    assertTrue(strings.add("4"));
    assertTrue(strings.add("1"));
    assertTrue(strings.contains("1"));
    assertTrue(strings.contains("2"));
    assertFalse(strings.contains("3"));
    assertTrue(strings.contains("4"));
    assertTrue(strings.contains("5"));
  }

  @Test
  public void testContainsWhenElementsExist() {
    ArrayStringSet names = new ArrayStringSet(10);
    assertFalse(names.contains("A"));
    assertTrue(names.add("A"));
    assertTrue(names.contains("A"));
    assertTrue(names.add("B"));
    assertTrue(names.add("C"));
    assertEquals(3, names.size());
    assertFalse(names.add("A"));
    assertFalse(names.add("B"));
    assertFalse(names.add("C"));
    assertEquals(3, names.size());
    assertTrue(names.contains("A"));
    assertTrue(names.contains("B"));
    assertTrue(names.contains("C"));
    assertFalse(names.contains("Not here"));
  }

  @Test
  public void testLargeSet() {
    ArrayStringSet strings = new ArrayStringSet(1000);
    for (int i = 1; i <= 3000; i++) {
      strings.add("" + i);
    }

    assertTrue(strings.contains("1"));
    assertTrue(strings.contains("2"));
    assertTrue(strings.contains("2000"));
    assertTrue(strings.contains("2999"));
    assertTrue(strings.contains("3000"));
    assertFalse(strings.contains("3001"));
  }

  @Test
  public void testUnion() {
    ArrayStringSet a = new ArrayStringSet(10);
    a.add("one");
    a.add("two");
    ArrayStringSet b = new ArrayStringSet(10);
    b.add("one");
    b.add("two");
    b.add("three");

    ArrayStringSet c = a.union(b);
    assertEquals(3, c.size());
    assertTrue(c.contains("one"));
    assertTrue(c.contains("two"));
    assertTrue(c.contains("three"));
  }

  @Test
  public void testIntersection() {
    ArrayStringSet a = new ArrayStringSet(10);
    a.add("one");
    a.add("two");
    a.add("four");
    ArrayStringSet b = new ArrayStringSet(10);
    b.add("one");
    b.add("two");
    b.add("three");
    b.add("five");

    ArrayStringSet c = a.intersection(b);
    assertEquals(2, c.size());
    assertTrue(c.contains("one"));
    assertTrue(c.contains("two"));
    assertFalse(c.contains("three"));
    assertFalse(c.contains("four"));
    assertFalse(c.contains("five"));
  }

  @Test
  public void testIterator() {
    ArrayStringSet a = new ArrayStringSet(10);
    a.add("one");
    a.add("two");
    a.add("three");
    a.add("four");

    @SuppressWarnings("rawtypes")
    Iterator itr = a.iterator();
    while (itr.hasNext()) {
      // Need to cast itr.next with (String)
      assertTrue(a.contains((String) itr.next()));
    }
  }

}
