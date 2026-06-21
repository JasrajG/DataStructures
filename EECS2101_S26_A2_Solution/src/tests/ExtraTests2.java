package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.ListUtilities;

public class ExtraTests2 {

	// We will make the assumption that the input chain is not null.
//	@Test
//	public void test_prefixes_01() {
//		/*
//		 * comment: test getAllPrefixes with null values, case 1: (null, 0, 2)
//		 */
//		ListUtilities lu = new ListUtilities();
//		Node<Integer> input = createNodes(new Integer[] {null, 0, 2});
//		Node<String> output = lu.getAllPrefixes(input, 1, 5);
//		checkPrefixNodes(output, Arrays.asList("null", "0", "2"), 0);
//	}
	
//	@Test
//	public void test_prefixes_02() {
//		/*
//		 * comment: test getAllPrefixes with null values, case 1: (null, null, 5, 6, 7)
//		 */
//		ListUtilities lu = new ListUtilities();
//		Node<Integer> input = createNodes(new Integer[] {null, null, 5, 6, 7});
//		Node<String> output = lu.getAllPrefixes(input, 2, 4);
//		checkPrefixNodes(output, Arrays.asList("null", "null", "5", "6"), 1);
//	}

	@Test
	public void test_prefixes_03() {
		/*
		 * comment: test getAllPrefixes with range selection, range (3, 4)
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> input = createNodes(new Integer[] {8, 9, 4, 5, 7});
		Node<String> output = lu.getAllPrefixes(input, 3, 4);
		checkPrefixNodes(output, Arrays.asList("8", "9", "4", "5"), 2);
	}
	
	@Test
	public void test_prefixes_04a() {
		/*
		 * comment: test getAllPrefixes with m = n, n = size of chain
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> input = createNodes(new Integer[] {8, 9, 4, 5, 7});
		Node<String> output = lu.getAllPrefixes(input, 5, 5);
		checkPrefixNodes(output, Arrays.asList("8", "9", "4", "5", "7"), 4);
	}
	
	@Test
	public void test_prefixes_04b() {
		/*
		 * comment: test getAllPrefixes with m = n, n > 1, n < size of chain
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> input = createNodes(new Integer[] {8, 9, 4, 5, 7});
		Node<String> output = lu.getAllPrefixes(input, 3, 3);
		checkPrefixNodes(output, Arrays.asList("8", "9", "4"), 2);
	}
	
	@Test
	public void test_prefixes_04c() {
		/*
		 * comment: test getAllPrefixes with m = n, n = 1, n < size of chain
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> input = createNodes(new Integer[] {8, 9, 4, 5, 7});
		Node<String> output = lu.getAllPrefixes(input, 1, 1);
		checkPrefixNodes(output, Arrays.asList("8"), 0);
	}
	
	@Test
	public void test_prefixes_05() {
		/*
		 * comment: test getAllPrefixes with n = the length of the input chain
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> input = createNodes(new Integer[] {1, 2, 3, 4, 5});
		Node<String> output = lu.getAllPrefixes(input, 3, 5);
		checkPrefixNodes(output, Arrays.asList("1", "2", "3", "4", "5"), 2);
	}
	
	@Test
	public void test_get_merged_list_1() {
		/*
		 * comment: merge two chains, where the result contains interleaved elements from each chain.
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> leftChain = createNodes(new Integer[] {10, 20, 30, 40});
		Node<Integer> rightChain = createNodes(new Integer[] {5, 15, 25, 35});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_get_merged_list_2() {
		/*
		 * comment: merge chains, both chains have replicated values
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> leftChain = createNodes(new Integer[] {5, 5, 10, 20, 20});
		Node<Integer> rightChain = createNodes(new Integer[] {5, 5, 15, 20, 30, 40});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(5, 5, 5, 5, 10, 15, 20, 20, 20, 30, 40));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}

	@Test
	public void test_get_merged_list_3a() {
		/*
		 * comment: merge chains, the result is simply elements from the right chain, 
		 * followed by elements from the left chain.
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> leftChain = createNodes(new Integer[] {20, 20, 30, 35, 40});
		Node<Integer> rightChain = createNodes(new Integer[] {5, 10, 15, 20});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(5, 10, 15, 20, 20, 20, 30, 35, 40));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_get_merged_list_3b() {
		/*
		 * comment: merge chains, the result is simply elements from the left chain, 
		 * followed by elements from the right chain.
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> leftChain = createNodes(new Integer[] {5, 10, 15, 20});
		Node<Integer> rightChain = createNodes(new Integer[] {20, 20, 30, 35, 40});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(5, 10, 15, 20, 20, 20, 30, 35, 40));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}

	@Test
	public void test_get_merged_list_4() {
		/*
		 * comment: merge chains, the left chain has more elements than the right chain. 
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> leftChain = createNodes(new Integer[] {1, 2, 3, 5, 6, 10, 23, 46, 68});
		Node<Integer> rightChain = createNodes(new Integer[] {4, 7, 8, 9});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 46, 68));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}

	@Test
	public void test_get_merged_list_5() {
		/*
		 * comment: merge chains, the right chain has more elements than the left chain. 
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> rightChain = createNodes(new Integer[] {1, 2, 3, 5, 6, 10, 13, 18, 21});
		Node<Integer> leftChain = createNodes(new Integer[] {4, 7, 8, 9});
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 18, 21));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_get_merged_list_6() {
		/*
		 * comment: merge two identical chains 
		 */
		ListUtilities lu = new ListUtilities();
		Node<Integer> rightChain = createNodes(new Integer[] {1, 2, 3, 6, 10 });
		Node<Integer> leftChain = createNodes(new Integer[] {1, 2, 3, 6, 10 });
		Node<Integer> output = lu.getMergedChain(leftChain, rightChain);
		
		checkNodesInOrder(output, Arrays.asList(1, 1, 2, 2, 3, 3, 6, 6, 10, 10));
		
		assertTrue(noAliasing(output, leftChain));
		assertTrue(noAliasing(output, rightChain));
	}
	
	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_1() {
		/*
		 * comment: interleaving empty arithmetic and Fibonacci sequences. 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(0, 0, 0, 0);
		checkNodesInOrder(output, Arrays.asList());
	}
	
	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_2() {
		/*
		 * comment: call getInterleavedArithmeticFibonacciSequences with parameters(0, 0, 1, 0) 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(0, 0, 1, 0);
		checkNodesInOrder(output, Arrays.asList(0));
	}

	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_3() {
		/*
		 * comment: call getInterleavedArithmeticFibonacciSequences with parameters(9, 0, 10, 10) 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(9, 0, 10, 10);
		checkNodesInOrder(output, Arrays.asList(9, 1, 9, 1, 9, 2, 9, 3, 9, 5, 9, 8, 9, 13, 9, 21, 9, 34, 9, 55));
	}
	
	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_4a() {
		/*
		 * comment: call getInterleavedArithmeticFibonacciSequences with parameters(9, -1, 3, 10) 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(9, -1, 3, 10);
		checkNodesInOrder(output, Arrays.asList(9, 1, 8, 1, 7, 2, 3, 5, 8, 13, 21, 34, 55));
	}
	
	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_4b() {
		/*
		 * comment: call getInterleavedArithmeticFibonacciSequences with parameters(9, -1, 10, 3) 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(9, -1, 10, 3);
		checkNodesInOrder(output, Arrays.asList(9, 1, 8, 1, 7, 2, 6, 5, 4, 3, 2, 1, 0));
	}
	
	@Test
	public void test_getInterleavingArthemeticFibonacciSeq_5() {
		/*
		 * comment: call getInterleavedArithmeticFibonacciSequences with parameters(-1, -1, 3, 10) 
		 */
		ListUtilities lu = new ListUtilities();

		Node<Integer> output = lu.getInterleavedArithmeticFibonacciSequences(-1, -1, 5, 5);
		checkNodesInOrder(output, Arrays.asList(-1, 1, -2, 1, -3, 2, -4, 3, -5, 5));
	}
	
