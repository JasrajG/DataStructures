package extraRecursionPractise;



public class Node<E> {
	/*
	 * Do not modify this class. 
	 * When your submission is graded, the same starter version of the Node class will be used,
	 * meaning that if you made any changes to this class, they would be wiped out 
	 * and your submitted classes may just stop compiling.
	 */
	
	private E element;
	private Node<E> next;
	
	/*
	 * Constructor
	 */
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}
	
	/*
	 * Accessors
	 */
	public E getElement() {
		return element;
	} 
	
	public Node<E> getNext() {
		return next;
	}
	
	/*
	 * Mutators
	 */
	public void setElement(E e) {
		element = e;
	}
	
	public void setNext(Node<E> n) {
		next = n;
	} 
}