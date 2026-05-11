package recursionPractise;

public class TowerOfHanoiClass {

	
	public static void TofH(int n) {
		
		int initial = 1;
		int intermediate = 2; //intermediate
		int destination = 3; //destination
		
		TofHRec(n,initial, intermediate,destination);
		
	}
	
	public static void TofHRec(int n, int initial, int intermediate, int destination) {
		
		//base case
		
		if (n==1) 
		{
			System.out.println("Move from peg" + initial +" to peg" + destination);
			return;
			}
		//recrusive step 1
		TofHRec(n-1, initial, destination, intermediate);
		
		
		//recursive step 2
		System.out.println("Move from peg" + initial +" to peg" + destination);
		
		
		//recursive step 3
		TofHRec(n-1, intermediate, initial, destination);
		
		
	}
	
	public static void main(String args[]) {
		TofH(10);
	}
	
}
