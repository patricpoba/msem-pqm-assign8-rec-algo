package exercise8.exceptions;

public class EmptyInputException extends Exception {
  public EmptyInputException(String message) {
    super(message);
  }

  public EmptyInputException(String message, Throwable cause) {
    super(message, cause);
  }
}
