package recursionPractise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsSortedTest {

	@Test
	void test1() {
		
		int[] array = {1,2,3,4,5,6,7,8,8,10};
		
		assertTrue(IsSorted.isSortedM(array));
		
		int[] arr = new int[0];
		System.out.print(arr.length);
		assertTrue(IsSorted.isSortedM(arr));
	}

}
