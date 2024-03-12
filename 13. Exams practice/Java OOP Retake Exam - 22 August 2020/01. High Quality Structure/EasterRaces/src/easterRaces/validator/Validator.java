package easterRaces.validator;

import easterRaces.common.ExceptionMessages;

public class Validator {

  public static void throwExceptionIfInvalidHorsePower(int horsePower, int upperBound, int lowerBound) {
    if (horsePower < lowerBound || horsePower > upperBound) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }

  public static void throwExceptionIfInvalidModel(String model) {
    if (model == null || model.trim().isEmpty()) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, 4));
    }
  }
}
