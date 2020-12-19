package exercise8.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exercise8.FactorialRec;
import exercise8.exceptions.EmptyInputException;
import exercise8.exceptions.ManyArgumentsException;
import exercise8.exceptions.NotNumberException;
import exercise8.exceptions.NumberOutOfRangeException;

class FactorialRecTest {

	private static FactorialRec factorialRec;

	@BeforeAll
	static void setUp() {
		factorialRec = new FactorialRec();
	}

	@Test
	void factorialZero() {
		long number = 0;
		long result = factorialRec.factorial(number);
		assertEquals(1, result);
	}

	@Test
	void upperLimit() {
		long number = 20;
		long result = factorialRec.factorial(number);
		long expectedResult = 2432902008176640000L;
		assertEquals(expectedResult, result);
	}

	@Test
	void midLimit() {
		long number = 10;
		long result = factorialRec.factorial(number);
		long expectedResult = 3628800;
		assertEquals(expectedResult, result);
	}

	@Test
	void greaterThanUpperLimit() throws NumberOutOfRangeException {
		String[] args = { "25" };
		Exception exception = assertThrows(NumberOutOfRangeException.class, () -> new FactorialRec(args));
		assertEquals("Parameter must be a number less or equal to " + factorialRec.UPPER_BOUND, exception.getMessage());
	}

	@Test
	void lessThanLowerLimit() throws NumberOutOfRangeException {
		String[] args = { "-10" };
		Exception exception = assertThrows(NumberOutOfRangeException.class, () -> new FactorialRec(args));
		assertEquals("Parameter must be a non-negative number", exception.getMessage());
	}

	@Test
	void nullValue() throws EmptyInputException {
		String[] args = {};
		Exception exception = assertThrows(EmptyInputException.class, () -> new FactorialRec(args));
		assertEquals("You should provide one argument", exception.getMessage());
	}

	@Test
	void onlyOneArgumentException() throws ManyArgumentsException {
		String[] args = { "1", "8" };
		Exception exception = assertThrows(ManyArgumentsException.class, () -> new FactorialRec(args));
		assertEquals("Argument should be only one digit", exception.getMessage());
	}

	@Test
	void notNumberException() throws NotNumberException {
		String[] args = { "A" };
		Exception exception = assertThrows(NotNumberException.class, () -> new FactorialRec(args));
		assertEquals("Argument must be a numeric value", exception.getMessage());
	}
}