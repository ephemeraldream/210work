package hw9;
/**
 * A unit test for LinkedStringSet.
 * 
 * Programmers: Rick Mercer and YOUR NAME
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class LinkedStringSetTest {

  @Test
  public void testGettersWhenEmpty() {
    LinkedStringSet set = new LinkedStringSet();
    assertEquals(0, set.size());
    assertTrue(set.isEmpty());
  }

  @Test
  public void testSizeAndAdd() {
    LinkedStringSet names = new LinkedStringSet();
    assertEquals(0, names.size());
    assertTrue(names.add("A"));
    assertEquals(1, names.size());
    assertTrue(names.add("B"));
    assertEquals(2, names.size());
    assertTrue(names.add("C"));
    assertEquals(3, names.size());

  }
  @Test
  public void testUnion(){
    LinkedStringSet a = new LinkedStringSet();
    a.add("one");
    a.add("two");
    a.add("three");
    a.add("four");
    LinkedStringSet b = new LinkedStringSet();
    b.add("1");
    b.add("2");
    b.add("three");
    b.add("four");
    System.out.println(a.toString());
    System.out.println(b.toString());
    LinkedStringSet fin = a.union(b);
    System.out.println(fin.toString());
    assertTrue(b.contains("1"));
    assertTrue(fin.contains("2"));
    assertTrue(fin.contains("1"));
    assertTrue(fin.contains("four"));
    assertFalse(fin.contains("0"));
    assertTrue(fin.contains("three"));
    assertTrue(fin.contains("one"));
    assertTrue(fin.contains("2"));
  }
  
  // Add more @Test methods.

  @Test
  public void testIterator() {
    LinkedStringSet a = new LinkedStringSet();
    a.add("one");
    a.add("two");
    a.add("three");
    a.add("four");
    a.add("666");
    assertTrue(a.contains("three"));
    assertTrue(a.contains("four"));
    assertTrue(a.contains("666"));

    @SuppressWarnings("rawtypes")
    Iterator itr = a.iterator();
    while (itr.hasNext()) {
      // Need to cast itr.next() with (String).  With generics later we won't
      assertTrue(a.contains((String) itr.next()));
    }
  }

  @Test
  public void testIntersection(){
    LinkedStringSet a = new LinkedStringSet();
    a.add("1");
    a.add("two");
    a.add("three");
    a.add("four");
    LinkedStringSet b = new LinkedStringSet();
    b.add("1");
    b.add("2");
    b.add("two");
    b.add("one");
    System.out.println(a.toString());
    System.out.println(b.toString());
    LinkedStringSet fin = a.intersection(b);
    System.out.println(fin.toString());
    assertTrue(b.contains("1"));
    assertTrue(fin.contains("2"));
    assertTrue(fin.contains("1"));
    assertTrue(fin.contains("four"));
    assertFalse(fin.contains("0"));
    assertTrue(fin.contains("three"));
    assertTrue(fin.contains("one"));
    assertTrue(fin.contains("2"));

  }



}