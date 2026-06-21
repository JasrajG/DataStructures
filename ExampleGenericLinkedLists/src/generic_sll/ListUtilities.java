package generic_sll;

public class ListUtilities {

	public Node<String> reverseOf(Node<String> input){
		
		if (input == null) {
			return null;
		}
		else {
			
			
			Node<String> current_dup = new Node<String>(input.getElement(),null);
			Node<String> prev = current_dup;
			Node<String> current = input.getNext();
			
			while (current != null) {
				current_dup = new Node<String>(current.getElement(),prev);
				prev = current_dup;
				current = current.getNext();
			}
			
		
			return current_dup;
		}
	
	
	
	}
		
	
	/*
	public Node<String> reverseOf(Node<String> input) {
	    Node<String> reverse = null;
	    Node<String> currentOfInput = input;
	    Node<String> currentOfReverse = null;

	    while (currentOfInput != null) {
	        String e = currentOfInput.getElement();
	        Node<String> n = new Node<>(e, null);

	        if (reverse == null) {
	            reverse = n;
	            currentOfReverse = reverse;
	        } else {
	            n.setNext(currentOfReverse);
	            currentOfReverse = n;
	        }
	        currentOfInput = currentOfInput.getNext();
	    }
	    return currentOfReverse;
	}
	*/
	/*
	public Node<E> shiftedToRightBy(Node<E> head, int n){
		
		if (head == null) {
			return null;
		}
		Node<E> current = head;
		int size;
		for (size=0; current.getNext() !=null;size++) {
		current = current.getNext();
		}
		size ++;
		Node<E> tail = current; 
		
		n = n%size;
		
		int new_tail_index = (size-n)-1;
		
		
		tail.setNext(head);
		current = head;
		for (int i = 0; i< new_tail_index; i++) {
			current= current.getNext();
		}
		
		Node<E> new_head = current.getNext();
		current.setNext(null);
		return new_head;
		
		
		
		
		
		
	}*/

	
	
}
