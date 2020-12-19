package exercise8.exceptions;

public class NumberOutOfRangeException extends Exception {
  public NumberOutOfRangeException(String message) {
    super(message);
  }

  public NumberOutOfRangeException(String message, Throwable cause) {
    super(message, cause);
  }
}
