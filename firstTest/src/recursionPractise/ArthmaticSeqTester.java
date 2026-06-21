package recursionPractise;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArthmaticSeqTester {

	
	@Test
	public void test1() {
		
	
	ArthmaticSeq b = new ArthmaticSeq();
	int [] arr = {2,5,8,11,14};
	assertTrue(Arrays.equals(b.arithmeticArray(2, 3, 5),arr));
	}
	
}