	@Test
	public void test_getGroupedStrings_1() {
		/*
		 * comment: test getGroupedStrings, all 3 groups contain strings from the input chain.
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				"x", "abc", "def", "ab", "de", "x9", "y"
		});
		Node<String> output = lu.getGroupedStrings(input, 2, 3);
		
		checkNodesInOrder(output, Arrays.asList("x", "y", "ab", "de", "x9", "abc", "def"));
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_2() {
		/*
		 * comment: test getGroupedStrings, m = n
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				"xss", "yzz", "d", "yb"
		});
		Node<String> output = lu.getGroupedStrings(input, 2, 2);
		
		checkNodesInOrder(output, Arrays.asList("d", "xss", "yzz", "yb"));
		
		assertTrue(noAliasing(input, output));
	}

	@Test
	public void test_getGroupedStrings_3() {
		/*
		 * comment: test getGroupedStrings(input, 1, 2), the input chain only contains one empty string.
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				""
		});
		Node<String> output = lu.getGroupedStrings(input, 1, 2);
		
		checkNodesInOrder(output, Arrays.asList(""));
		
		assertTrue(noAliasing(input, output));
	}

	@Test
	public void test_getGroupedStrings_4() {
		/*
		 * comment: test getGroupedStrings, the input chain only contains three strings,
		 *  each string belongs to one group. 
		 *  (case one: the order of strings in the output chain is different from the input chain)
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				"abxd", "a", "ef"
		});
		Node<String> output = lu.getGroupedStrings(input, 2, 3);
		
		checkNodesInOrder(output, Arrays.asList("a", "ef", "abxd"));
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_5() {
		/*
		 * comment: test getGroupedStrings, the input chain only contains three strings,
		 *  each string belongs to one group.
		 *  (case two: the order of strings in the output chain is the same as the input chain)
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				"a", "b", "ef", "dh", "xyzd", "bufyss"
		});
		Node<String> output = lu.getGroupedStrings(input, 2, 3);
		
		checkNodesInOrder(output, Arrays.asList("a", "b", "ef", "dh", "xyzd", "bufyss"));
		
		assertTrue(noAliasing(input, output));
	}
	
	@Test
	public void test_getGroupedStrings_6() {
		/*
		 * comment: test getGroupedStrings, the input chain only contains three strings,
		 *  each string belongs to one group.
		 *  (case three: the order of strings in the output chain is the reverse of the input chain)
		 */
		ListUtilities lu = new ListUtilities();
		
		Node<String> input = createNodes(new String[] {
				"abxd", "ef", "a"  
		});
		Node<String> output = lu.getGroupedStrings(input, 2, 3);

		checkNodesInOrder(output, Arrays.asList("a", "ef", "abxd"));
		
		assertTrue(noAliasing(input, output));
	}
	
	private void checkPrefixNodes(Node<String> prefixNodes, List<String> incValues, int start) {
		int expectedNodeLength = incValues.size() - start;
		for (int i =0; i < expectedNodeLength; i++) {
			assertEquals(String.format("[%s]",
					String.join(", ", incValues.subList(0, start+i+1))), 
					nodeAt(prefixNodes, i).getElement());
		}
		assertNull(nodeAt(prefixNodes, expectedNodeLength));
	}
	
	private <T> void checkNodesInOrder(Node<T> node, List<T> values) {
		for (int i =0; i < values.size(); i++) {
			assertEquals(values.get(i), nodeAt(node, i).getElement());
		}
		assertNull(nodeAt(node, values.size()));
	}
	
	private <T> Node<T> nodeAt(Node<T> node, int pos){
		for (int i=0; i < pos; i++) {
			node = node.getNext();
		}
		return node;
	}
	
	// helpers
	private final <T> Node<T> createNodes(T[] values) {
		Node<T> node = null;
		for (int i = values.length -1; i >=0; i--) {
			node = new Node<T>(values[i], node);
		}
		return node;
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
