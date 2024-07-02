package validations;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;

public class Validator {
  // CAR
  public static void throwExceptionIfInvalidHorsePower(int horsePower, int lowerBound, int upperBound) {
    if (horsePower < lowerBound || horsePower > upperBound) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }

  public static void throwExceptionIfCarIsNull(Car car) {
    if (car == null) {
      throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
    }
  }
}
