package exercise8;

import exercise8.exceptions.EmptyInputException;
import exercise8.exceptions.ManyArgumentsException;
import exercise8.exceptions.NotNumberException;
import exercise8.exceptions.NumberOutOfRangeException;

public class FactorialRec {
	public final static long UPPER_BOUND = 20;

	public static void main(String[] args) {
		try {
			FactorialRec f = new FactorialRec(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public FactorialRec() {
	}

	public FactorialRec(String[] input)
			throws ManyArgumentsException, NotNumberException, NumberOutOfRangeException, EmptyInputException {
		long number;
		// Size Validation Check
		if (input.length == 0) {
			throw new EmptyInputException("You should provide one argument");
		} else if (input.length > 1) {
			throw new ManyArgumentsException("Argument should be only one digit");
		} else {
			try {
				number = Integer.parseInt(input[0]);
			} catch (Exception exception) {
				throw new NotNumberException("Argument must be a numeric value");
			}
			// Range Check
			if (number < 0) {
				throw new NumberOutOfRangeException("Parameter must be a non-negative number");
			}
			// Range Check
			if (number > UPPER_BOUND) {
				throw new NumberOutOfRangeException("Parameter must be a number less or equal to " + UPPER_BOUND);
			} else {
				System.out.println(number + "! = " + factorial(number));
			}
		}
	}

	public long factorial(long n) { // recursive algorithm
		if (n == 0 || n == 1)
			return 1;
		else {
			return n * factorial(n - 1);
		}
	}
}
