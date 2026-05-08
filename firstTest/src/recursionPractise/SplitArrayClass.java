package recursionPractise;

public class SplitArrayClass {




public boolean splitArray(int[] nums) {
	  
	  int from = 1;
	  int to = nums.length -1;
	  
	  return splitRec(from, to, nums);
	  
	  
	}


	boolean splitRec(int from, int to, int[] nums){
	  
	  
	  //end of chain
	  if (from > to){
	    return sum(nums)==0;
	  }
	  
	  else {
	    //try positive version first
	    if (splitRec(from+1, to, nums)==true)
	    {return true;}
	    
	    //try negative vesion
	    nums[from] = -1*nums[from];
	    if (splitRec(from+1, to, nums)==true)
	    {return true;}
	    
	    else {return false;}
	    
	  }
	  
	    
	  }
	  
	int sum(int[] nums){
	  int sum=0;
	  for(int i=0;i<nums.length;i++){
	    sum += nums[i];
	  }
	  return sum;
	  
	  
	}
	
}