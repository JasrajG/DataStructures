package model;

import tests.Node;

public class ListUtilities {

	public Node<String> getAllPrefixes(Node<Integer> input, int i, int j) {
		
		
		Node<Integer> current = null;
		Node<String> element = null;
		
		
		
		for (int limit = j; limit >= i ; limit --)	{
			
			current = input;
			String s = "[" + current.getElement();
			current = current.getNext();
			
			for (int c=2; c<= limit;c++) {
				s = s + ", " + current.getElement();
				current = current.getNext();
			}
			s = s + "]";
			
			element = new Node<String>(s,element);
			System.out.println(s);
			
		
		}
		
		
		return element;
		
	}

	
	
	

	
	public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {
		
			Node<Integer> head = new Node<Integer> (null, null);
			
			
			
			
			
			if (leftChain == null && rightChain == null) {
				return null;
			}
			
			else if (leftChain != null && rightChain == null) {
				head.setElement(leftChain.getElement());
				leftChain = leftChain.getNext();
			}
			else if (leftChain == null && rightChain != null) {
				head.setElement(rightChain.getElement());
				rightChain = rightChain.getNext();
			}
			else if (leftChain.getElement() <= rightChain.getElement()) {
				head.setElement(leftChain.getElement());
				leftChain = leftChain.getNext();
			}
			else {
				head.setElement(rightChain.getElement());
				rightChain = rightChain.getNext();
			}
			
			
			
			Node<Integer> prev = head;
			Node<Integer> current = null;
			
			while (leftChain != null || rightChain != null) {
				
				
				if (leftChain != null && rightChain == null) {
					current = new Node<Integer>(leftChain.getElement(), null);
					prev.setNext(current);
					leftChain = leftChain.getNext();
				}
				else if (leftChain == null && rightChain != null) {
					current = new Node<Integer>(rightChain.getElement(), null);
					prev.setNext(current);
					rightChain = rightChain.getNext();
				}
				else if (leftChain.getElement() <= rightChain.getElement()) {
					current = new Node<Integer>(leftChain.getElement(), null);
					prev.setNext(current);
					leftChain = leftChain.getNext();
				}
				else {
					current = new Node<Integer>(rightChain.getElement(), null);
					prev.setNext(current);
					rightChain = rightChain.getNext();
				}
				
				prev = current;
				
			}
		
		return head;
	}

	
	
	
	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int i, int j, int k, int l) {
		
		int c = i;
		int fib_counter = 0;
		int counter = 1;
		Node<Integer> head = null;
		
		if(c <= (j*(k-1)) + i) {
		head = new Node<Integer>(c ,null);
		c += j;
		}
		else if(fib_counter < l) {
			head = new Node<Integer>(1 ,null);
			fib_counter++;
		}
		else {
			return null;
		}
		
		counter ++;
		Node<Integer> prev =head;
		Node<Integer> current = null;
		int fib1=1;
		int fib2=0;
		
		while (c <= (j*(k-1)) + i   &&   fib_counter < l ) {
			
			if (counter%2 == 1) {
				current = new Node<Integer>(c,null);
				prev.setNext(current);
				c += j;
				prev = current;
				counter++;
			}
			
			else {
				current = new Node<Integer>(fib1 + fib2 ,null);
				prev.setNext(current);
				fib_counter++;
				prev = current;
				counter++;
				if (fib_counter%2 == 0) {
					fib2 = fib1+fib2;
				}
				else {
					fib1 = fib1+fib2;
				}
				
			}
			
		}
		
		while (c <= (j*(k-1)) + i) {
			current = new Node<Integer>(c,null);
			prev.setNext(current);
			c += j;
			prev = current;
		}
		
		while (fib_counter < l) {
			current = new Node<Integer>(fib1 + fib2 ,null);
			prev.setNext(current);
			fib_counter++;
			prev = current;
			counter++;
			if (fib_counter%2 == 0) {
				fib2 = fib1+fib2;
			}
			else {
				fib1 = fib1+fib2;
			}
			
		}
		
		
		
		
		return head;
	}

	
	
	
	
	
	
	
	
	
	
	
	public Node<String> getGroupedStrings(Node<String> input, int m, int n) {
		
		if (input == null) {
			return null;
		}
		
		Node<String> target = input;
		Node<String> head = null;
		
		//set head
		while (target != null && head == null) {
			
			if (target.getElement().length() < m) {
				
				head = new Node<String>(target.getElement(),null);
			}
			
			target = target.getNext();
			
		}
		
		target = input;
		
		while (target != null && head == null) {
			
			if (m <= target.getElement().length() && target.getElement().length() < n) {
				head = new Node<String>(target.getElement(),null);
			}
			
			target = target.getNext();
			
		}
		
		
		target = input;
		
		while (target != null && head == null) {
			
			if (target.getElement().length() >= n) {
				head = new Node<String>(target.getElement(),null);
			}
			
			target = target.getNext();
			
		}
		
		
		//now we will actually create the list
		target = input;
		Node<String> prev = head;
		Node<String> current = null;
		
	while (target != null) {
			
			if (target.getElement().length() < m) {
				
				current = new Node<String>(target.getElement(),null);
				prev.setNext(current);
				prev = current;
			}
			
			target = target.getNext();
			
		}
		
		target = input;
		
		while (target != null) {
			
			if (m <= target.getElement().length() && target.getElement().length() < n) {
				current = new Node<String>(target.getElement(),null);
				prev.setNext(current);
				prev = current;
			}
			
			target = target.getNext();
			
		}
		
		
		target = input;
		
		while (target != null) {
			
			if (target.getElement().length() >= n) {
				current = new Node<String>(target.getElement(),null);
				prev.setNext(current);
				prev = current;
			}
			
			target = target.getNext();
			
		}
		
		
		//we counted head twice, lets get rid of the extra
		
		Node<String> repeat = head.getNext();
		head.setNext(repeat.getNext());
		repeat.setNext(null);
		
		
		
		
		return head;
	}

	
	
}
