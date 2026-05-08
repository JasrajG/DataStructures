package recursionPractise;

public class IsSorted {

	
	//initializer
	public static boolean isSortedM(int[] arr) {
		
		int i=0; //counter
		
		return isSortedRec(i, arr);
	
	}
	
	
	//recursive method
	//this method assumes that the values inside the array have been initilalized
	public static boolean isSortedRec(int i, int[] arr) {
		if (i == arr.length -1 || arr.length == 0) {
			return true;
		}
		else if(arr[i] > arr[i+1]) {
			return false;
		}
		
		else {
			return isSortedRec(i+1, arr);
		}
		
		
	}
	
	
}
