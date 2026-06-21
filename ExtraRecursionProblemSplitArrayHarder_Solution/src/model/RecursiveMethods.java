package model;

import java.util.ArrayList;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 */
public class RecursiveMethods {
	
	/*
	 * A useful extension to the original `splitArray` problem.
	 * 
	 * If a split of equal sums is possible, return an ArrayList of size 2: 
	 * 	- index 1 of the returned ArrayList stores the list of integers representing group 1.
	 * 	- index 0 of the returned ArrayList stores the list of integers representing group 2.
	 * 
	 * If a split is not possible, both indices store empty lists.
	 * 
	 * Requirements (as an example, see `testSplitArrayHarder_14` in RecursiveMethodTests): 
	 * 	When an equal split is possible, then:
	 * 		+ The first element of the input array `ns` (i.e., ns[0]) must be put into group1.
	 * 		+ The order in which elements appear in each group must be the same as they appear in the input array `ns`.
	 * 
	 * Assumption: when a split is possible, there is a single, unique split only.
	 * 
	 * Hints:
	 * 		+ Pass as arguments two empty lists, representing group1 and group2, to the call to a recursive helper method.
	 * 			- Via call by value, the two lists should be modified properly among as the recursion tree is built.
	 * 		+ Also pass as argument an empty list, representing the final output list to be returned.
	 * 			- This output list may only be updated when an equal split is found.
	 * 			- On the other hand, the above-mentioned other two lists may be copied/extended as the recursive calls explore different possibilities.         		  
	 */
	public ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		
		/*
		 * Using call by value: 
		 * 	+ the `output` is going to be shared among all recursive calls.
		 * 		- The `output` should only be modified when we reach the base case, where we know for certain whether a split is possible.
		 * 	+ the `group1` and `group2` are also to be modified by different recursive calls.
		 * 		- Some of these two variables is expected to be modified whenever a new recursive call is made.  
		 */
		splitArrayHarderHelper(ns, 0, 0, 0, new ArrayList<>(), new ArrayList<>(), output);
		
		if(output.isEmpty()) {
			/*
			 * output being empty means that no equal split has been found. 
			 */
			output.add(new ArrayList<Integer>());
			output.add(new ArrayList<Integer>());
		}
		
		return output;
	}
	
	private void splitArrayHarderHelper(int[] ns, int i, int sumOfGroup1, int sumOfGroup2,
			ArrayList<Integer> group1, ArrayList<Integer> group2, ArrayList<ArrayList<Integer>> output) {
		if(i == ns.length) {
			if(sumOfGroup1 == sumOfGroup2) {
				// This is the only place where we update the output, rather than in each recursive call.
				output.add(group1);
				output.add(group2);
			}
		}
		else {
			/*
			 * Possibility 1: ns[i] is included in group1.
			 */
			/*
			 * This is not going to work: group1.add(ns[i]);
			 * This is because the same reference to group1 is passed to the next recursive call.
			 * However, when the next recursive call is facing again the possibilities of including ns[i + 1] into group1 or group2,
			 * 	we just cannot let the two further recursive calls interfere with each other by sharing the same reference group1. 
			 */
			ArrayList<Integer> group1Extended = new ArrayList<>(group1);
			group1Extended.add(ns[i]);
			splitArrayHarderHelper(ns, i + 1, sumOfGroup1 + ns[i], sumOfGroup2, group1Extended, group2, output);
			
			if(output.isEmpty()) {
				/*
				 * Possibility 2: ns[i] is included in group2.
				 */
				ArrayList<Integer> group2Extended = new ArrayList<>(group2);
				group2Extended.add(ns[i]);
				splitArrayHarderHelper(ns, i + 1, sumOfGroup1, sumOfGroup2 + ns[i], group1, group2Extended, output);
			}
		}
	}
}
