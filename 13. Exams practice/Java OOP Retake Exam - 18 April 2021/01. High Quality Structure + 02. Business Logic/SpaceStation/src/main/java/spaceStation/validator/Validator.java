package spaceStation.validator;

import spaceStation.common.ExceptionMessages;

public class Validator {
  public static void validateAstronautName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateAstronautOxygen(double oxygen) {
    if (oxygen < 0) {
      throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
    }
  }
}
