package recursionPractise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Array220Test {
	
	
	
static public boolean array220(int[] nums, int from, int to) {
		
		if (from == to || from >= nums.length-1 ) {
			return false;
		}
		
		else if(nums[from]*10 == nums[from+1]) {
			return true;
		}
		
		else {
			return array220(nums, from+1, to);
		}
		
		
		
	}

	// NOTE: If your array220 method is in another class (e.g., Main), 
	// you will need to call it like Main.array220(...) or instantiate the class.
	// For these tests, it assumes array220 is accessible in the current scope.

	@Test
	void testOriginalCodingBatCases() {
		// Translating the original tests by making 'to' the last index (length - 1)
		assertTrue(array220(new int[]{1, 2, 20}, 0, 2));
		assertTrue(array220(new int[]{3, 30}, 0, 1));
		assertFalse(array220(new int[]{3}, 0, 0));
		
		assertTrue(array220(new int[]{3, 3, 30, 4}, 0, 3));
		assertFalse(array220(new int[]{2, 19, 4}, 0, 2));
		assertFalse(array220(new int[]{20, 2, 21}, 0, 2));
		assertTrue(array220(new int[]{20, 2, 21, 210}, 0, 3));
		assertTrue(array220(new int[]{2, 200, 2000}, 0, 2));
		assertTrue(array220(new int[]{0, 0}, 0, 1));
		
		assertFalse(array220(new int[]{1, 2, 3, 4, 5, 6}, 0, 5));
		assertTrue(array220(new int[]{1, 2, 3, 4, 5, 50, 6}, 0, 6));
		assertFalse(array220(new int[]{1, 2, 3, 4, 5, 51, 6}, 0, 6));
	}

	@Test
	void testEmptyArray() {
		// For an empty array, 'from' is 0, but 'to' (typically length-1) would be -1.
		// The recursive method should safely handle this without an OutOfBoundsException.
		assertFalse(array220(new int[]{}, 0, -1));
	}

	@Test
	void testVersion2SubArrays() {
		// These tests specifically prove Version 2 works by restricting the search range.
		int[] nums = {1, 2, 20, 3, 30};

		// 1. Full array check (should find the 2 followed by 20)
		assertTrue(array220(nums, 0, 4));

		// 2. Restrict 'to' boundary: Check only indices 0 and 1.
		// It sees [1, 2] but STOPS before it can check [2, 20].
		assertFalse(array220(nums, 0, 1)); 

		// 3. Shift 'from' boundary: Start checking at index 3. 
		// It skips the [2, 20] but finds the [3, 30].
		assertTrue(array220(nums, 3, 4)); 

		// 4. Same start index, but restrict 'to' boundary so it can't check pairs.
		assertFalse(array220(nums, 3, 3));
	}
}


