package firstTest;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/*
 * For the task(s) related to recursion, you are required to use HashSet and ArrayList.
 * Tests here serve as reminders of the basic usage of these two Java library classes. 
 */

public class TestSetAndList {
    @Test
    public void testAddToList() {
        List<String> vowels = new ArrayList<>();

        vowels.add("A"); // [A]
        vowels.add("E"); // [A, E]
        vowels.add("U"); // [A, E, U]

        assertEquals(Arrays.asList("A", "E", "U"), vowels); // [A, E, U]
        assertTrue(vowels.contains("A"));


        vowels.add(2, "I"); // [A, E, I, U]
        vowels.add(3, "O"); // [A, E, I, O, U]

        assertEquals(Arrays.asList("A", "E", "I", "O", "U"), vowels); // [A, E, I, O, U]
        assertEquals(5, vowels.size());
    }

    @Test
    public void testRemoveFromList() {
        List<String> vowels = new ArrayList<>();

        vowels.add("A"); // [A]
        vowels.add("E"); // [A, E]
        vowels.add("U"); // [A, E, U]

        assertEquals(Arrays.asList("A", "E", "U"), vowels); // [A, E, U]

        vowels.add(2, "I"); // [A, E, I, U]
        vowels.add(3, "O"); // [A, E, I, O, U]

        assertEquals(Arrays.asList("A", "E", "I", "O", "U"), vowels); // [A, E, I, O, U]

        vowels.remove(0); // [E, I, O, U]
        vowels.remove("U"); // [E, I, O]


        assertEquals(Arrays.asList("E", "I", "O"), vowels); // [E, I, O]
        assertTrue(vowels.contains("E"));

        assertEquals(3, vowels.size());

    }

    @Test
    public void testCreateCopyOfList() {
        List<String> vowels = Arrays.asList("A", "I", "E", "O", "U");
        List<String> vowelsCopy = new ArrayList<>(vowels);

        assertEquals(vowels, vowelsCopy);
        assertEquals(vowels.size(), vowelsCopy.size());
    }

    @Test
    public void testAddToSet() {
        Set<String> vowels = new HashSet<>();

        vowels.add("A"); // {A}
        vowels.add("E"); // {A, E}
        vowels.add("U"); // {A, E, U}

        assertEquals(new HashSet<>(Arrays.asList("A", "E", "U")), vowels);
        assertEquals(3, vowels.size());
        assertTrue(vowels.contains("A"));

    }

    @Test
    public void testRemoveFromSet() {
        Set<String> vowels = new HashSet<>();

        vowels.add("A"); // {A}
        vowels.add("E"); // {A, E}
        vowels.add("U"); // {A, E, U}

        assertEquals(new HashSet<>(Arrays.asList("A", "E", "U")), vowels);

        vowels.remove("U"); // [A, E]

        assertEquals(new HashSet<>(Arrays.asList("A", "E")), vowels);
        assertEquals(2, vowels.size());
    }

    @Test
    public void testAddAllToSet() {
        Set<List<String>> vowels = new HashSet<>();

        vowels.addAll(Arrays.asList(Arrays.asList("A"), Arrays.asList("E")));
        /**
         * {
         *  [A],
         *  [E]
         * }
         */
        assertEquals(new HashSet<>(Arrays.asList(Arrays.asList("A"), Arrays.asList("E"))), vowels);
        assertEquals(2, vowels.size());
        assertTrue(vowels.contains(Arrays.asList("A")));

    }

    @Test
    public void testAddAllListToSet() {
        Set<Set<String>> vowels = new HashSet<>();

        Set<String> otherSet = new HashSet<>(Arrays.asList("A", "E"));

        vowels.add(otherSet);
        /**
         * {
         *  {A, E}
         * }
         */

        Set<Set<String>> expected = new HashSet<>(Arrays.asList(new HashSet<>(Arrays.asList("A", "E"))));
        assertEquals(expected, vowels);
        assertEquals(1, vowels.size());
        assertTrue(vowels.contains(new HashSet<>(Arrays.asList("A", "E"))));

    }

    @Test
    public void testAddAllToList() {
        List<List<String>> vowels = new ArrayList<>();

        
        vowels.addAll(Arrays.asList(Arrays.asList("A", "E")));
        /**
         * [
         *  [A, E]
         * ]
         */
        assertEquals(Arrays.asList(Arrays.asList("A", "E")), vowels);
        assertEquals(1, vowels.size());

        assertTrue(vowels.contains(Arrays.asList("A", "E")));
    }
}