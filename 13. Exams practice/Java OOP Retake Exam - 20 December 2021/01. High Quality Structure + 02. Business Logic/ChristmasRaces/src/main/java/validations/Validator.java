package validations;

import christmasRaces.common.ExceptionMessages;

public class Validator {
  // CAR
  public static void throwExceptionIfInvalidHorsePower(int horsePower, int lowerBound, int upperBound) {
    if (horsePower < lowerBound || horsePower > upperBound) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }
}
