import java.util.Scanner;

/* This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass? */

public class Problem {

	// scanner to get input from the user
	private static Scanner scanner = new Scanner(System.in);
	private static int[] array = { 10, 15, 3, 7 };
	private static final int CORRECT_VALUE = 17;

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.printf("Please enter an integer to see if it plus an integer in the array equals %s: ", CORRECT_VALUE);
		String inputStr = scanner.nextLine().trim();
		int input = Integer.parseInt(inputStr);

		boolean matched = false;

		for (int value : array) {
			int combined = value + input;
			if (combined == CORRECT_VALUE) {
				matched = true;
				System.out.println("YOU GOT IT!");
				System.out.println("Your value: " + input);
				System.out.println("Matched value: " + value);
				System.out.println("Combined value: " + CORRECT_VALUE);
				break;
			}
		}

		if (!matched) {
			System.out.println("Oh, sorry, that didn't work.");
		}

		System.out.print("You would like to try again? Type 1 (one) for \"yes\" and 0 (zero) for \"no\": ");
		int tryAgain = Integer.parseInt(scanner.nextLine());

		if (tryAgain == 1) {
			start();
		} else {
			System.out.println("Thanks!");
		}
	}
}