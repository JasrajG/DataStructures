package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.ListUtilities;

/*
 * Requirement: Any classes you create must reside in the `model` package and be imported properly.
 * For example, creating a new class `Foo` in the `model` package should result in:
 * 	import model.Foo;
 * 
 * For this lab, you should not need to declare attributes. 
 * 	But if you really want to, all attributes you declare in the model classes must be private. 
 * 
 * If necessary, you may define private helper methods. 
 */

public class ExtraTests {
	
	@Test
	public void test_getMergedList_05() {
		/*
		 * Comment: Left chain has all its values smaller than the right chain.
		 */
		
		ListUtilities util = new ListUtilities();
		Node<Integer> leftChain = new Node<>(1, new Node<>(3, new Node<>(5, new Node<>(7, new Node<>(9, null)))));
		Node<Integer> rightChain = new Node<>(11, new Node<>(13, new Node<>(15, new Node<>(17, new Node<>(19, null)))));
		
		/* Merging two non-empty chains, each assumed to be sorted in a non-descending order, 
		 * 	results in a new chain also sorted in a non-descending order.  
		 */  
		Node<Integer> output = util.getMergedChain(leftChain, rightChain);
		
		assertTrue(1 == output.getElement());
		assertTrue(3 == output.getNext().getElement());
		assertTrue(5 == output.getNext().getNext().getElement());
		assertTrue(7 == output.getNext().getNext().getNext().getElement());
		assertTrue(9 == output.getNext().getNext().getNext().getNext().getElement());
		assertTrue(11 == output.getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(13 == output.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(15 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(17 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(19 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_getMergedList_06() {
		/*
		 * Comment: Left chain has all its values larger than the right chain.
		 */
		
		ListUtilities util = new ListUtilities();
		Node<Integer> leftChain = new Node<>(11, new Node<>(13, new Node<>(15, new Node<>(17, new Node<>(19, null)))));
		Node<Integer> rightChain = new Node<>(1, new Node<>(3, new Node<>(5, new Node<>(7, new Node<>(9, null)))));
		
		/* Merging two non-empty chains, each assumed to be sorted in a non-descending order, 
		 * 	results in a new chain also sorted in a non-descending order.  
		 */  
		Node<Integer> output = util.getMergedChain(leftChain, rightChain);
		
		assertTrue(1 == output.getElement());
		assertTrue(3 == output.getNext().getElement());
		assertTrue(5 == output.getNext().getNext().getElement());
		assertTrue(7 == output.getNext().getNext().getNext().getElement());
		assertTrue(9 == output.getNext().getNext().getNext().getNext().getElement());
		assertTrue(11 == output.getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(13 == output.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(15 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(17 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(19 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_getMergedList_07() {
		/*
		 * Comment: Left chain is exhausted first.
		 */
		
		ListUtilities util = new ListUtilities();
		Node<Integer> leftChain = new Node<>(11, new Node<>(13, new Node<>(15, new Node<>(17, new Node<>(19, null)))));
		Node<Integer> rightChain = new Node<>(13, new Node<>(14, new Node<>(20, new Node<>(27, new Node<>(33, null)))));
		
		/* Merging two non-empty chains, each assumed to be sorted in a non-descending order, 
		 * 	results in a new chain also sorted in a non-descending order.  
		 */  
		Node<Integer> output = util.getMergedChain(leftChain, rightChain);
		
		assertTrue(11 == output.getElement());
		assertTrue(13 == output.getNext().getElement());
		assertTrue(13 == output.getNext().getNext().getElement());
		assertTrue(14 == output.getNext().getNext().getNext().getElement());
		assertTrue(15 == output.getNext().getNext().getNext().getNext().getElement());
		assertTrue(17 == output.getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(19 == output.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(20 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(27 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(33 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_getMergedList_08() {
		/*
		 * Comment: Right chain is exhausted first.
		 */
		
		ListUtilities util = new ListUtilities();
		Node<Integer> leftChain = new Node<>(13, new Node<>(14, new Node<>(20, new Node<>(27, new Node<>(33, null)))));
		Node<Integer> rightChain = new Node<>(11, new Node<>(13, new Node<>(15, new Node<>(17, new Node<>(19, null)))));
		
		/* Merging two non-empty chains, each assumed to be sorted in a non-descending order, 
		 * 	results in a new chain also sorted in a non-descending order.  
		 */  
		Node<Integer> output = util.getMergedChain(leftChain, rightChain);
		
		assertTrue(11 == output.getElement());
		assertTrue(13 == output.getNext().getElement());
		assertTrue(13 == output.getNext().getNext().getElement());
		assertTrue(14 == output.getNext().getNext().getNext().getElement());
		assertTrue(15 == output.getNext().getNext().getNext().getNext().getElement());
		assertTrue(17 == output.getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(19 == output.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(20 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(27 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertTrue(33 == output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_getGroupedStrings_03() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 1 and Group 2 are absent.
		 */
		
		Node<String> input = 
			new Node<>("vwxyzj",  
			new Node<>("ghic", 
			new Node<>("pqrstu", null)));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * No Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		
		/* 
		 * No Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		
		/* 
		 * Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		assertEquals("vwxyzj"	, output.getElement());
		assertEquals("ghic"		, output.getNext().getElement());
		assertEquals("pqrstu"	, output.getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_04() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 1 and Group 3 are absent.
		 */
		
		Node<String> input =  
			new Node<>("xy",  
			new Node<>("def", 
			new Node<>("bc", null)));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * No Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		
		/* 
		 * Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		assertEquals("xy"		, output.getElement());
		assertEquals("def"		, output.getNext().getElement());
		assertEquals("bc"		, output.getNext().getNext().getElement());
		
		/* 
		 * No Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		
		assertNull(output.getNext().getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_05() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 1 is absent.
		 */
		
		Node<String> input = 
			new Node<>("vwxyzj", 
			new Node<>("xy", 
			new Node<>("ghic", 
			new Node<>("pqrstu", 
			new Node<>("def", 
			new Node<>("bc",null))))));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * No Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */ 
		
		/* 
		 * Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		assertEquals("xy"		, output.getElement());
		assertEquals("def"		, output.getNext().getElement());
		assertEquals("bc"		, output.getNext().getNext().getElement());
		/* 
		 * Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		assertEquals("vwxyzj"	, output.getNext().getNext().getNext().getElement());
		assertEquals("ghic"		, output.getNext().getNext().getNext().getNext().getElement());
		assertEquals("pqrstu"	, output.getNext().getNext().getNext().getNext().getNext().getElement());
		
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_06() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 2 and Group 3 are absent.
		 */
		
		Node<String> input = 
			new Node<>("a", 
			new Node<>("", null));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		assertEquals("a"		, output.getElement());
		assertEquals(""			, output.getNext().getElement());
		
		/* 
		 * No Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		
		/* 
		 * No Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		
		assertNull(output.getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_07() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 2 is absent.
		 */
		
		Node<String> input = 
			new Node<>("vwxyzj", 
			new Node<>("ghic", 
			new Node<>("pqrstu",  
			new Node<>("a", 
			new Node<>("", null))))); 
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		assertEquals("a"		, output.getElement());
		assertEquals(""			, output.getNext().getElement());
		
		/* 
		 * No Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		
		/* 
		 * Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		assertEquals("vwxyzj"	, output.getNext().getNext().getElement());
		assertEquals("ghic"		, output.getNext().getNext().getNext().getElement());
		assertEquals("pqrstu"	, output.getNext().getNext().getNext().getNext().getElement());
		
		assertNull(output.getNext().getNext().getNext().getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_08() {
		ListUtilities util = new ListUtilities();
		
		/*
		 * Comment: Group 3 is absent.
		 */
		
		Node<String> input =  
			new Node<>("xy",   
			new Node<>("def", 
			new Node<>("bc", 
			new Node<>("a", 
			new Node<>("", null)))));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4); 
		/* 
		 * Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		assertEquals("a"		, output.getElement());
		assertEquals(""			, output.getNext().getElement());
		/* 
		 * Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		assertEquals("xy"		, output.getNext().getNext().getElement());
		assertEquals("def"		, output.getNext().getNext().getNext().getElement());
		assertEquals("bc"		, output.getNext().getNext().getNext().getNext().getElement());
		/* 
		 * No Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		
		assertNull(output.getNext().getNext().getNext().getNext().getNext());
		
		/*
		 * The input and output chains do not share any node references in common.
		 * i.e., there is no reference aliasing.
		 */
		assertTrue(noAliasing(input, output));
	}
	
	/*
	 * Helper method used by some JUnit tests methods.
	 * This method makes sure that the two chains of nodes, starting at `n1` and `n2`,
	 * do not overlap in their node references,
	 * i.e., The reference of each node in chain 1 (starting at `n1`)
	 * 			is not equal to the reference of each node in chain 2 (starting at `n2`).
	 */
	private <E> boolean noAliasing(Node<E> n1, Node<E> n2) {
		Node<E> current1 = n1;
		Node<E> current2 = n2;
		boolean found = false;
		while(current1 != null && !found) {
			while(current2 != null && !found) {
				found = current1 == current2;
				current2 = current2.getNext();
			}
			current1 = current1.getNext();
			current2 = n2;
		}
		return !found;
	}
}