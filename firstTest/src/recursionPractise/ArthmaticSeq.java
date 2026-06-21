package recursionPractise;

public class ArthmaticSeq {

	public int[] arithmeticArray(int start, int diff, int n) {
		int[] arr = new int[n];
		arr[0] = start;
		return helper(diff, 1, arr);
		
	}
	
	private int[] helper(int diff, int i , int[] arr) {
		if (i==arr.length) {
			return arr;
		}
		else {
			arr[i] = arr[i-1] + diff;
			i++;
			return helper(diff, i ,arr);
		}
	}
	
}
