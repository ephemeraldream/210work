package proj2;

/*
 * The class begins with 15 method stubs specified in comments above each stub. 
 * The methods are related only by the fact that CSC 210 students are learning 
 * how to develop methods and the JUnit testing framework for Java. 
 * 
 * You will need to use Math functions and String methods.
 * 
 * You may want to use if and/or else if, but don't do it. You would lose points.
 * 
 * If you can't find a function or formula you think you need, Google it.
 *
 * You will need these Java's Boolean operators to write small to big logical expressions:
 *   and: &&  (two ampersands)
 *   or:  ||  (two pipe symbols)
 *   not: !   (exclamation point
 * 
 * Do not add any other methods to either file.
 * 
 * Programmers: Rick Mercer and Ivan Akinfiev
 */

import java.math.*;


public class JavaFun {

  /*
   * Given the base and height of a triangle, return the area of the triangle.
   * Assume positive input since negative lengths do not make sense.
   * 
   * triangleArea (5.0, 5.0) returns 12.5
   */
  public double triangleArea(double base, double height) {

    return base * height / 2;
  }

  /*
   * Complete range to determine the range of a projectile
   * where range is defined as
   * 
   * range = sin(2 * angle) * velocity * velocity / gravity
   * 
   * where angle is the angle of the projectile’s path in radians, 
   * velocity is the initial velocity of the projectile in meters 
   * per second, and gravity is acceleration at 9.8 meters per 
   * second (a constant). You will need Math.PI and 
   * Math.sin(double radians).
   * 
   * range(45.0, 100.0) returns 1020.4
   * 
   * An angle in degrees can be converted to radians by multiplying 
   * the number of degrees by π / 180. For example:
   * 
   * 45° is 45.0 * Math.PI / 180.0, which is 0.7853981633974483 radians.
   */
  public double range(double degrees, double velocity) {
    return Math.sin(2 * (Math.PI/180 * degrees)) * velocity * velocity/ 9.8;
  }

  /*
   * Return a floating point number round to n decimal places.
   * You will need Math.round and Math.pow.
   * 
   * round(3.4567, 0) returns 3
   * round(3.4567, 1) returns 3.5
   * round(3.4567, 2) returns 3.46
   * round(3.4567, 3) returns 3.457
   */
  public double round(double number, int decimals) {
    double precision = Math.pow(10, -decimals - 1);
    double newNumber = number + (precision * 5);
    String stringNumber = Double.toString(newNumber);
    stringNumber = stringNumber.substring(0, decimals + 2);
    return Double.parseDouble(stringNumber);
  }

  /*
   * Given a non-negative number "num", return true if num is
   * within 2 of a multiple of 10. Note: (a % b) is the remainder
   * of dividing a by b, so (7 % 5) is 2.
   * 
   * nearTen(12) returns true
   * nearTen(17) returns false
   * nearTen(19) returns true
   * 
   * Precondition: num >=0;
   */
  public boolean nearTen(int num) {
    return (num % 10 == 0) || ((num - 1) % 10 == 0) || ((num - 2) % 10 == 0) || ((num + 1) % 10 == 0) || ((num + 2) % 10 == 0);
  }

  /*
   * The number 6 is a truly great number. Given two int values,
   * a and b, return true if either one is 6. Or if their sum or
   * difference is 6.
   * 
   * likeSix(6, 4) returns true
   * likeSix(4, 5) returns false
   */
  public boolean likeSix(int a, int b) {
    return ((a == 6) || (b == 6)) || (a - b == 6) || (a + b) == 6;

  }

  /*
   * We have two monkeys, a and b, and the parameters aSmile
   * and bSmile indicate if each is smiling. We are in trouble
   * if they are both smiling or if neither of them is smiling.
   * Return true if we are in trouble.
   * 
   * monkies(true, true) returns true
   * monkies(false, false) returns true
   * monkies(true, false) returns false
   */
  public boolean monkies(boolean aSmile, boolean bSmile) {
    // TODO: Complete this method.
    return ((aSmile && bSmile) || (!aSmile && !bSmile));
  }

  /*
   * Everyone knows that interplanetary space travel systems
   * are fueled by letting matter and anti-matter mix. With
   * this in mind, code a method that will take a String with
   * the name of some thing or idea. Return a String with "Anti-"
   * prepended to it. This method will tell us what to mix with
   * that thing or idea so we can create a reaction to fuel
   * our ships! Don't forget the dash!
   * 
   * In short: Return the string matter references preceded by
   * the string "Anti-". This is case sensitive;
   * 
   * antiMatter("lol") returns Anti-lol
   */
  public String antiMatter(String matter) {
    // TODO: Complete this method.
    return "Anti-" + matter;
  }

