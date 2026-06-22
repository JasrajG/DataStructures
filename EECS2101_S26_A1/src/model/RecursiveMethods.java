package model;


import java.util.ArrayList;
import java.util.HashSet;


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
	
	public boolean task2(int[] arr, int target) {
		
		return task2Helper(arr, target, 0);
		
	}
	
	
	public boolean task2Helper(int[] arr, int target, int index) {
		
		if (target == 0) {
			return true;
		}
		
		else if (index==arr.length) {
			return false;
		}
		else {
		return task2Helper(arr, target-arr[index], index + 1) || task2Helper(arr, target, index + 1) ;
		}
	}
	
	
	
	///beginnning of task 3
	
	
	public int task3(int h, int n) {
	
		if (h < 0) {
			return 0;
		}
		else if (h == 0) {
			return 1;
		}
		else {
			int sum=0;
			for (int i=n; i>=1; i--) {
				sum += task3(h-i,n);
			}
			return sum;
		}
	}

	
	
	///Beginning of task 4
	
	
	public HashSet<ArrayList<Integer>> task4(int h, int n){
		
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		task4_helper(h, n, set, list);
		
		return set;
		
		
	}
	
	
	private void task4_helper(int h, int n, HashSet<ArrayList<Integer>> set, ArrayList<Integer> list) {
		
		if (h < 0) {
		}
		
		else if (h==0) {
			set.add(list);
		}
		else {
			for (int i =n; i >=1; i--) {
				ArrayList<Integer> current = new ArrayList<Integer>(list);
				current.add(i);
				System.out.println(current.size());
				task4_helper(h-i, n, set, current);
			}
		}
	}
}
	
	


