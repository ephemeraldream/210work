/*
Name: Rick Mercer and Ivan Akinfiev
Course: CSC210

Program: This program is basically a simple game where a user needs to guess
a randomly generated number. This program uses a single while loop
in order to give an opportunity for user to repeat guessing.
Interestingly, we can win this game with O(log(N)) steps :).
 */

package hw4;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
	public static void main(String[] args) {
		Random generator = new Random();
		Scanner keyboard = new Scanner(System.in);
		int count = 1;
		int actualNumber = generator.nextInt(100) + 1;
		while (true) {
			System.out.print("Enter a Number from 1 through 100: ");
			int guessedNumber = keyboard.nextInt();
			if (guessedNumber == actualNumber) {
				System.out.println("You got it in " + count + " guesses");
				break;
			}
			if (guessedNumber > actualNumber) {
				System.out.println(guessedNumber + " is too large");
				count += 1;
			}
			if (guessedNumber < actualNumber) {
				System.out.println(guessedNumber + " is too small");
				count += 1;
			}

		}

	}
}
