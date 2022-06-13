// Ivan Akinfiev
// This program takes two inputs as strings, converts instantly them to int and
// calculates the differences between departure times of two different trains, which our inputs are.
// The result will be shown on the screen. 

import java.util.Scanner;
import java.lang.*;

public class TrainDepartures {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter when train A departs:");
		int firstTrainTime = Integer.parseInt(keyboard.next());
		System.out.println("Enter when train B departs:");
		int secondTrainTime = Integer.parseInt(keyboard.next());
		boolean aBiggerThanB = true;

		int firstTrainHours = firstTrainTime / 100;
		int secondTrainHours = secondTrainTime / 100;
		int firstTrainMinutes = firstTrainTime % 100;
		int secondTrainMinutes = secondTrainTime % 100;
		if (firstTrainHours == secondTrainHours) {
			System.out.println("Difference: 0 Hours " + Math.abs(firstTrainMinutes - secondTrainMinutes) + " Minutes");
		}
		if ((firstTrainHours > secondTrainHours && firstTrainMinutes < secondTrainMinutes)
				|| ((firstTrainHours < secondTrainHours && firstTrainMinutes > secondTrainMinutes))) {
			System.out.println("Difference: " + (Math.abs(firstTrainHours - secondTrainHours) - 1) + " Hours and "
					+ (60 - Math.abs(firstTrainMinutes - secondTrainMinutes)) + " Minutes");
		}
		if ((firstTrainHours > secondTrainHours && firstTrainMinutes > secondTrainMinutes)
				|| ((firstTrainHours < secondTrainHours && firstTrainMinutes < secondTrainMinutes))) {
			System.out.println("Difference: " + Math.abs(firstTrainHours - secondTrainHours) + " Hours and "
					+ Math.abs(firstTrainMinutes - secondTrainMinutes) + " Minutes");
		}

	}
}
