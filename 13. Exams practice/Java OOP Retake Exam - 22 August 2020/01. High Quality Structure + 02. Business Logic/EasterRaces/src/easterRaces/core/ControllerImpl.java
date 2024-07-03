package easterRaces.core;

import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.races.Race;
import easterRaces.entities.races.RaceImpl;
import easterRaces.factory.CarFactoryImpl;
import easterRaces.repositories.interfaces.Repository;
import easterRaces.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private Repository<Car> cars;
  private Repository<Driver> drivers;
  private Repository<Race> races;

  public ControllerImpl(Repository<Car> cars, Repository<Driver> drivers, Repository<Race> races) {
    this.cars = cars;
    this.drivers = drivers;
    this.races = races;
  }

  @Override
  public String createDriver(String name) {
    Validator.throwExceptionIfDriverAlreadyIsCreated(this.drivers.getAll(), name);

    Driver driver = new DriverImpl(name);
    this.drivers.add(driver);

    return String.format(OutputMessages.DRIVER_CREATED, name);
  }

  @Override
  public String createCar(String type, String model, int horsePower) {
    Validator.throwErrorIfCarModelIsAlreadyAddedToRepository(this.cars.getAll(), model);

    Car car = CarFactoryImpl.createCar(type, model, horsePower);
    this.cars.add(car);

    return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
  }

  @Override
  public String addCarToDriver(String driverName, String carModel) {
    Validator.throwErrorIfDriverIsNotExistingInRepository(driverName, this.drivers.getAll());
    Validator.throwErrorIfCarModelIsNotExistingInRepository(carModel, this.cars.getAll());

    Car car = this.cars.getByName(carModel);
    this.drivers.getByName(driverName).addCar(car);

    return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
  }

  @Override
  public String addDriverToRace(String raceName, String driverName) {
    Validator.throwErrorIfRaceIsNotExistingInRepository(raceName, this.races.getAll());
    Validator.throwErrorIfDriverIsNotExistingInRepository(driverName, this.drivers.getAll());

    Driver driver = this.drivers.getByName(driverName);
    races.getByName(raceName).addDriver(driver);

    return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
  }

  @Override
  public String startRace(String raceName) {
    Validator.throwErrorIfRaceIsNotExistingInRepository(raceName, this.races.getAll());

    Race race = this.races.getByName(raceName);

    List<Driver> fastestDrivers =
            race.getDrivers().stream().sorted((d1, d2) ->
                    Double.compare(
                            d2.getCar().calculateRacePoints(race.getLaps()),
                            d1.getCar().calculateRacePoints(race.getLaps())))
                    .limit(3)
                    .collect(Collectors.toList());

    fastestDrivers.get(0).winRace();
    Validator.throwErrorIfDriversAreLessThan3(fastestDrivers, raceName);

    return result(fastestDrivers, raceName);
  }

  @Override
  public String createRace(String raceName, int laps) {
    Validator.throwErrorIfRaceIsAlreadyExistingInRepository(raceName, this.races.getAll());

    Race race = new RaceImpl(raceName, laps);
    this.races.add(race);

    return String.format(OutputMessages.RACE_CREATED, raceName);
  }

  // Helpers
  private String result(List<Driver> fastestDrivers, String raceName) {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, fastestDrivers.get(0).getName(), raceName)).append(System.lineSeparator());
    sb.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, fastestDrivers.get(1).getName(), raceName)).append(System.lineSeparator());
    sb.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, fastestDrivers.get(2).getName(), raceName)).append(System.lineSeparator());

    return sb.toString().trim();
  }
}
