package model;

/*
 * Requirement:
 * You are required to implement all methods recursively (without the use of loops).
 */
public class RecursiveMethods {

	/*
	 * Given an array of ints, 
	 * is it possible to divide the ints into two groups, 
	 * so that the sums of the two groups are the same. 
	 * 
	 * Every int must be in one group or the other. 
	 * 
	 * Write a recursive helper method that takes whatever arguments you like, 
	 * and make the initial call to your recursive helper from splitArray(). 
	 * (No loops needed.)
	 * 
	 * splitArray([2, 2]) → true
	 * splitArray([2, 3]) → false
	 * splitArray([5, 2, 3]) → true 
	 */
	public boolean splitArray(int[] ns) {
		/*
		 * Hint: Define a helper method that allows you to:
		 * 	+ Recursively go over the array `ns` from left to right.
		 * 	+ Consider, for the current array element being inspected:
		 * 		- the possibility of it being placed in Group 1
		 * 		- the possibility of it being placed in Group 2
		 * 	+ Between the recursive calls, keep track of the sum of group 1 and the sum of group 2, according to the possibility. 
		 *	+ When reaching the base case, after all array elements have been inspected:
		 *		- Check to see if the two sums maintained so far are equal.    
		 */
		return splitArrayHelper(ns, 0, 0, 0);
	}

	private boolean splitArrayHelper(int[] ns, int i, int sumOfGroup1, int sumOfGroup2) {
		if(i == ns.length) {
			/* `from` is an invalid index => 
			 * All elements in `ns` have been put into either group. */
			return sumOfGroup1 == sumOfGroup2;
		}
		else {
			/* Now we need to handle the element ns[i]: 
			 * 	Put it in either group 1 or group 2. Then continue with the remaining elements.
			 */
			/* 
			 * possibility1 = splitArrayHelper(ns, i + 1, sumOfGroup1 + ns[i], sumOfGroup2);
			 * possibility2 = splitArrayHelper(ns, i + 1, sumOfGroup1, sumOfGroup2 + ns[i]);
			 */ 
			return 
				splitArrayHelper(ns, i + 1, sumOfGroup1 + ns[i], sumOfGroup2) 
				|| 
				splitArrayHelper(ns, i + 1, sumOfGroup1, sumOfGroup2 + ns[i]);
		}
	}
}
