package recursionPractise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonnaciSequenceTest {

	@Test
	void testError() {
		
		
		assertThrows(IllegalArgumentException.class, () -> 
		{
			
			FibonnaciSequence.fibonacci(-1);
		}
				);
		
		
	}
	
	
	@Test
	void testOutput() {
		assertAll(
		() -> assertEquals(FibonnaciSequence.fibonacci(0), 1),
		() -> assertEquals(FibonnaciSequence.fibonacci(1), 1),
		() -> assertEquals(FibonnaciSequence.fibonacci(10), 89)
		
		
		
		);
	}

}
