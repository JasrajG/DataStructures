package model;

import java.util.ArrayList;
import java.util.HashSet;

public class RecursiveUtilities {

	public HashSet<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> list) {
		
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		helper(set, list , 0);
		
		return set;
	}
	
	
	private void helper(HashSet<ArrayList<Integer>> set, ArrayList<Integer> list, int index) {
		if (index == list.size()) {
			ArrayList<Integer> clone = new ArrayList<Integer> (list);
			set.add(clone);
		}
		
		else {
				ArrayList<Integer> clone = new ArrayList<Integer> (list);
				clone.remove(index);
				helper(set, clone, 0);
				helper(set, list, index + 1);
		}	
				
	}
	
	

	public HashSet<ArrayList<Integer>> getAllSubsetsAlt(ArrayList<Integer> arrayList) {
		
		return getAllSubsets(arrayList);
		
			

	}
	
	
	
	
	
	/*public HashSet<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
		HashSet<ArrayList<Integer>> result = new HashSet<>();
		getAllSubsetsHelper(set, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void getAllSubsetsHelper(ArrayList<Integer> set, int i, ArrayList<Integer> subsetSoFar, HashSet<ArrayList<Integer>> result) {
		if(i == set.size()) {
			result.add(subsetSoFar);
		} 
		else {
			ArrayList<Integer> extendedSubset = new ArrayList<>(subsetSoFar);
			extendedSubset.add(set.get(i));
			getAllSubsetsHelper(set, i + 1, extendedSubset, result);
			getAllSubsetsHelper(set, i + 1, subsetSoFar, result);
		}
	}


 //Alternative version (working, but not in a style matching what we covered in lectures)
 
	public HashSet<ArrayList<Integer>> getAllSubsetsAlt(ArrayList<Integer> set) {
		HashSet<ArrayList<Integer>> result = new HashSet<>();
		result.add(new ArrayList<>());
		getAllSubsetsHelper(set, 0, result);
		return result;
	}

	private void getAllSubsetsHelper(ArrayList<Integer> set, int i, HashSet<ArrayList<Integer>> result) {
		if(i < set.size()) {
			HashSet<ArrayList<Integer>> additionalSubsets = new HashSet<>();
			for(ArrayList<Integer> subset : result) {
				ArrayList<Integer> extendedSubset = new ArrayList<>(subset);
				
				 // Two possibilities: 
				  //	The current item at index i is included in or excluded from the subsets. 
				 
				extendedSubset.add(set.get(i));
				additionalSubsets.add(extendedSubset); 
			}
			result.addAll(additionalSubsets);
			getAllSubsetsHelper(set, i + 1, result);
		} 
		*/
	}
