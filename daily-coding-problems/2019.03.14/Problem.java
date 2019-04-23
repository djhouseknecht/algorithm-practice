/* 
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/

/**
 * Problem
 */
public class Problem {

	public static void main(String[] args) {
		if (args.length != 2) { 
			throw new RuntimeException("Please input exactly 1 (one) string and then exactly 1 (one) integer");
		}	

		String str = args[0];
		int chars = Integer.parseInt(args[1]);

		String substr = getLongestSubString(str, chars);

		System.out.printf("The longest substring of \"%s\" with {%d} distinct characters is: \"%s\"%n", str, chars, substr);
	}


	private static String getLongestSubString(String str, int length) {
		if (length < 1 || str.length() == 0) return null;
		// char[] chars = str.toCharArray();
		// String[] s = new String[length];

		// for 




		// List<Character> charCount = new ArrayList<>();
		// String substring = null;

		// for (int i = 0; i < chars.length; i++) { 
		// 	charCount.clear();
		// 	charCount
		// 	for (int j = 1; j <= length; j++) { 

		// 	}

		// }

		return null;
	}

}