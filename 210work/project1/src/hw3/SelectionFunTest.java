package hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * This unit test has at least one @Test method for each of the five methods 
 * in functions.java. However, they are incomplete, and do not represent 
 * 100% code coverage. This is meant to encourage you to think of other needed
 * test cases and add your own asserts. We will be running a unit test that
 * is much larger than this starter unit test.
 * 
 * Programmers: Rick Mercer and YOUR NAME
*/
public class SelectionFunTest {
 
  SelectionFun functions = new SelectionFun();
  
  @Test
  public void testSalary() {
    assertEquals(1500.0, functions.salary(9999.00));
    assertEquals((1500.0 + 1300 + 0.12), functions.salary(30001));
    assertEquals((1500.0), functions.salary(9000));
    assertEquals((1500.0 + 100), functions.salary(12000));
    assertEquals((1500.0 + 500 + 160), functions.salary(22000));
    assertEquals((1500.0 + 1300 + 240), functions.salary(32000));
  }

  @Test
  public void testFailedFirstofthree() {
    assertEquals("a", functions.firstOf3Strings("a", "b", "c"));
    assertEquals("Ma", functions.firstOf3Strings("Ma", "ma", "ma"));
    assertEquals("a", functions.firstOf3Strings("c", "b", "a"));
    assertEquals("a", functions.firstOf3Strings("b", "a", "c"));
    assertEquals("a", functions.firstOf3Strings("a", "a", "a"));
    assertEquals("o", functions.firstOf3Strings("o", "z", "z"));
    assertEquals("a", functions.firstOf3Strings("a", "a", "c"));
    assertEquals("b", functions.firstOf3Strings("b", "c", "b"));
    assertEquals("b", functions.firstOf3Strings("c", "b", "b"));


  }

  @Test
  public void testAnswerOrNot() {
    assertTrue(functions.answerOrNot(true, true, false));
    assertTrue(functions.answerOrNot(false, true, false));
    assertTrue(functions.answerOrNot(false, false, false));
    assertTrue(functions.answerOrNot(true, false, false));
    assertFalse(functions.answerOrNot(true, false, true));
    assertFalse(functions.answerOrNot(false, true, true));



  }
  
  @Test
  public void testFizzBuzz() {
    assertEquals("Fizz", functions.fizzBuzz("f"));
    assertEquals("FizzBuzz", functions.fizzBuzz("fb"));
    assertEquals("FizzBuzz", functions.fizzBuzz("fasdfgpoipoib"));
    assertEquals("Fizz", functions.fizzBuzz("fsdasdfas"));
    assertEquals("Buzz", functions.fizzBuzz("owiefjwoefijb"));
    assertEquals("River", functions.fizzBuzz("River"));

  }
 
  @Test
  public void testThanksDate() {
    assertEquals(25, functions.thanksDate(1));
    assertEquals(28, functions.thanksDate(5));
    assertEquals(24, functions.thanksDate(2));
    assertEquals(23, functions.thanksDate(3));
    assertEquals(26, functions.thanksDate(7));
    assertEquals(27, functions.thanksDate(6));
    assertEquals(22, functions.thanksDate(4));
    assertEquals(-1, functions.thanksDate(0));
    assertEquals(-1, functions.thanksDate(8));
    assertEquals(-1, functions.thanksDate(9));

  }

  @Test
  public void testValidDateWhenTheyAreAllValid() {
    assertTrue(functions.validDate("01/01/2018"));
    assertTrue(functions.validDate("03/15/2000"));
    assertTrue(functions.validDate("12/31/2018"));
    assertTrue(functions.validDate("02/29/2000"));
    assertTrue(functions.validDate("04/30/2018"));
    assertTrue(functions.validDate("09/30/2000"));
    assertTrue(functions.validDate("02/29/2008"));
    assertTrue(functions.validDate("10/31/2000"));

  }

  @Test
  public void testValidDateWhenTheyAreAllNotValid() {
    assertFalse(functions.validDate("01/32/2021"));
    assertFalse(functions.validDate("00/31/2021"));
    assertFalse(functions.validDate("13/04/2000"));
    assertFalse(functions.validDate("09/31/2021"));
    assertFalse(functions.validDate("04/31/2021"));
    assertFalse(functions.validDate("02/29/2001"));
    assertFalse(functions.validDate("17/03/2002"));
    assertFalse(functions.validDate("02/29/2001"));

  }

  @Test
  public void testValidDateWhenOnLeapYears() {
    assertTrue(functions.validDate("01/01/2000"));
    assertTrue(functions.validDate("02/29/2000"));
    assertTrue(functions.validDate("02/28/2004"));
    assertTrue(functions.validDate("02/29/2008"));

  }
}