package football.Validator;

import football.common.ConstantMessages;

public class Validator {

  public static void validateIfCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
    }
  }


}
