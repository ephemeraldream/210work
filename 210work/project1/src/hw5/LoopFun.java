
/**
 * This class has methods related by the fact that CSC 210 students
 * are learning the algorithmic patterns Determinate Loop and
 * Indeterminate Loop and Java's for and while statements.
 * I have implemented 10 functions using for and while loops.
 * @author Rick Mercer and Ivan Akinfiev
 */
import java.util.Scanner;

public class LoopFun {

	// In mathematics, the greatest common divisor (GCD) of two or more
	// integers, which are not all zero, is the largest positive integer
	// that divides each of the integers. For example, GCD(4, 12) is 4.
	//
	// Euclid's solution to finding the GCD is refuted to be the first
	// algorithm known to mankind. It is definitely old.
	//
	// GCD(a, b) can be computed as follows:
	//
	// while(b != 0):
	// . . other = a
	// . . a = b
	// . . b = other % b
	// a is the GCD
	//
	// GCD(378, 378) returns 378
	// GCD(378, 0) returns 378
	// GCD(0, 378) returns 378
	// GCD(3, 2) returns 1
	// GCD(10, 5) returns 5
	// GCD(-25, 10) returns 5 Use Math.abs on both parameters
	// GCD(-25, -10) returns 5
	// GCD(25, -10) returns 5
	//
	// Either or both arguments may be < 0
	//
	// Precondition: a and or b can be 0, but not both. GCD(0, 0) is undefined.
	// We will not have an assertion for GCD(0,0).
	public int GCD(int a, int b) {
		int x = Math.abs(a);
		int y = Math.abs(b);
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		int min = Math.min(x, y);
		for (min = min; min > 1; min--) {
			if (x % min == 0 && y % min == 0) {
				return min;
			}

		}

		return 1;
	}

	// Given an integer argument return n factorial, which is written as n!.
	// 5! = 5*4*3*2*1 or in general, n! = n*(n-1)*(n-2) …*2*1. Use a for loop.
	//
	// factorial(0) returns 1 by definition
	// factorial(1) returns 1
	// factorial(4) returns 24, which is 4 * 3 * 2 * 1
	// factorial(19) returns 121645100408832000
	//
	// Precondition: n is in the range of 0..19 inclusive (20 causes an arithmetic
	// overflow)
	public long factorial(int n) {
		int result = 1;
		if (n == 0)
			return 1;
		else
			// if (n == 1) return 1; Far more beautiful
			// else return n * factorial(n -1);
			for (int i = n; i > 1; i--) {
				result *= i;
			}
		return result;
	}

	// The square root of a number >= 0 can be found by making successful
	// guesses until it is "close enough". Starting with a guess, make each
	// guess like this until the sqrt(x) is within the precision specified.
	// This is an example known as the Newton-Raphson method.
	//
	// n = 0
	// guess[n] = x / 2 // A good first guess is to divide x by 2.0
	// guess[n+1] = (guess[n] + x / guess[n] ) / 2.0
	// guess[n+2] = (guess[n+1] + x / guess[n+1] ) / 2.0
	//
	// If x = 16.0
	// guess[0] = 16.0 / 2; == 8.0
	// guess[1] = (8.0 + 16.0 / 8.0) / 2.0 == 5.0
	// guess[2] = (5.0 + 16.0 / 5.0) / 2.0 == 4.1
	//
	// If you use Math.sqrt, you will get 0 / 10 for this method.
	//
	// Precondition x >= 0.0 and 1e-06 <= precision <= 1e-12
	public double sqrt(double x, double precision) {
		double newX = x / 2;
		while (true) {
			double checker = newX;
			newX = (newX + (x / newX)) / 2;
			if (Math.abs(newX - checker) < precision) {
				break;
			}

		}
		return newX;
	}

