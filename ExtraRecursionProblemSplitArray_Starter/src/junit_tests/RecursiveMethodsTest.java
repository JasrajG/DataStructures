package junit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.RecursiveMethods;

public class RecursiveMethodsTest {
	
	@Test
	public void testSplitArray_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 2};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 3};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 2, 3};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 2, 2};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_05() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 1, 1, 1, 1, 1};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_06() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 1, 1, 1, 1};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_07() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_08() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_09() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {3, 5};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_10() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 3, 2};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_11() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 2, 10, 10, 1, 1};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_12() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 2, 2, 10, 10, 1, 1};
		assertEquals(false, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_13() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 2, 3, 10, 10, 1, 1};
		assertEquals(true, rm.splitArray(input));
	}
	
	@Test
	public void testSplitArray_14() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 3, 2, 4};
		assertEquals(true, rm.splitArray(input));
	}
}
