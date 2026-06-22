package model;

import tests.Node;

public class ListUtilities<E> {

	public Node<E> reverseOf(Node<E> input) {
		
		
		Node<E> target = input;
		Node<E> copy = null;
		while (target != null) {
			copy = new Node<E> (target.getElement(),copy);
			target = target.getNext();
		}
		
		return copy;
	}

	public Node<E> copyOf(Node<E> input) {
		// TODO Auto-generated method stub
		
		//set head
		Node<E> head = null;
		if (input == null) {
			return head;
		}
		else {
			head = new Node<E>(input.getElement(), null);
		}
		Node<E> copy = head;
		input=input.getNext();
		while (input != null) {
			copy.setNext(new Node<E>(input.getElement(), null));
			copy = copy.getNext();
					
			input = input.getNext();
		}
		
		return head;
		
	}

	public Node<E> removeNthFromEnd(Node<E> input, int i) {
		
		//get size
		Node<E> target = input;
		int j;
		for (j = 0; target!= null; j++) {
			target = target.getNext();
		}
		
		Node<E> head = null;
		//special case of removing first element
		if (j == i) {
			head = input.getNext();
			input.setNext(null);
			return head;
		}
		//otherwise head will be the same
		head = input;
		
		target = input;
		int index = j-i;
		
		for (int c=1; c< index; c++) {
			
			target=target.getNext();
		}
		
		Node<E> n = target.getNext();
		target.setNext(n.getNext());
		n.setNext(null);
		
		
		return head;
		
		
	}
	
	
	
	/* public Node<E> copyOf(Node<E> input) {
		Node<E> copy = null; 
		Node<E> currentOfInput = input;
		Node<E> currentOfReverse = null;
		while(currentOfInput != null) { 
			E e = currentOfInput.getElement();
			Node<E> n = new Node<>(e, null); 
			if(copy == null) {
				copy = n;
				currentOfReverse = copy;
			}
			else {
				currentOfReverse.setNext(n);
				currentOfReverse = currentOfReverse.getNext();
			} 
			currentOfInput = currentOfInput.getNext();
		}
		return copy;
	}
	
	public Node<E> reverseOf(Node<E> input) {
		Node<E> reverse = null;
		Node<E> current = input;
		while(current != null) {
			E e = current.getElement();
			Node<E> n = new Node<>(e, null);
			n.setNext(reverse);
			reverse = n;
			current = current.getNext();
		}
		return reverse;
	}
	
	public Node<E> removeNthFromEnd(Node<E> head, int n) {
		int size = 0;
		Node<E> current = head;
		while(current != null) {
			size ++;
			current = current.getNext();
		}
		int indexOfPrev = size - n - 1;
		
		if(indexOfPrev < 0) { // the node to remove is the current head
			Node<E> oldHead = head;
			head = head.getNext();
			oldHead.setNext(null);
		}
		else {
			Node<E> prev = null;
			int i = 0;
			current = head;
			while(i <= indexOfPrev) {
				prev = current;
				current = current.getNext();
				i ++;
			}
			Node<E> nodeToRemove = prev.getNext();
			prev.setNext(nodeToRemove.getNext());
			nodeToRemove.setNext(null);
		}
		
		return head;
	} */
	
	
}