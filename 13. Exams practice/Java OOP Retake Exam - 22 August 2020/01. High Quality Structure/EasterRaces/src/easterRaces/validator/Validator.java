package easterRaces.validator;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.races.Race;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;

public class Validator {

  // CAR
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

  // DRIVER
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

  // RACE
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

  // REPOSITORIES
  public static void throwExceptionIfDriverAlreadyIsCreated(Collection<Driver> allDrivers, String driver) {
    if (allDrivers.stream().anyMatch(d -> d.getName().equals(driver))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
    }
  }

  public static void throwErrorIfCarModelIsAlreadyAddedToRepository(Collection<Car> cars, String model) {
    if (cars.stream().anyMatch(c -> c.getModel().equals(model))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
    }
  }

  public static void throwErrorIfDriverIsNotExistingInRepository(String driverName, Collection<Driver> drivers) {
    if (drivers.stream().noneMatch(d -> d.getName().equals(driverName))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
    }
  }

  public static void throwErrorIfCarModelIsNotExistingInRepository(String carModel, Collection<Car> cars) {
    if (cars.stream().noneMatch(d -> d.getModel().equals(carModel))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
    }
  }

  public static void throwErrorIfRaceIsNotExistingInRepository(String raceName, Collection<Race> races) {
    if (races.stream().noneMatch(d -> d.getName().equals(raceName))) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
    }
  }
}
