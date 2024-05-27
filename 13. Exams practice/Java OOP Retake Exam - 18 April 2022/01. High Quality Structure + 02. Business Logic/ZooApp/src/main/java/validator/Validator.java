package validator;

import zoo.common.ExceptionMessages;

public class Validator {

  public static void validateCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
    }
  }
}
