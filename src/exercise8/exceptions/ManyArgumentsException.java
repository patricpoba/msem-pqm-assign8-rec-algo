package exercise8.exceptions;

public class ManyArgumentsException extends Exception {
  public ManyArgumentsException(String message) {
    super(message);
  }

  public ManyArgumentsException(String message, Throwable cause) {
    super(message, cause);
  }
}
