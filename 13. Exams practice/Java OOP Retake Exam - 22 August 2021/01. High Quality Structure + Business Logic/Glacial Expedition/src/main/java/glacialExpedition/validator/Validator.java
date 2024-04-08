package glacialExpedition.validator;

import glacialExpedition.common.ExceptionMessages;

public class Validator {

  public static void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateEnergy(double energy) {
    if (energy < 0) {
      throw new IllegalArgumentException (ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
    }
  }
}
