package recursionPractise;

public class FibonnaciSequence {

	
	public static int fibonacci(int n) {
		
		//edge cases
		
		if (n<0) {
			throw new IllegalArgumentException("Fibonnci Sequence isn't defined for negative numbers. You provided" + n);
		}
		
		//base case
		
		if (n == 0 || n ==1) {
			return 1;
		}
		
		else {return fibonacci(n-1)+fibonacci(n-2);}
	}
	
	
	
	
	//initiailizer method for taking advantage of passing by value
	public static int fibArr(int n) {
		if (n<0) {
			throw new IllegalArgumentException("Fibonnaci Sequence not defined for negtaive numbers!");
		}
		int i = 0 ; //initialize counter
		int[] arr = new int[n+1];
		return fibArrRec(i,arr);
		
		
	}
	
	public static int fibArrRec(int i, int[] arr) {
		return 0;
	}
	
	
	
	
	

}
