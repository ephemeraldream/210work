package hw3;

/**
 * A class with six methods related by the fact that CSC 210 students are
 * learning selection control structures, the algorithmic patterns Guarded
 * Selection and Alternative Selection, and the if and if..else statements
 * written is virtually all languages because these algorithmic patterns
 * occur so frequently while developing software.
 * 
 * @author Rick Mercer and Ivan Akinfiev
 */
public class SelectionFun {

  // Complete the function salary that returns a salesperson’s salary
  // for the month according to the following policy:
  //
  // Sales . . But
  // .Over . . Not Over . . Monthly Salary
  // ======= . ======== . . ==============
  // 0 . . . . 10,000 . . . Base salary
  // 10,000 .. 20,000 . . . Base salary plus 5% of sales over 10,000
  // 20,000 .. 30,000 . . . Base salary plus 500.00 plus 8% of sales over 20,000
  // 30,000 .. . . . . . .. Base salary plus 1300.00 plus 12% of sales over 30,000
  //
  // The base salary is $1,500.00, which means salary returns a value that
  // is never less than 1500.00. When sales are over $10,000, commission is
  // added to the base salary. For example, when sales equals 10001, the
  // monthly salary is $1,500.00 + 5% of $1.00 for a total of $1,500.05,
  // and when sales is 20001, the monthly salary is $1,500.00 + $500.00 + 8%
  // of $1.00 for a total of $2,000.08.
  ///
  public double salary(double sales) {
    if (sales <= 10000)
      return 1500;
    if (sales > 10000 && sales <= 20000)
      return 1500 + ((sales - 10000) * 0.05);
    if (sales > 20000 && sales <= 30000)
      return 1500 + ((sales - 20000) * 0.08) + 500;
    else
      return 1500 + ((sales - 30000) * 0.12) + 1300;
  }

  
  // Given three String arguments, return the String that alphabetically precedes
  // or is equal to the other two string arguments
  //
  // firstOf3Strings("a", "b", "c") returns "a"
  // firstOf3Strings("b", "c", "X") returns "X"
  // firstOf3Strings("123", "1232", "123 0") returns "123"
  //
  public String firstOf3Strings(String a, String b, String c) {
    if (a.compareTo(b) == 0 && b.compareTo(c) == 0)
      return a;
    if ((a.compareTo(b) == 0 && a.compareTo(c) < 0))
      return a;
    if ((a.compareTo(c) == 0 && a.compareTo(b) < 0))
      return c;
    if (b.compareTo(c) ==0 && b.compareTo(a) < 0)
      return b;
    if ((a.compareTo(b) < 0 && a.compareTo(c) < 0) || (a.compareTo(b) < 0 && b.compareTo(c) == 0))
      return a;
    if ((b.compareTo(c) < 0 && b.compareTo(a) < 0) || (b.compareTo(a) < 0 && a.compareTo(c) == 0))
      return b;
    else
      return c;

  }

  
  // Your cell phone rings. Return true if you should answer it. Normally you
  // answer, except in the morning you only answer if it is your mom calling. In
  // all cases, if you are asleep, you do not answer.
  //
  // answerCell(false, false, false) returns true 
  // answerCell(false, false, true) returns false 
  // answerCell(true, false, false) returns false
  //
  public boolean answerOrNot(boolean isMorning, boolean isMom, boolean isAsleep) {
    if (!isAsleep &&!isMom && !isMorning)
      return true;
    if (isMorning && isMom && !isAsleep)
      return true;
    if (isAsleep)
      return false;
    else
      return true;


  }

  // Given a string str, if the string starts with "f" return "Fizz". If the
  // string ends with "b" return "Buzz". If both the "f" and "b" conditions are
  // true, return "FizzBuzz". In all other cases, return the string unchanged.
  // This is case sensitive.
  //
  // fizzString("fig") returns "Fizz"
  // fizzString("dib") returns "Buzz"
  // fizzString("fib") returns "FizzBuzz"
  // fizzString("FiB") returns "FiB" return the argument, "F" is not "f" and "B" is not "b"
  // fizzString("fiB") returns "Fizz", "B" is not "b"
  //
  public String fizzBuzz(String str) {
    if ((str.charAt(0) == 'f') && str.charAt(str.length()-1) == 'b')
      return "FizzBuzz";
    if(str.charAt(0) == 'f')
      return "Fizz";
    if(str.charAt(str.length()-1) == 'b')
      return "Buzz";
    else return str;





  }

  
  // In the U.S. Thanksgiving falls on the fourth Thursday of each November.
  // Complete method thanksDate that determines the day of the month upon
  // which Thanksgiving falls, no matter which day November begins on.
  // November can begin on any day where 0 represents Monday, through 7,
  // which represents Sunday. A valid call would be thanksDate(1) to indicate
  // the first day of November is Tuesday. thanksDate should then return
  // the day of the month upon which Thanksgiving falls, which would be 24.
  // Arguments can only be 1 for Monday through 7 for Sunday. If the
  // argument is out of the range of 1 through 7, return -1.
  //
  // thanksDate(2) returns 24 when 1-Nov is Tue
  // thanksDate(5) returns 28 when 1-Nov is Fri
  // thanksDate(7) returns 26 when 1-Nov is Sun
  //
  public int thanksDate(int d) {
    if (d == 1)
      return 25;
    if (d == 3)
      return 23;
    if (d == 2)
      return 24;
    if (d == 5)
      return 28;
    if (d == 7)
      return 26;
    if (d == 6)
      return 27;
    if (d == 4)
      return 22;
    else return -1;

  }

  // Write method validDate to return true if the string argument is
  // a valid calendar date. The arguments always take the form of month, day,
  // and year as positive integers separated by / as in "mm/dd/yyyy".
  //
  // You will need the method Integer.parseInt(String possibleInt) that
  // returns the integer value of the string argument with the precondition
  // that the string argument is a valid integer. For example
  // Integer.parseInt("08") returns 8 and Integer.parseInt("2021") returns 2021.
  //
  // validDate("01/31/2016") returns true
  // validDate("12/31/2017") returns true
  // validDate("06/15/2018") returns true
  // validDate("02/29/2019") returns false
  // validDate("02/29/2100") returns false
  // 
  // This saying might help:
  //
  // 30 days hath September, April, June, and November.
  // All the rest have 31, except February that has 28 
  // unless it is a leap year when it has 29 days.
  //
  public boolean validDate(String date) {
    int year = Integer.parseInt(date.substring(6),10);
    int day = Integer.parseInt(date.substring(3,5));
    int month = Integer.parseInt(date.substring(0,2));
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
      if (month < 1 || month > 12)
        return false;
      if (month == 2)
        return day >= 1 && day <= 29;
      if (month == 9 || month == 4 || month == 6 || month == 11)
        return day >= 1 && day <= 30;
      else return day >= 1 && day <= 31;
    }
    else {
      if (month < 1 || month > 12)
        return false;
      if (month == 2)
        return day >= 1 && day <= 28;
      if (month == 9 || month == 4 || month == 6 || month == 11)
        return day >= 1 && day <= 30;
      else return day >= 1 && day <= 31;

    }








  }
}