package hw6;
import java.util.Scanner;


/**
 * This class has 10 methods related by the fact that CSC 210 students are
 * learning the Java array object. You will have to write your own @Test methods
 * with as many assertions as needed to ensure your methods are correct.
 *
 * @author Rick Mercer and Ivan Akinfiev
 *
 *
 *
 */
public class ArrayFun {

	// Return the number of times a pair occurs in an array of String elements.
	// A pair is any two String values that are equal (case sensitive) in
	// consecutive array elements. The array may be empty or have only one
	// element, in these cases return 0.
	//
	// numberOfPairs( {"a", "b", "c" } ) returns 0
	// numberOfPairs( {"a", "a", "a"} ) returns 2
	// numberOfPairs( {"a", "a", "b", "b" } ) returns 2
	// numberOfPairs( {"a", "A", "b", "B" } ) returns 0
	// numberOfPairs( {"1", "1", "1", "1" } ) returns 3
	// numberOfPairs( {"a"} ) returns 0
	// numberOfPairs( { } ) returns 0
	//
	public int numberOfPairs(String[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(array[i + 1])) {
				count++;
			}
		}
		return count;
	}

	// Given an array of double array elements, return true if the sum of all
	// array elements is greater than sum. Sum may be negative.
	//
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 4.0) returns true
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 6.6) returns false
	// sumGreaterThan( { -1.0, -1.0, -1.0}, -4.0) returns true
	// sumGreaterThan( { -1.0, -1.0, -1.0}, -3.0) returns false (sum == -3.0)
	// sumGreaterThan( { -1.0, -1.0, -1.0}, -2.0) returns false (-3.0 < -2.0)
	//
	// Precondition: array.length > 0
	public boolean sumGreaterThan(double[] array, double sum) {
		double total = 0;
		for (double i : array) {
			total += i;
		}
		return total > sum;
	}

	// Modify array, so it is "left shifted" n times. shiftNTimes({6, 2, 5, 3}, 1)
	// changes the array argument to {2, 5, 3, 6} and shiftNTimes({6, 2, 5, 3}, 2)
	// changes the array argument to {5, 3, 6, 2}.
	//
	// You must modify the array argument by changing the parameter array inside
	// method shiftNTimes. Remember, a change to the parameter inside the method
	// shiftNTimes changes the argument in the call.
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 3 ) modifies
	// the array to { 4, 5, 6, 7, 1, 2, 3 }
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 0 ) does not modify the array
	//
	// shiftNTimes( { 1, 2, 3 }, 5) modifies array to { 3, 1, 2 }
	//
	// shiftNTimes( { 3 }, 5) modifies array to { 3 }
	//
	public void shiftNTimes(int[] array, int numShifts) {
		int[] temporary = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i < numShifts) {
				temporary[array.length - numShifts + i] = array[i];
			} else {
				temporary[i - numShifts] = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = temporary[i];
		}

	}

	// Given a Scanner constructed with a String containing a stream of
	// integers in the range of 0..10 (like quiz scores), return an array
	// of 11 integers where the first value (at index 0) is the number of
	// 0s in the Scanner, the second value (at index 1) is the number of
	// ones on the Scanner, and the 11th value (at index 10) is the number
	// of tens in the Scanner. The following assertions must pass.
	//
	// Scanner scanner = new Scanner("5 0 1 2 1 5 2");
	// int[] result = functions.frequency(scanner);
	// assertEquals(11, result.length);
	// assertEquals(1, result[0]); // there was one 0
	// assertEquals(2, result[1]); // two 1s
	// assertEquals(2, result[2]); // two 2s
	// assertEquals(0, result[3]); // zero 3s
	// assertEquals(0, result[4]); // zero 5s
	// assertEquals(2, result[5]); // There were two 5s
	// for(int score = 6; score <= 10; score++) {
	// ..assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
	// }
	//
	// Precondition: scanner has only valid ints in the range of 0..10.
	public int[] frequency(Scanner scanner) {

		int[] countArray = new int[11];
		while (scanner.hasNextInt()) {
			int next = scanner.nextInt();
			countArray[next]++;
		}
		return countArray;
	}

	// Complete method howMany to return the number of elements in an array of
	// Strings that equals valueToFind. This is case sensitive. The array may
	// be empty.
	//
	// howMany( {"A", "a", "A", "a" }, "A" ) returns 2
	// howMany( {"And", "there", "goes", "another"}, "another" ) returns 1
	// howMany( {"And", "there", "goes", "another"}, "Not Here" ) returns 0
	// howMany( { }, "empty array" ) returns 0
	//
	public int howMany(String[] array, String valueToFind) {
		int count = 0;
		for (String s : array) {
			if (s.equals(valueToFind)) {
				count++;
			}
		}
		return count;
	}

	// Modify the parameter array that has 0 to many ints so it still contains the
	// exact same numbers, but rearranged so that all the even numbers come before
	// all the odd numbers. Other than that, the numbers can be in any order. You
	// must modify the array argument by changing array in method evensLeft. The
	// array may be empty or have only 1 element so no change should be made.
	//
	// Original Array. . . . . Modified Array. Your order may differ
	// {1, 0, 1, 0, 0, 1, 1} . { 0, 0, 0, 1, 1, 1, 1 }
	// {3, 3, 2} . . . . . . . { 2, 3, 3 }
	// {2, 2, 2} . . . . . . . { 2, 2, 2}
	// {1, -2, 3, 4, -6} . . . { -2, 4, -6, 1, 3}
	//
	public void evensLeft(int[] array) {
		int countEvens = 0;
		int countOdds = 0;
		int[] temporaryEvens = new int[array.length];
		int[] temporaryOdds = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				temporaryEvens[countEvens] = array[i];
				countEvens++;
			} else {
				temporaryOdds[countOdds] = array[i];
				countOdds++;
			}
		}
		for (int i = 0; i < countEvens; i++) {
			array[i] = temporaryEvens[i];
		}
		for (int i = countEvens; i < countOdds + countEvens; i++) {
			array[i] = temporaryOdds[i - countEvens];
		}
	}

	// Return a new char[] that is a copy of array with all occurrences of oldChar
	// replaced by newChar. The original array argument must remain unchanged. The
	// returned array must have exactly the same capacity as the array reference
	// passed to the parameter referenced as array. This is case sensitive.
	//
	// replaced ({'A', 'B', 'C', 'D', 'B'}, 'B', '+') returns a
	// new array {'A', '+', 'C', 'D', '+'}
	//
	// replaced( { 'C', 'B', 'C', 'D', 'c'}, 'C', 'L' ) returns a
	// new array { 'L', 'B', 'L', 'D', 'c' }
	//
	// replaced( { 'n', 'n', 'n', 'D', 'n'}, 'n', 'T' ) returns a
	// new array { 'T', 'T', 'T', 'D', 'T' }
	//
	// replaced( { }, 'n', 'T' ) returns a new array { }
	//
	public char[] replaced(char[] array, char oldChar, char newChar) {
		char[] newArray = array.clone();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == oldChar) {
				newArray[i] = newChar;
			}
		}

		return newArray;
	}

	// Return the range of the numbers in an array[].
	// The range is the maximum value - minimum value
	//
	// range (new int[] {1, 2, 3, 4}) returns 4 - 1 or 3
	// range (new int[] {1, 2, -3, 4}) returns 4 - -3 or 7
	// range (new int[] { 99 }) returns 0
	//
	// Precondition: x.length >= 1
	public int range(int[] x) {
		int min = x[0];
		int max = x[0];
		for (int i : x) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;

		}
		return max - min;
	}

	// Return true if search is found in strs or false if search is not found in
	// the array. This method is case-sensitive, the string must match exactly.
	//
	// found( "A", {"A","B","C"} ) returns true
	// found( "a", {"A","B","C"} ) returns false
	// found( "x", {"a","b","c", "d"} ) returns false
	// found( "x", { } ) returns false
	//
	public boolean found(String search, String[] strs) {
		boolean isThereAString = false;
		for (String s : strs) {
			if (search.equals(s))
				isThereAString = true;
		}
		return isThereAString;
	}

	// Consider the leftmost and rightmost appearances of some values in an array.
	// The "width" is the number of elements between the two appearances inclusive.
	// A single value has a span of 1. Return the largest "width" found in the
	// given array.
	//
	// largestWidth({ 1, 2, 1, 1, 3 }) returns 4 (index 0 through index 3)
	// largestWidth({ 1, 4, 2, 1, 4, 1, 4 }) returns 6 (index 0 through index 5)
	// largestWidth({ 5, 5, 5, 5 }) returns 4 (index 0 through index 3)
	// largestWidth({ 99 }) returns 1 (index 0 through index 0)
	// largestWidth({ }) returns 0 (an empty array)
	public int largestWidth(int[] nums) {
		if (nums.length == 0)
			return 0;
		else {
			int[] distanceByIndex = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				int distance = 0;
				for (int j = 0; j < nums.length; j++) {
					if (nums[i] == nums[j]) {
						if (Math.abs(i - j) > distance) {
							distance = Math.abs(i - j);

						}
					}
					distanceByIndex[i] = distance;
				}

			}
			int maxValue = distanceByIndex[0];
			for (int i : distanceByIndex) {
				if (i > maxValue) {
					maxValue = i;
				}
			}

			return maxValue + 1;
		}
	}

}