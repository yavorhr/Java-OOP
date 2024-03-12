package easterRaces.validator;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;

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

  public static void throwExceptionIfCarIsNull(Car car) {
    if (car == null) {
      throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
    }
  }

}
