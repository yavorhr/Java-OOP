public class InvalidNumberInputException extends RuntimeException {
  public InvalidNumberInputException(String message) {
    super(message);
  }
  public InvalidNumberInputException(String message, Exception cause) {
    super(message, cause);
  }

}
