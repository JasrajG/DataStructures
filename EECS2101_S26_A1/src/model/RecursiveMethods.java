package model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;


public class RecursiveMethods {

	public String task1(String str) {
		
		
		if (str.charAt(0) != '('){
			return  task1(str.substring(1));
		}
		else if (str.charAt(str.length()-1) != ')') {
			return  task1(str.substring(0,str.length()-1));
		}
		else return str;
		
	}
	
	public Boolean task2(int[] arr, int target) {
		
		return task2Helper(arr, target, 0);
		
	}
	
	
	public Boolean task2Helper(int[] arr, int target, int index) {
		
		if (target == 0) {
			return true;
		}
		
		if (index==arr.length) {
			return false;
		}
		else {
		return task2Helper(arr, target-arr[index], index + 1) || task2Helper(arr, target, index + 1) ;
		}
	}
	
	
	
	///beginnning of task 3
	
	
	public int task3(int h, int n) {
		
		
		
		
		return task3Helper(h,n, n);
	}
	
	
	public int task3Helper(int h, int n, int max) {
		//base cases
		if (h==0) {
			return 1;
		}
		
		else if(h < 0) {
			return 0;
		}
		
		else {
			if(n>1) {
			return task3Helper(h-n , max, max ) + task3Helper(h, n-1, max);
			}
			else {
				return task3Helper(h-n , max, max);
				}
			
		}
	}
	
	
	
	
	///Beginning of task 4
	
	
	public HashSet<ArrayList<Integer>> task4(int h, int n){
		
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		ArrayList<Integer> templist = new ArrayList<Integer>();
		
		task4Helper(h, n, n, templist, set);
		
		return set;
	}
	
public void task4Helper(int h, int n, int max, ArrayList<Integer> templist, HashSet<ArrayList<Integer>> set){
		
	
	if (h==0) {
		ArrayList<Integer> list = new ArrayList<Integer>(templist);
		//add the arraylist to the HashSet
		set.add(list);
	}
	
	else if(h < 0) {
		
		//don't add it
	}
	
	else {
		if(n>1) {
			
			//add the move to our temporaroy arrayList
			templist.add(n);
			task4Helper(h-n , max, max, templist, set );
			templist.remove(templist.size()-1);
			
			
			task4Helper(h, n-1, max, templist, set);
		}
		else { //case when n=1
			templist.add(n);
			task4Helper(h-n , max, max, templist, set);
			templist.remove(templist.size()-1);
			}
		
	}
}
		
	}
	
	
	


