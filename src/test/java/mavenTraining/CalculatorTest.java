package mavenTraining;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	
	 private static Calculator calc;

	    @BeforeAll
		public static void initAll() {
	        System.out.println("Initializing resources...");
	    }

	    @BeforeEach
		public void setUp() {
	        calc = new Calculator();
	    }

	    @Nested
	    @DisplayName("Arithmetic operations")
	    class ArithmeticTests {

	        @Test
	        @DisplayName("Testing addition")
	    	public void testAdd() {
	            assertEquals(7, calc.add(5, 2), "Addition failed");
	        }

	        @ParameterizedTest
	        @ValueSource(ints = {1, 2, 3, 5, -3})
	        @DisplayName("Testing multiple subtractions")
	    	public void testSubtract(int arg) {
	            assertEquals(5 - arg, calc.subtract(5, arg), "Subtraction failed with arg: " + arg);
	        }
	    }

	    @Test
	    @DisplayName("Testing multiplication")
		public void testMultiply() {
	        assertEquals(10, calc.multiply(5, 2), "Multiplication failed");
	    }

	    @Test
	    @DisplayName("Testing division")
	    @Timeout(5)
		public void testDivide() {
	        assertEquals(2.5, calc.divide(5, 2), 0.01, "Division failed");
	    }

	    @Test
	    @DisplayName("Testing division by zero")
	    @Tag("critical")
		public void testDivideByZero() {
	        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0), "Expected IllegalArgumentException");
	    }

	    @Test
	    @Disabled("Not implemented yet")
		public void testNotImplemented() {
	        // Test code not implemented yet
	    }

	   
	/* @AfterEach
	public void tearDown() {
	        calc = null;
	    } */

	    @AfterAll
		public static void cleanUpAll() {
	        System.out.println("Cleaning up resources...");
	    }
	}
	
	

