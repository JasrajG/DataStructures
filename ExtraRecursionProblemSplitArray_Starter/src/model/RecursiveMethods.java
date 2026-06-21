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
		
		/* Change this line to a call to the recursive helper method.
		 * 
		 * Given that the return type of the method under test is Boolean,
		 * just returning the default value "false" can already allow you to pass about half of the tests!
		 * 
		 * However, in the actual programming test, the return type may be changed, so
		 * your focus should be to pass all tests.   
		 * 
		 * 
		 * 
		 */
		
		if (ns.length == 0) {
			return true;
		}
		
		
		return splitArrayRec(ns, 0 , 0); 
	}
	
	
	private boolean splitArrayRec(int[] arr, int i, int sum) {
		
		if (i == arr.length) {
			return (sum == 0);
		}
		else {
			return splitArrayRec(arr, i+1, sum + arr[i]) || splitArrayRec(arr, i+1, sum - arr[i]);
		}
	}
}
