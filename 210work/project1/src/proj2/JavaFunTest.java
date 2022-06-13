package proj2;/*
 * This class is the beginning of a UnitTest for the 15 methods
 * specified in functions.java.
 *   
 * Although each @Test has one assertion, you will need
 * to add more assertions to be sure your methods work. 
 * FYI: Our grading unit test has the same 15 @Test methods 
 * but also about 80 assertions (assertTrue, assertFalse, assertEquals).
 * 
 * Remember that when comparing two doubles, you must supply
 * a 3rd argument as the error factor. 1e-12 works well most of 
 * the time, except for range below where we use 0.01 to be close.
 * 
 * Programmers: Rick Mercer and Ivan Akinfiev
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JavaFunTest {
  
  // Construct an object to send 15 different messages to in the @Test methods below
  JavaFun functions = new JavaFun();
  
  // Recommended: Run one @Test method at a time as you work on only
  // one method at a time.
  //
  //   1. Highlight the method name, testTriangleArea() is the first one below
  //   2. From the top menu, select: Run > Run
  //
  // You can also run all @Test methods by focusing on the file, not
  // on one @Test name before selecting Run > Run from the main menu.
  //
    
  @Test
  public void testTriangleArea() {
    assertEquals(12.5, functions.triangleArea(5.0, 5.0), 1e-12);
    assertTrue(functions.triangleArea(0,0) >= 0);
    assertEquals(0, functions.triangleArea(10, 0), 1e-12);
  }

  @Test
  public void testRange() {
    assertEquals(883.69, functions.range(30.0, 100.0),0.01);
    assertEquals(1020.4, functions.range(45.0, 100.0), 0.01);
  }

  @Test
  public void testRound() {
    assertEquals(3.46, functions.round(3.4567, 2), 1e-12);
    assertEquals(1.3457, functions.round(1.3456789, 4), 1e-12);
    assertEquals(0, functions.round(0, 0), 1e-12);
  }

  @Test
  public void testMiddleTwo() {
    assertEquals("ab", functions.middleTwo("abc"));
    assertEquals("ab", functions.middleTwo("ab"));
    assertEquals("bc", functions.middleTwo("abcd"));
    assertEquals("bc", functions.middleTwo("abcdf"));
    assertEquals("34", functions.middleTwo("1234567"));
   }

  // To Run all tests, select Run > Run As > JUnit Test (or Run > Run)
  @Test
  public void testAntimatter() {
    assertEquals("Anti-Shoes", functions.antiMatter("Shoes"));
    assertEquals("Anti-bottle", functions.antiMatter("bottle"));
    assertEquals("Anti-TV", functions.antiMatter("TV"));
    assertEquals("Anti-vegetable", functions.antiMatter("vegetable"));

  }

  @Test
  // To Run all tests, select Run > Run
  public void testAbba() {
    assertEquals("abba", functions.abba("a", "b"));
    assertEquals("JohnWeekWeekJohn", functions.abba("John", "Week"));
    assertEquals("dogcatcatdog", functions.abba("dog", "cat"));

  }

  @Test
  public void testNearTen() {
    assertTrue(functions.nearTen(8));
    assertTrue(functions.nearTen(10));
    assertTrue(functions.nearTen(21));
    assertFalse(functions.nearTen(34));
    assertTrue(functions.nearTen(2));
    assertFalse(functions.nearTen(27));
    assertFalse(functions.nearTen(3));
    assertFalse(functions.nearTen(55));
  }

  @Test
  public void testLikeSix() {
    assertTrue(functions.likeSix(6, 4));
    assertTrue(functions.likeSix(13,7));
    assertTrue(functions.likeSix(12,6));
    assertFalse(functions.likeSix(5,4));
  }


  @Test
  public void testEndUp() {
    assertEquals("TRE", functions.endCAP("tre"));
    assertEquals("qwertyIOP", functions.endCAP("qwertyiop"));
    assertEquals("drONE", functions.endCAP("drone"));
    assertEquals("12345", functions.endCAP("12345"));
    assertEquals("d1r   ", functions.endCAP("d1r   "));
  }

  @Test
  public void testMakeTags() {
    assertEquals("<i>Yay</i>", functions.makeTags("i", "Yay"));
    assertEquals("<br></br>", functions.makeTags("br", ""));
    assertEquals("<p>Hi, I am Ivan</p>", functions.makeTags("p", "Hi, I am Ivan"));
  }

  @Test
  public void testSplitstring() {
    assertEquals("Wil dcat", functions.splitString("Wildcat"));
    assertEquals("Wil dca", functions.splitString("Wildca"));
    assertEquals("Ilike mydog", functions.splitString("Ilikemydog"));
    assertEquals("s df", functions.splitString("sdf"));
    assertEquals("a b", functions.splitString("ab"));
    assertEquals("12 34", functions.splitString("1234"));

  }

  @Test
  public void testFailedInlat() {
    assertEquals("gares", functions.inLat("gears"));
    assertEquals("srehk", functions.inLat("shrek"));
    assertEquals("crdas", functions.inLat("cards"));
    assertEquals("piorr", functions.inLat("prior"));
  }

  @Test
  public void testMonkies() {
    assertTrue(functions.monkies(true, true));
    assertFalse(functions.monkies(true, false));
    assertFalse(functions.monkies(false, true));
    assertTrue(functions.monkies(false, false));

  }

  @Test
  public void alone() {
    assertTrue(functions.alone(13, 99));
    assertFalse(functions.alone(15,14));
    assertTrue((functions.alone(99,14)));
    assertTrue(functions.alone(0, 14));
    assertFalse(functions.alone(13,19));
    assertTrue(functions.alone(15, 2));
    assertFalse(functions.alone(0, 0));
    assertFalse(functions.alone(99, 0));
    assertFalse(functions.alone(0, 99));

  }

  @Test
  public void testFIsLeapYear() {
    assertTrue(functions.isLeapYear(1600));
    assertTrue(functions.isLeapYear(2008));
    assertFalse(functions.isLeapYear(2200));
    assertFalse(functions.isLeapYear(2009));
    assertTrue(functions.isLeapYear(2000));
  }
}