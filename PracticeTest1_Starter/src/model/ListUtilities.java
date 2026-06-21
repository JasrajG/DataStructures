package model;

import tests.Node;

public class ListUtilities<E> {

	public Node<E> reverseOf(Node<E> input) {
		
		
		if (input == null) {
			return null;
		}
		
		Node<E> clone = input;
		Node<E> prev = null;
		Node<E> current = null;
		
		while (clone != null) {
			current = new Node<E>(clone.getElement(),prev);
			prev = current;
			clone = clone.getNext();
		}
		
		return current;
	}

	public Node<E> copyOf(Node<E> input) {
		
		if (input == null) {
			return null;
		}
		
		//set up head
		
		Node<E> clone = input;
		Node<E> head = new Node<E>(clone.getElement(),null);
		Node<E> current = head;
		clone=clone.getNext();
		
		while (clone != null) {
			current.setNext(new Node<E>(clone.getElement() ,null));
			current = current.getNext();
			clone = clone.getNext();
		}
		
		return head;
	}

	public Node<E> removeNthFromEnd(Node<E> input, int i) {
		
		//null case
		if (input == null) {
			return null;
		}
		int size;
		Node<E> current = input;
		
		for (size=0; current != null; size++ ) {
			current = current.getNext();
		}
		if (i == size) {
			current = input;
			input = input.getNext();
			current.setNext(null);
			
		}
		else {
			
			current=input; //reset
			for (int j=0; j<size-(i+1);j++) {
				current=current.getNext();
			}
			
			Node<E> removed = current.getNext();
			current.setNext(removed.getNext());
			removed.setNext(null);
		}
		return input;
	}

}
