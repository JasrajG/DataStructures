package extraRecursionPractise;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class RecursionSLLTest {

    // ==========================================================
    // PROBLEM 1: COIN CHANGE TESTS
    // ==========================================================
    @Test
    public void testMakeChange_Standard() {
        int[] coins = {2, 3, 6, 7};
        Practice p = new Practice();
        HashSet<ArrayList<Integer>> actual = p.makeChange(coins, 7);
        
        HashSet<ArrayList<Integer>> expected = new HashSet<>();
        expected.add(new ArrayList<>(Arrays.asList(7)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        
        // Note: Arrays.asList returns an ArrayList-like structure, 
        // we wrap it in new ArrayList<>() to match your return type exactly.
        assertEquals("Failed standard coin combinations", expected, actual);
    }

    @Test
    public void testMakeChange_NoSolution() {
        int[] coins = {2, 4, 6};
        Practice p = new Practice();
        HashSet<ArrayList<Integer>> actual = p.makeChange(coins, 7);
        // Should return an empty set, NOT null!
        assertNotNull("Should not return null", actual);
        assertTrue("Set should be empty for impossible targets", actual.isEmpty());
    }
    
    @Test
    public void testMakeChange_ZeroTarget() {
        int[] coins = {1, 2, 3};
        Practice p = new Practice();
        HashSet<ArrayList<Integer>> actual = p.makeChange(coins, 0);
        // Base case trap: Target 0 means exactly ONE combination: the empty combination.
        assertEquals("Target 0 should result in one empty ArrayList", 1, actual.size());
        assertTrue("The list inside should be empty", actual.iterator().next().isEmpty());
    }

    // ==========================================================
    // PROBLEM 2: VALID PARENTHESES TESTS
    // ==========================================================
    @Test
    public void testGenerateParens_SizeOne() {
    	Practice p = new Practice();
        HashSet<ArrayList<Character>> actual = p.generateParens(1);
        HashSet<ArrayList<Character>> expected = new HashSet<>();
        expected.add(new ArrayList<>(Arrays.asList('(', ')')));
        assertEquals("Failed to generate correct parens for n=1", expected, actual);
    }

    @Test
    public void testGenerateParens_SizeThree() {
        // Jackie loves testing n=3 because it has exactly 5 combinations.
    	Practice p = new Practice();
        HashSet<ArrayList<Character>> actual = p.generateParens(3);
        assertEquals("n=3 should have exactly 5 valid combinations", 5, actual.size());
        
        // Check for specific valid combo presence
        ArrayList<Character> combo1 = new ArrayList<>(Arrays.asList('(', '(', ')', '(', ')', ')'));
        ArrayList<Character> combo2 = new ArrayList<>(Arrays.asList('(', '(', '(', ')', ')', ')'));
        assertTrue("Missing combination (()())", actual.contains(combo1));
        assertTrue("Missing combination ((()))", actual.contains(combo2));
    }

    // ==========================================================
    // PROBLEM 3: ISLAND PATHS TESTS
    // ==========================================================
    @Test
    public void testFindPaths_StandardGrid() {
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        Practice p = new Practice();
        HashSet<ArrayList<String>> actual = p.findPaths(grid);
        HashSet<ArrayList<String>> expected = new HashSet<>();
        expected.add(new ArrayList<>(Arrays.asList("(0,0)", "(0,1)", "(1,1)")));
        expected.add(new ArrayList<>(Arrays.asList("(0,0)", "(1,0)", "(1,1)")));
        
        assertEquals("Failed to find all paths in 2x2 clear grid", expected, actual);
    }

    @Test
    public void testFindPaths_WithObstacle() {
        int[][] grid = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        Practice p = new Practice();
        HashSet<ArrayList<String>> actual = p.findPaths(grid);
        
        // You are absolutely right, there is only 1 valid path!
        assertEquals("Obstacles should restrict paths", 1, actual.size());
        
        // Let's assert the exact path to be perfectly thorough
        ArrayList<String> expectedPath = new ArrayList<>(
            Arrays.asList("(0,0)", "(1,0)", "(1,1)", "(1,2)", "(2,2)")
        );
        assertTrue("Should contain the only valid path", actual.contains(expectedPath));
    }

    @Test
    public void testFindPaths_BlockedEnd() {
        int[][] grid = {
            {0, 0},
            {0, 1} // End is an obstacle!
        };
        Practice p = new Practice();
        HashSet<ArrayList<String>> actual = p.findPaths(grid);
        assertTrue("If the end is blocked, should return empty set", actual.isEmpty());
    }


    }
