package fairyShop.validator;

import fairyShop.common.ExceptionMessages;

public class Validator {
  public static void validateHelperName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateInstrumentPower(int value) {
    if (value < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
    }
  }

  public static void validatePresentName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validatePresentEnergy(int value) {
    if (value < 0) {
      throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
    }
  }
}
