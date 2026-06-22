package recursionPractise;

public class Array220Class {

	static public boolean array220(int[] nums, int from, int to) {
		
		if (from == to) {
			return false;
		}
		
		else if(nums[from]*10 == nums[from+1]) {
			return true;
		}
		
		else {
			return array220(nums, from+1, to);
		}
		
		
		
	}
	
	
	
	
}
