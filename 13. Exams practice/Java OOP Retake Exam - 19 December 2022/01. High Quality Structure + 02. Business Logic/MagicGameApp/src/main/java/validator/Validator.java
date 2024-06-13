package validator;

import magicGame.common.ExceptionMessages;

public class Validator {
  public void validateMagicName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
    }
  }
}
