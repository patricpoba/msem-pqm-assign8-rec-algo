package exercise8.exceptions;

public class StringException extends Exception {
  public StringException(String message) {
    super(message);
  }

  public StringException(String message, Throwable cause) {
    super(message, cause);
  }
}
