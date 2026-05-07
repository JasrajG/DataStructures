package recursionPractise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonnaciSequenceTest {

	@Test
	void testError() {
		
		assertAll(
		() -> assertThrows(IllegalArgumentException.class, () -> 
		{	FibonnaciSequence.fibonacci(-1);}      )
		
				);
	}
	
	
	@Test
	void testOutput() {
		assertAll(
		() -> {assertEquals(1, FibonnaciSequence.fibonacci(0), "case 1 failed");},
		() -> assertEquals(1, FibonnaciSequence.fibonacci(1), "case 2 failed"),
		() -> assertEquals(89, FibonnaciSequence.fibonacci(10))
		
		
		
		);
	}
	
	
	
	
	
	@Test
	void testArrRecError() {
		
		assertThrows(IllegalArgumentException.class, () -> 
		
				FibonnaciSequence.fibArr(-1)
				);	
	}
	
	
	
	
	@Test
	void testArrRecOutput() {
		
		assertAll(
				() -> assertEquals(1, FibonnaciSequence.fibArr(0)),
				() -> assertEquals(1, FibonnaciSequence.fibArr(1)),
				() -> assertEquals(89, FibonnaciSequence.fibArr(10))
				
				
				
				);
		
		
		
		
	}

}
