package model;

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
}

