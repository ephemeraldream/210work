/*
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
 * Programmers: Rick Mercer and YOUR NAME
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
    assertEquals(12.5, functions.triangleArea(5.0, 5.0));
    // TODO: Add more assertions.
  }

  @Test
  public void testRange() {
    assertEquals(883.69, functions.range(30.0, 100.0));
    // TODO: Add more assertions.
  }

  @Test
  public void testRound() {
    assertEquals(3.46, functions.round(3.4567, 2));
    // TODO: Add more assertions.
  }

  @Test
  public void testMiddleTwo() {
    assertEquals("ab", functions.middleTwo("abc"));
    // TODO: Add more assertions.
   }

  // To Run all tests, select Run > Run As > JUnit Test (or Run > Run)
  @Test
  public void testAntimatter() {
    assertEquals("Anti-Shoes", functions.antiMatter("Shoes"));
    // TODO: Add more assertions.
  }

  @Test
  // To Run all tests, select Run > Run
  public void testAbba() {
    assertEquals("abba", functions.abba("a", "b"));
    // TODO: Add more assertions.
  }

  @Test
  public void testNearTen() {
    assertTrue(functions.nearTen(8));
    // TODO: Add more assertions.
  }

  @Test
  public void testLikeSix() {
    assertTrue(functions.likeSix(6, 4));
    // TODO: Add more assertions.
  }

  @Test
  public void testEndUp() {
    assertEquals("TRE", functions.endCAP("tre"));
    // TODO: Add more assertions.
  }

  @Test
  public void testMakeTags() {
    assertEquals("<i>Yay</i>", functions.makeTags("i", "Yay"));
    // TODO: Add more assertions.
  }

  @Test
  public void testSplitstring() {
    assertEquals("Wil dcat", functions.splitString("Wildcat"));
    assertEquals("Wil dca", functions.splitString("Wildca"));
    // TODO: Add more assertions.
  }

  @Test
  public void testFailedInlat() {
    assertEquals("gares", functions.inLat("gears"));
    // TODO: Add more assertions.
  }

  @Test
  public void testMonkies() {
    assertTrue(functions.monkies(true, true));
    // TODO: Add more assertions.

  }

  @Test
  public void alone() {
    assertTrue(functions.alone(13, 99));
    // TODO: Add more assertions.

  }

  @Test
  public void testFIsLeapYear() {
    assertTrue(functions.isLeapYear(1600));
    // TODO: Add more assertions.

  }
}