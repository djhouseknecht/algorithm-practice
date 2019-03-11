import java.util.ArrayList;
import java.util.List;

/* This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? */

public class Problem { 
	public static void main(String[] args) {
		// make sure the user has passed in an array on integers 
		if (args == null || args.length <= 1) {
			throw new RuntimeException("You must enter an array of two or more integers in order to prceed");
		}

		// convert the args array to a list of Integers
		List<Integer> list = new ArrayList<>();
		for (String arg : args) {
			list.add(Integer.valueOf(arg));
		} 

		// print out what the user originally entered
		System.out.println("The orignal array was:");
		System.out.println(list);

		// variable for the new list 
		List<Integer> newList = new ArrayList<>();
		// loop through the entire array to 
		for (int i = 0; i < list.size(); i++) { 
			
			// variable for the product
			Integer product = 0;

			// multiple each element together 
			for (int j = 0; j < list.size(); j++) { 
				// if the index is the current index, then we need to skip the multiplication
				if (j != i) {
					// if this is the first time multiply,
					// then we will just set product to the integer 
					// at the current index
					if (product == 0) {
						product = list.get(j);
					} else { 
						product *= list.get(j);
					}
				} // end if
			} // end inner for

			// now that we have the product, let's set the new 
			// list's value at that index
			newList.add(product);

		} // end outer for

		// print out what the calculated array
		System.out.println("The new array is:");
		System.out.println(newList);

	} // end main() method
}