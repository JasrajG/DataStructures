package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import generic_sll.Node;
import generic_sll.SinglyLinkedList;
import generic_sll.ListUtilities;

/*
 * Tests on a generic SLL whose generic type parameter is instantiated as Integer.
 */

public class TestGenericSLL_String {
	@Test
	public void test_ChainOfStringNodes_Approach_01() {
		Node<String> tom = new Node<>("Tom", null); // alternatively: Node<String> tom = new Node<String>("Tom", null);
		Node<String> mark = new Node<>("Mark", tom);
		Node<String> alan = new Node<>("Alan", mark);
		
		assertTrue(alan.getNext() == mark);
		assertTrue(mark.getNext() == tom);
		assertTrue(alan.getNext().getNext() == tom);
		assertTrue(tom.getNext() == null);
		assertTrue(mark.getNext().getNext() == null);
		assertTrue(alan.getNext().getNext().getNext() == null);
		
		assertEquals("Alan", alan.getElement());
		assertEquals("Mark", mark.getElement());
		assertEquals("Mark", alan.getNext().getElement());
		assertEquals("Tom", tom.getElement());
		assertEquals("Tom", mark.getNext().getElement());
		assertEquals("Tom", alan.getNext().getNext().getElement());
	}
	
	@Test
	public void test_ChainOfStringNodes_Approach_02() {
		Node<String> alan = new Node<>("Alan", null);
		Node<String> mark = new Node<>("Mark", null);
		Node<String> tom = new Node<>("Tom", null);
		alan.setNext(mark);
		mark.setNext(tom);
		
		assertTrue(alan.getNext() == mark);
		assertTrue(mark.getNext() == tom);
		assertTrue(alan.getNext().getNext() == tom);
		assertTrue(tom.getNext() == null);
		assertTrue(mark.getNext().getNext() == null);
		assertTrue(alan.getNext().getNext().getNext() == null);
		
		assertEquals("Alan", alan.getElement());
		assertEquals("Mark", mark.getElement());
		assertEquals("Mark", alan.getNext().getElement());
		assertEquals("Tom", tom.getElement());
		assertEquals("Tom", mark.getNext().getElement());
		assertEquals("Tom", alan.getNext().getNext().getElement());
	}
	
	/*
	 * Setting the head of a SLL to a chain of node.
	 */
	@Test
	public void test_String_SLL_01() {
		Node<String> tom = new Node<>("Tom", null);
		Node<String> mark = new Node<>("Mark", tom);
		Node<String> alan = new Node<>("Alan", mark);
		
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.setHead(alan);
		
		assertTrue(tom == list.getTail());
		assertSame(tom, list.getTail());
		
		assertTrue(list.getSize() == 3);
		assertEquals("Alan", list.getFirst().getElement());
		assertEquals("Mark", list.getFirst().getNext().getElement());
		assertEquals("Tom", list.getFirst().getNext().getNext().getElement());
	}
	
