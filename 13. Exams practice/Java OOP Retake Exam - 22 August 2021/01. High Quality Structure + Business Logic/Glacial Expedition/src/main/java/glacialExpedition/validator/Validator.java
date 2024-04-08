package glacialExpedition.validator;

import glacialExpedition.common.ExceptionMessages;

public class Validator {

  private void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
    }
  }

  private void validateEnergy(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
    }
  }
}
