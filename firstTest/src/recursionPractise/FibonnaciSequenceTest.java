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

}