	/*
	 * Gradually adding elements to a list by invoking SLL methods. 
	 * Exercise: contrast how the same SLL can be constructed using test_String_SLL_01 vs. test_String_SLL_02.
	 */
	@Test
	public void test_String_SLL_02() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst("Tom");
		list.addFirst("Mark");
		list.addFirst("Alan");
		assertTrue(list.getSize() == 3);
		assertEquals("Alan", list.getFirst().getElement());
		assertEquals("Mark", list.getFirst().getNext().getElement());
		assertEquals("Tom", list.getFirst().getNext().getNext().getElement());
	}
	
	@Test
	public void test_String_SLL_addAt() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst("Tom");
		list.addFirst("Mark");
		list.addFirst("Alan");
		assertTrue(list.getSize() == 3);
		
		list.addAt(0, "Suyeon"); 
		list.addAt(2, "Yuna");
		assertTrue(list.getSize() == 5);
		list.addAt(list.getSize(), "Heeyeon");
		assertTrue(list.getSize() == 6);
		assertEquals("Suyeon", list.getNodeAt(0).getElement());
		assertEquals("Alan", list.getNodeAt(1).getElement());
		assertEquals("Yuna", list.getNodeAt(2).getElement());
		assertEquals("Mark", list.getNodeAt(3).getElement());
		assertEquals("Tom", list.getNodeAt(4).getElement());
		assertEquals("Heeyeon", list.getNodeAt(5).getElement());
	}
	
	@Test
	public void test_String_SLL_removeLast() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst("Tom");
		list.addFirst("Mark");
		list.addFirst("Alan");
		assertTrue(list.getSize() == 3);
		
		list.removeLast();
		assertTrue(list.getSize() == 2);
		assertEquals("Alan", list.getNodeAt(0).getElement());
		assertEquals("Mark", list.getNodeAt(1).getElement());
		
		list.removeLast();
		assertTrue(list.getSize() == 1);
		assertEquals("Alan", list.getNodeAt(0).getElement());
		
		list.removeLast();
		assertTrue(list.getSize() == 0);
		assertNull(list.getFirst());
	}
	
	
	
	
	@Test
	public void test() {
	    ListUtilities util = new ListUtilities();
	    
	    Node<String> input = null;
	    Node<String> output = util.reverseOf(input);
	    assertNull(output);
	    
	    input = new Node<>("Mark", new Node<>("Tom", null));
	    output = util.reverseOf(input);
	    assertEquals("Tom", output.getElement());
	    assertEquals("Mark", output.getNext().getElement());
	    assertNull(output.getNext().getNext());
	    //assertNull(output.getNext());
	}
	
	
	@Test
	public void test1_2() {
	    ListUtilities util = new ListUtilities();
	    
	    Node<String> input = null;
	    Node<String> output = util.reverseOf(input);
	    assertNull(output);
	}
	
	@Test
	public void test1_3() {
	    ListUtilities util = new ListUtilities();
	    
	    Node<String> input = new Node<>("Tom", null);
	    Node<String> output = util.reverseOf(input);
	    assertEquals("Tom", output.getElement());
	    assertNull(output.getNext());
	}
	
	
	
	
	
	/*
	@Test
	public void test2() {
	    ListUtilities<String> util = new ListUtilities<>();
	    Node<String> n4 = new Node<>("Lists", null);
	    Node<String> n3 = new Node<>("Linked", n4);
	    Node<String> n2 = new Node<>("Love", n3);
	    Node<String> n1 = new Node<>("I", n2);

	    Node<String> output = util.shiftedToRightBy(n1, 2);
	    assertTrue(output == n3);
	    assertTrue(output.getNext() == n4);
	    assertTrue(output.getNext().getNext() == n1);
	    assertTrue(output.getNext().getNext().getNext() == n2);
	    assertNull(output.getNext().getNext().getNext().getNext());

	    assertTrue(output.getElement().equals("Linked"));
	    assertTrue(output.getNext().getElement().equals("Lists"));
	    assertTrue(output.getNext().getNext().getElement().equals("I"));
	    assertTrue(output.getNext().getNext().getNext().getElement().equals("Love"));
	}
	
	//test for one element
	@Test
	public void test3() {
	    ListUtilities<String> util = new ListUtilities<>();
	    Node<String> n1 = new Node<>("Lists", null);

	    Node<String> output = util.shiftedToRightBy(n1, 2);
	    assertTrue(output == n1);
	    assertTrue(output.getNext()==null);
	}
	
	//test for two elements
	@Test
	public void test4() {
	    ListUtilities<String> util = new ListUtilities<>();
	    Node<String> n4 = new Node<>("Lists", null);
	    Node<String> n3 = new Node<>("Linked", n4);

	    Node<String> output = util.shiftedToRightBy(n3, 3);
	    assertTrue(output == n4);
	    assertTrue(output.getElement().equals("Lists"));
	    assertTrue(output.getNext().getElement().equals("Linked"));
	    assertTrue(output.getNext().getNext() == null);
	}
	
	//test for 0 elements
	@Test
	public void test5() {
	    ListUtilities<String> util = new ListUtilities<>();
	    Node<String> n1 = null;

	    Node<String> output = util.shiftedToRightBy(n1, 3);
	    assertTrue(output == null);
	}
	*/
	
}
