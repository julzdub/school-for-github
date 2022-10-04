import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestFactorial {

	@Test
	void testFactorial_NisNegative_ExceptionExpected() {
	 
	  assertThrows(IllegalArgumentException.class, () -> {
	    MathMethods.factorial(-1);
	  });
	 
	}
	
	@Test
	void testFactorial_Nis3() {
		assertEquals(6, MathMethods.factorial(3));
	}

}