	// One evening, while listening intently at the Very Large Array (VLA)
	// radio astronomy observatory 50 miles west of Socorro New Mexico, Ellie
	// hears a powerful signal: a prime number pattern emanating from the
	// star Vega, confirmed by others the world over, undeniable and strong
	// in its pulsing power. What Ellie recognized was the repeating series
	// of the first 26 prime numbers. This is someone near Vega trying to
	// contact anyone on earth who is listening:
	//
	// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
	//
	// A prime number is a natural number greater than 1 that has no positive
	// divisors other than 1 and itself. Complete method isPrime that returns
	// true if the argument is a prime number. Hint: Consider writing a loop
	// that divides the argument num by every integer from 2 to num-1, returning
	// false if num was found to be evenly divisible by any one of those.
	//
	// Precondition: num >= 2
	public boolean isPrime(int num) {
		for (int i = num - 1; i >= 2; i--) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// Given a Scanner constructed with a String containing valid
	// white space separated integers, return the range. Range is
	// the maximum integer – minimum integer.
	//
	// Scanner scanner = new Scanner("2 5 8 7");
	// rangeInScanner(scanner) returns 6, which is 8 - 2
	//
	// Scanner scanner = new Scanner("2 2 2");
	// rangeInScanner(scanner) returns 0, which is 2 - 2
	//
	// Scanner scanner = new Scanner("2 5 -7 8");
	// rangeInScanner(scanner) returns 15, which is 8 - -7 or 15
	//
	// Precondition: scanner has a string argument that has one or
	// more white-space separated integers, all of which are valid.
	public int rangeInScanner(Scanner scanner) {
		int start = scanner.nextInt();
		int min = start;
		int max = start;
		while (scanner.hasNextInt()) {
			int next = scanner.nextInt();
			if (next < min)
				min = next;
			if (next > max)
				max = next;
		}
		return max - min;
	}

	// ABBA is a band, they have many songs including Dancing Queen, and
	// Fernando. ABBA is actually a Swedish band, so if we wanted to find
	// out howSwedish a String is, we could simply find out how many times
	// the String contains the substring "abba". We want to look for this
	// substring in a case insensitive manner. So "abba" counts, and so
	// does "aBbA". We also want to check for overlapping abba's such as
	// in the String "abbAbba" that contains "abba" twice.
	//
	// howSwedish("ABBA a b b a") returns 1
	// howSwedish("ab!abbabba!ba") returns 2
	//
	public int howSwedish(String str) {
		str = str.toLowerCase();
		int count = 0;
		if (str.length() < 4)
			return 0;
		for (int i = 4; i <= str.length(); i++) {
			String m = str.substring(i - 4, i);
			if (str.substring(i - 4, i).equals("abba"))
				count += 1;

		}
		return count;
	}

	// Given a Scanner constructed with a String containing white
	// space separated words, return the number of "words" found
	// in the input stream that .equals the 2nd parameter search.
	//
	// Scanner scanner = new Scanner("here are five words here");
	// howMany(scanner, "here") returns 2
	// howMany(scanner, "not") returns 0
	//
	// scanner = new Scanner("a b b a b b a");
	// howMany(scanner, "a") returns 3
	// howMany(scanner, "b") returns 4
	//
	//
	public int howMany(Scanner scanner, String search) {
		int count = 0;
		while (scanner.hasNext()) {
			String nextString = scanner.next();
			if (nextString.equals(search)) {
				count++;
			}
		}
		return count;

	}

	// Given a Scanner containing an unknown number of quiz scores,
	// return the percentage of 100s in the Scanner. If the Scanner
	// has these quiz scores where there are 4 100s out of 16 total,
	//
	// new Scanner ("80 90 100 72 65 49 90 88 90 100 90 100 100 74 93 99")
	// perfectPercentage must return 4.0 / 16.0 or 0.25 meaning 25%.
	// Remember: 4 / 16 == 0 so you need to use a double somewhere, or * 1.0.
	//
	// Precondition: scanner has a string argument that has one or
	// more white-space separated integers, all of which are valid.
	public double perfectPercentage(Scanner scanner) {
		int total = 0;
		double count = 0;
		double percentage;
		while (scanner.hasNextInt()) {
			int next = scanner.nextInt();
			if (next == 100) {
				count = count + 1;
			}
			total++;
		}
		percentage = count / total;
		return percentage;
	}

	// Return the number of times two consecutive characters occur in str.
	// This method is caseSensitive.
	//
	// numberOfPairs ("") returns 0
	// numberOfPairs ("1") returns 0
	// numberOfPairs ("abc") returns 0
	// numberOfPairs ("aabbcc") returns 3
	// numberOfPairs ("!!!") returns 2
	// numberOfPairs ("mmmm") returns 3
	// numberOfPairs ("mmOmm") returns 2
	// numberOfPairs ("aAbB") returns 0 // 'b' is not equal to 'B'
	//
	public int numberOfPairs(String str) {
		if (str.length() < 2)
			return 0;
		int count = 0;
		for (int i = 0; i <= str.length() - 2; i++) {
			char x = str.charAt(i);
			char y = str.charAt(i + 1);
			if (str.charAt(i) == str.charAt(i + 1))
				count += 1;
		}

		return count;
	}

	// Given a string, look for the same characters (backwards) at both the
	// beginning and
	// end of the string argument. In other words, zero or more characters at the
	// very
	// beginning of the given string, and at the very end of the string in reverse
	// order
	// (possibly overlapping). For example, the string "abXYZba" has the mirror end
	// "ab".
	//
	// echo("abXYZba") returns "ab"
	// echo("abcdef") returns ""
	// echo("abca") returns "a"
	// echo("aba") returns "aba"
	// echo("123321") returns "123321"
	//
	public String echo(String str) {
		boolean isEven;
		int len = str.length();

		String stringLeft = "";
		String stringRight = "";
		isEven = str.length() % 2 == 0;
		if (isEven) {
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					return stringLeft;
				} else {
					stringLeft = stringLeft + str.charAt(i);
					stringRight = str.charAt(str.length() - i - 1) + stringRight;
				}
			}
		} else {
			int counter = 0;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					if (counter == str.length() / 2) {
						return stringLeft + str.charAt(str.length() / 2 + 1) + stringRight;
					} else
						return stringLeft;
				} else {
					stringLeft = stringLeft + str.charAt(i);
					stringRight = str.charAt(str.length() - i - 1) + stringRight;
					counter++;
				}
			}
			return stringLeft + str.charAt(str.length() / 2) + stringRight;
		}
		return stringLeft + stringRight;
	}

}