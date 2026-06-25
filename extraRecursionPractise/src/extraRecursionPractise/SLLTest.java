package extraRecursionPractise;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class SLLTest {

    // ==========================================================
    // PROBLEM 4: PARTITION SLL TESTS
    // ==========================================================
    @Test
    public void testPartition_Standard() {
        Node<Integer> head = createList(1, 4, 3, 2, 5, 2);
        Set<Node<Integer>> originalNodes = getObjectReferences(head); // Track memory addresses
        Practice p = new Practice(); 
        Node<Integer> newHead = p.partition(head, 3);
        
        List<Integer> expected = Arrays.asList(1, 2, 2, 4, 3, 5);
        assertEquals("Failed to partition correctly", expected, listToValues(newHead));
        assertTrue("JACKIE TRAP: You created new nodes instead of rewiring pointers!", 
                    verifyNoNewNodes(newHead, originalNodes));
    }

    @Test
    public void testPartition_AllGreaterThanX() {
        Node<Integer> head = createList(5, 6, 7, 8);
        Practice p = new Practice(); 
        Node<Integer> newHead = p.partition(head, 3);
        assertEquals(Arrays.asList(5, 6, 7, 8), listToValues(newHead));
    }

    // ==========================================================
    // PROBLEM 5: FOLD / INTERLEAVE SLL TESTS
    // ==========================================================
    @Test
    public void testFoldList_EvenLength() {
        Node<Integer> head = createList(1, 2, 3, 4);
        Set<Node<Integer>> originalNodes = getObjectReferences(head);
        Practice p = new Practice(); 
        p.foldList(head); // In-place modification, void return
        
        List<Integer> expected = Arrays.asList(1, 4, 2, 3);
        assertEquals("Failed on even length list", expected, listToValues(head));
        assertTrue("JACKIE TRAP: Pointer manipulation only! No new nodes.", 
                    verifyNoNewNodes(head, originalNodes));
    }

    @Test
    public void testFoldList_OddLength() {
        Node<Integer> head = createList(1, 2, 3, 4, 5);
        Practice p = new Practice(); 
        p.foldList(head);
        List<Integer> expected = Arrays.asList(1, 5, 2, 4, 3);
        assertEquals("Failed on odd length list", expected, listToValues(head));
    }

    @Test
    public void testFoldList_SizeOneOrTwo() {
        Node<Integer> headOne = createList(1);
        Practice p = new Practice(); 
        p.foldList(headOne);
        assertEquals("Failed on size 1", Arrays.asList(1), listToValues(headOne));

        Node<Integer> headTwo = createList(1, 2); 
        p.foldList(headTwo);
        assertEquals("Failed on size 2", Arrays.asList(1, 2), listToValues(headTwo));
    }

    // ==========================================================
    // PROBLEM 6: REMOVE ALL OCCURRENCES OF DUPLICATES
    // ==========================================================
    @Test
    public void testRemoveDuplicates_Standard() {
        // Original: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node<Integer> head = createList(1, 2, 3, 3, 4, 4, 5);
        Set<Node<Integer>> originalNodes = getObjectReferences(head);
        Practice p = new Practice();
        Node<Integer> newHead = p.removeDuplicates(head);
        
        // Expected: 1 -> 2 -> 5  (3 and 4 are completely deleted)
        List<Integer> expected = Arrays.asList(1, 2,3,4, 5);
        assertEquals("Failed standard duplicate removal", expected, listToValues(newHead));
        assertTrue("Used new nodes instead of deleting references!", 
                    verifyNoNewNodes(newHead, originalNodes));
    }

    @Test
    public void testRemoveDuplicates_DuplicatesAtHead() {
        // Original: 1 -> 1 -> 1 -> 2 -> 3
        Node<Integer> head = createList(1, 1, 1, 2, 3);
        Practice p = new Practice();
        Node<Integer> newHead = p.removeDuplicates(head);
        // Expected: 2 -> 3
        assertEquals("Failed when duplicates are at the very beginning", 
                     Arrays.asList(1, 2, 3), listToValues(newHead));
    }

    @Test
    public void testRemoveDuplicates_AllDuplicates() {
        // Original: 2 -> 2 -> 2 -> 2
        Node<Integer> head = createList(2, 2, 2, 2);
        Practice p = new Practice();
        Node<Integer> newHead = p.removeDuplicates(head);
        // Expected: null (empty list)
        assertEquals("Failed when duplicates are at the very beginning", 
                Arrays.asList(2), listToValues(newHead));
}

    // ==========================================================
    // SLL HELPER METHODS FOR TESTS
    // ==========================================================
    @SafeVarargs
    private final <E> Node<E> createList(E... values) {
        if (values.length == 0) return null;
        Node<E> head = new Node<>(values[0], null);
        Node<E> current = head;
        for (int i = 1; i < values.length; i++) {
            Node<E> newNode = new Node<>(values[i], null);
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }

    private <E> List<E> listToValues(Node<E> head) {
        List<E> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getElement());
            head = head.getNext();
        }
        return list;
    }

    // Tracks exact memory reference locations
    private <E> Set<Node<E>> getObjectReferences(Node<E> head) {
        Set<Node<E>> set = Collections.newSetFromMap(new IdentityHashMap<>());
        while (head != null) {
            set.add(head);
            head = head.getNext();
        }
        return set;
    }

    // Checks if returned list contains ONLY nodes from the original list
    private <E> boolean verifyNoNewNodes(Node<E> head, Set<Node<E>> originalNodes) {
        while (head != null) {
            if (!originalNodes.contains(head)) return false;
            head = head.getNext();
        }
        return true;
    }
}