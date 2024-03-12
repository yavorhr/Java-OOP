package easterRaces.validator;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.List;

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

  public static void throwExceptionIfEmptyName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
    }
  }

  public static void throwExceptionIfCarIsNull(Car car) {
    if (car == null) {
      throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
    }
  }

  public static void throwExceptionIfLapsAreBelowOne(int laps) {
    if (laps < 1) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_LAPS);
    }
  }

  public static void throwExceptionIfDriverIsNull(Driver driver) {
    if (driver == null) {
      throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
    }
  }

  public static void throwExceptionIfDriverCannotParticipate(Driver driver) {
    if (!driver.getCanParticipate()) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName()));
    }
  }

  public static void throwExceptionIfDriverAlreadyExistsInTheRace(List<Driver> drivers, Driver driver, String raceName) {
    if (drivers.contains(driver)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_ALREADY_ADDED,
              driver.getName(),
              raceName));

    }
  }
}