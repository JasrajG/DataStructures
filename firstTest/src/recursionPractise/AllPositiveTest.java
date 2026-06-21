package recursionPractise;



import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/*
 * For the task(s) related to recursion, you are required to use HashSet and ArrayList.
 * Tests here serve as reminders of the basic usage of these two Java library classes. 
 */

public class AllPositiveTest {
    @Test
    public void test_1() {
        
    	AllPositive l = new AllPositive();
    	int [] arr = {};
    	assertTrue(l.all_pos(arr));
    	

    }
    
    
    @Test
    public void test_2() {
        
    	AllPositive l = new AllPositive();
    	int [] arr = {3,4,5,-3};
    	assertFalse(l.all_pos(arr));
    	

    }
    @Test
    public void test_3() {
        
    	AllPositive l = new AllPositive();
    	int [] arr = {3,4,5};
    	assertTrue(l.all_pos(arr));
    	

    }
    @Test
    public void test_4() {
        
    	AllPositive l = new AllPositive();
    	int [] arr = {3};
    	assertTrue(l.all_pos(arr));
    	

    }
    
    
    
}