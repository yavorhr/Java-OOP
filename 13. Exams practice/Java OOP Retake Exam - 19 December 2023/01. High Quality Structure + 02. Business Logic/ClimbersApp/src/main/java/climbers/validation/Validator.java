package climbers.validation;

import climbers.common.ExceptionMessages;

public class Validator {
  public static void validateClimberName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateClimberStrength(double strength) {
    if (strength < 0) {
      throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
    }
  }

  public static void validateMountainName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY);
    }
  }
}
