package model;

import java.util.ArrayList;
import java.util.HashSet;

public class RecursiveUtilities {

	public HashSet<ArrayList<Integer>> getAllSubsets( ArrayList<Integer> input ) {
		HashSet<ArrayList<Integer>> output = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> empty_set = new ArrayList<Integer>();
		output.add(empty_set);
		
		if ( input == null) {
			return null;
		}
		else if (input.size() == 0){
			return output;
		}
		
		else {
			output.addAll(getAllSubsetsHelper(input));
			return output;
		}
		
		
		
		
		
	}
	
	
	
	private HashSet<ArrayList<Integer>> getAllSubsetsHelper( ArrayList<Integer> input ){
		HashSet<ArrayList<Integer>> output = new HashSet<ArrayList<Integer>>();
		if (input.size() == 1) {
			output.add(input);
			
		}
		else {
			
			output.add(input);
		
			for (int i = 0; i < input.size();i++) {
				Integer removed_element = input.get(i);
				input.remove(i);
				ArrayList<Integer> copy = new ArrayList<Integer>(input);
				output.addAll(getAllSubsetsHelper(copy));
				input.add(i, removed_element);
			}
		}
		return output;
		
		
	}
	

}