  /*
   * Given two strings, a and b, return the result of putting
   * them together in the order abba
   * 
   * abba("Hi", "Bye") returns "HiByeByeHi"
   * abba("Yo", "Alice") returns "YoAliceAliceYo"
   */
  public String abba(String a, String b) {
    return a + b + b + a;
  }

  /*
   * Determine and return the middle two chars of the String argument.
   * PreconditionL arg.length() >= 2. Return the middle two characters of the
   * argument. With an odd number of characters, favor the left.
   * 
   * middleTwo("ab") returns "ab"
   * middleTwo("abc") returns "ab"
   */
  // Precondition: arg.length() >= 2
  public String middleTwo(String arg) {
    return arg.substring((arg.length()/2)-1, (arg.length()/2)+1);
  }

  /*
   * This method takes in a string of length 1 or greater, and returns a string
   * with a space added into the middle of the string. If the string's length is
   * an odd number, the second half of the string will be the longer half.
   * 
   * Precondition: str.length() >= 2
   * 
   * splitString ("Wildcat") returns "Wil dcat"
   * splitString ("ab") returns "a b"
   */
  public String splitString(String str) {
    // TODO: Complete this method.
    return str.substring(0, str.length()/2) + " " + str.substring(str.length()/2,str.length());

  }

  /*
   * Given a string, return a new string where the last 3 chars are
   * now in upper case. Note that str.toUpperCase() returns the
   * uppercase version of a string. You will also need String's
   * length and substring methods.
   * 
   * endCAP("Hello") returns "HeLLO"
   * endCAP("hi there") returns "hi thERE"
   * endCAP("hip") returns "HIP"
   * 
   * Precondition: str.length >=3
   */
  public String endCAP(String str) {

    return str.substring(0, str.length()-3) + str.substring(str.length()-3, str.length()).toUpperCase();
  }

  /*
   * The web is built with HTML elements like "<i>Yay</i>" which
   * draws Yay as italic text. In this example, the "i" tag makes
   * <i> and </i> which surround the text "Yay". Given HTML tags 
   * such as i, b, cite, strong ... and the text to surround, 
   * create the HTML with tags around the sentence. The begin
   * tag is <tag> and the end tag has a \ as in <\tag>
   * 
   * makeTags("i", "Yay") -> "<i>Yay</i>"
   * makeTags("strong", "Some text") -> "<strong>Some text</strong>"
   */
  public String makeTags(String tag, String text) {
    return "<" + tag + ">" +text + "</" + tag + ">";
  }

  /*
   * Aoccdrnig to a rscheearch at an Elingsh uinervtisy,
   * it deosn't mttaer in waht oredr the ltteers in a wrod are,
   * the olny iprmoetnt tihng is taht frist and lsat ltteer is
   * at the rghit pclae.
   * 
   * Create a method that will mix up the middle characters in a 5 letter word.
   * The precondition states the word must have exactly 5 letters. If the
   * argument is a different length, the method does not work.
   * 
   * Assuming the letters are indexed as 0-1-2-3-4, they should end up in the
   * order 0-2-3-1-4. Your method will accept a 5-character string as an
   * argument and return a 5-character string reordered as described.
   * 
   * inLat ("apple") returns "aplpe"
   * inLat ("gears") returns "gares"
   * inLat ("prior") returns "piorr"
   * inLat ("scone") returns "sonce"
   * 
   * Precondition str.length() == 5
   */
  public String inLat(String str) {
    return str.substring(0,1) + str.charAt(2) + str.charAt(3) + str.charAt(1) + str.charAt(4);
  }

  /*
   * We'll say that a number is "alone" if it is in the range 13..19 inclusive.
   * Given 2 int values, return true if one or the other is alone, but not both.
   * 
   * alone(13, 99) returns true
   * alone(21, 19) returns true
   * alone(13, 13) returns false
   */
  public boolean alone(int a, int b) {
    // Do not use any if statements
    //
    // Suggestion: Store aloneness as boolean local variables first. Boolean local
    // variables like this are a little rare, but here they work great.
    boolean c = a >= 12 && a <= 18;
    boolean d = b < 12 || b > 19;
    return a >= 13 && a <= 19 && (b < 13 || b > 19) || (a < 13 || a > 19) && b >= 13 && b <= 19;
  }

  /*
   * Complete method isLeapYear that returns true if the integer argument
   * represents a leap year. A leap year is a positive integer that is evenly
   * divisible by 4 except the last year of a century, which are those years
   * evenly divisible by 100. These must also be divisible by 400. 2000 was a leap
   * year however 2100 will not be even though 2100 is evenly divisible by 4.
   * 
   * isLeapYear(2008) returns true
   * isLeapYear(2009) returns false
   * isLeapYear(2000) returns true
   * isLeapYear(2100) returns false
   * 
   * Precondition: YEAR >= 1582
   */
  public boolean isLeapYear(int year) {
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
  }

}