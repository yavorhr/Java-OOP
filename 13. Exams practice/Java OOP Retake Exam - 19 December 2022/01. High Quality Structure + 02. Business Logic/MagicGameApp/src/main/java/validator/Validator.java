package validator;

import magicGame.common.ExceptionMessages;

public class Validator {
  public static void validateMagicName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
    }
  }

  public static void validateBulletsCount(int count) {
    if (count < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
    }
  }

}
