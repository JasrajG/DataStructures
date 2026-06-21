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
	 * 	- index 0 of the returned ArrayList stores the list of integers representing group 1.
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
	 * 		+ Via call by value, the two lists should be modified properly among as the recursion tree is built.
	 * 		+ Upon the call terminating, return a list containing the two modified lists.      		  
	 */
	public ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		list.add(l1);
		list.add(l2);
		
		if (ns.length ==0) {
			return list;
		}
		else {
			return SplitArrayHarder_rec(ns, 0, 0, list);
		}
		
	}
	
	
	private ArrayList<ArrayList<Integer>> SplitArrayHarder_rec(int[] arr, int i, int sum, ArrayList<ArrayList<Integer>> list){
		
		if (i == arr.length) {
			if (sum==0) {
				return list;
			}
			else {
				return null;
			}
				
		}
		
		else {
			list.get(0).add(arr[i]);
			if (SplitArrayHarder_rec(arr, i+1, sum+arr[i], list) != null ) {
				return list;
			}
			else {
				list.get(0).remove(list.get(0).size()-1);
			}
			list.get(1).add(arr[i]);
			if (SplitArrayHarder_rec(arr, i+1, sum-arr[i], list) != null ) {
				return list;
			}
			else {
				list.get(1).remove(list.get(1).size()-1);
				
				if (i == 0) {
					return list;
					
				}
				else {
					return null;
				}
				
						
			}
		}
		

	}
}
