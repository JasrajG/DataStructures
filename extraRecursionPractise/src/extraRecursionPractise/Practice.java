package extraRecursionPractise;

import java.util.ArrayList;
import java.util.HashSet;

public class Practice {

	public HashSet<ArrayList<Integer>> makeChange(int[] coins, int target) {
		// TODO Auto-generated method stub
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(coins, target, 0 ,set, list);
		return set;
	}
	
	private void helper(int[] coins, int target, int index, HashSet<ArrayList<Integer>> set, ArrayList<Integer> list) {
		
		if (index == coins.length || target < 0) {
			//do nothing
		}
		else if (target == 0) {
			set.add(list);
		}
		else {
			ArrayList<Integer> list2 = new ArrayList<Integer> (list);
			list2.add(coins[index]);
			helper(coins, target - coins[index], index, set, list2);
			ArrayList<Integer> list3 = new ArrayList<Integer> (list);
			helper(coins, target, index + 1, set, list3);
		}
	}

	public HashSet<ArrayList<Character>> generateParens(int i) {
		
		HashSet<ArrayList<Character>> set = new HashSet<ArrayList<Character>>();
		ArrayList<Character> list = new ArrayList<Character>();
		helper2(i, 0, 0, set, list);
		
		
		return set;
	}
	
	
	private void helper2(int i, int beg, int end, HashSet<ArrayList<Character>> set, ArrayList<Character> list) {
		if (beg==i && end ==i){
			set.add(list);
		}
		else {
			if (beg<i) {
				ArrayList<Character> list2 = new ArrayList<Character>(list);
				list2.add('(');
				helper2(i, beg+1, end, set, list2);
			}
			if (end<beg) {
				ArrayList<Character> list3 = new ArrayList<Character>(list);
				list3.add(')');
				helper2(i, beg, end+1, set, list3);
			}
			}
			
			
		}

	public HashSet<ArrayList<String>> findPaths(int[][] grid) {
		HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		helper3(grid, 0, 0, list, set);
		
		return set;
	}
	
	private void helper3(int[][] grid, int i, int j, ArrayList<String> list,HashSet<ArrayList<String>> set ) {
		
		//cases that will end the current path
		if ( j == grid[0].length || i == grid.length || grid[i][j] == 1) {
			
		}
		
		//successful case
		else if(i==grid.length-1 && j == grid[0].length - 1) {
			String s = "(" + i + "," + j + ")";
			ArrayList<String> list2 = new ArrayList<String>(list);
			list2.add(s);
			set.add(list2);
		}
		
		else {
			String s = "(" + i + "," + j + ")";
			ArrayList<String> list2 = new ArrayList<String>(list);
			list2.add(s);
			helper3(grid, i+1, j, list2, set);
			helper3(grid, i, j+1, list2, set);
			
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	public Node<Integer> partition(Node<Integer> head, int i) {
		// set head
		
		Node<Integer> current = head;
		Node<Integer> prev = null;
		
		if (head.getElement()<i) {
			//do nothing
		}
		else {
			
			
			while(current != null) {
				if (current.getElement() < i) {
					prev.setNext(current.getNext());
					current.setNext(head);
					head = current;
					break;
				}
				prev = current;
				current = current.getNext();
			}
		}
		//case where all greater then or equal to i
		if (current == null){
			return head;
		}
		
		current=head.getNext();
		prev = head;
		Node<Integer> end = head;
		
		while (current != null) {
			
			
			if (current.getElement() < i) {
				
				prev.setNext(current.getNext());
				current.setNext(end.getNext());
				end.setNext(current);
				end=current;
			}
			
			prev = current;
			current = current.getNext();
			
		}
		
		
		return head;
	}

	public void foldList(Node<Integer> head) {
		
		//get size
		int size = 0;
		Node<Integer> current = head;
		while(current != null) {
			size++;
			current = current.getNext();
		}
		
		
		//number of cycles
		int cycles = size/2 + size%2 - 1;
		current=head;
		for (int i=0; i< cycles; i++) {
			//take the very last element and inject it into current
			
			//get second last element in the list
			Node<Integer> secondLast = head;
			while (secondLast.getNext().getNext() != null){
				secondLast=secondLast.getNext();
			}
			//change position of last node
			secondLast.getNext().setNext(current.getNext());
			current.setNext(secondLast.getNext());
			secondLast.setNext(null);
			
			
			
			//skip added element
			current=current.getNext().getNext();
			
		}
		
		
		
		
	}

	public Node<Integer> removeDuplicates(Node<Integer> head) {
		//cycle through original list, if it wasn't seen before, add it to a new list
		Node<Integer> current = head.getNext();
		Node<Integer> prev = head;
		Node<Integer> head2 = new Node<Integer>(head.getElement(),null);
		Node<Integer> current2 =null;
		
	
		while(current != null) {
			
			
			current2=head2;
			while(current2 != null) {
				if (current.getElement().equals(current2.getElement())) {
					prev.setNext(current.getNext());
					
					break;
				}
				current2=current2.getNext();
			}
			
			
			
			if (current2 == null) {
				//add element
				head2.setNext(new Node<Integer>(current.getElement(),head2.getNext() ) );
				prev = current;
				current =current.getNext();
			}
			
			
			else {
				Node<Integer> old_current =current;
				current = prev.getNext();
				old_current.setNext(null);
			}
			
		}
		
		
		return head;
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	

