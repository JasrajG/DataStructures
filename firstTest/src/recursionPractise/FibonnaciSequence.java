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
	
	public static void main(String[] args) {
		
	}
}
