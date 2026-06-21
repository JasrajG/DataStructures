package recursionPractise;

public class AllPositive {

	public boolean all_pos(int[] arr) {
		
			return all_pos_rec(arr , 0);
		
		
	}	
	
	private boolean all_pos_rec(int[] arr, int i) {
		
		if (i==arr.length) {
			return true;
		}
		else if(arr[i] <= 0) {
			return false;
		}
		else return all_pos_rec(arr, i+1);
	}
}
