import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSumFrom1ThroughN {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass executing");
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass executing");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp executing");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown executing");
	}

	@Test
	void testSumFrom1ThroughN_Nis1() {
		int actualResult = MathMethods.sumFrom1ThroughN(1);
		assertEquals(1, actualResult);
		//fail("Not yet implemented");
	}
	
	@Test
	void testSumFrom1ThroughN_Nis2() {
		int actualResult = MathMethods.sumFrom1ThroughN(2);
		assertEquals(3, actualResult);
		//fail("Not yet implemented");
	}

}
