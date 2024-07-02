package validations;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.List;

public class Validator {
  // CAR
  public static void throwExceptionIfInvalidHorsePower(int horsePower, int lowerBound, int upperBound) {
    if (horsePower < lowerBound || horsePower > upperBound) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }

  public static void throwExceptionIfLapsAreBelowOne(int laps) {
    if (laps < 1) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_LAPS);
    }
  }

  public static void throwExceptionIfEmptyName(String name) {
    if (name == null || name.trim().isEmpty() || name.length() < 5) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
    }
  }

  public static void throwExceptionIfCarIsNull(Car car) {
    if (car == null) {
      throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
    }
  }


  // Driver
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

  // REPOSITORIES
  public static void throwExceptionIfDriverAlreadyIsCreated(Collection<Driver> allDrivers, String driver) {
    if (allDrivers.stream().anyMatch(d -> d.getName().equals(driver))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
    }
  }
}
