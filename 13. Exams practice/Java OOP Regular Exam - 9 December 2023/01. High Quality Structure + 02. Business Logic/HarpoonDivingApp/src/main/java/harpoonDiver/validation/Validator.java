package harpoonDiver.validation;

import harpoonDiver.common.ExceptionMessages;

public class Validator {
  public static void validateSiteName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateDiverName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateDiversOxygen(double oxygen) {
    if (oxygen < 0) {
      throw new IllegalArgumentException (ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
    }
  }
}
