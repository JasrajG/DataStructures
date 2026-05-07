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

}
