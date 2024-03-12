package easterRaces.core;

import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.races.Race;
import easterRaces.factory.CarFactoryImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;
import easterRaces.validator.Validator;

public class ControllerImpl implements Controller {
  private Repository<Car> cars;
  private Repository<Driver> drivers;
  private Repository<Race> races;

  public ControllerImpl() {
    this.cars = new CarRepository();
    this.drivers = new DriverRepository();
    this.races = new RaceRepository();
  }

  @Override
  public String createDriver(String name) {
    Validator.throwExceptionIfDriverAlreadyIsCreated(this.drivers.getAll(), name);
    Driver driver = getDriver(name);
    this.drivers.add(driver);

    return String.format(OutputMessages.DRIVER_CREATED, name);
  }

  @Override
  public String createCar(String type, String model, int horsePower) {
    Validator.throwErrorIfCarModelIsAlreadyAddedToRepository(this.cars.getAll(), model);
    Car car = CarFactoryImpl.createCar(type, model, horsePower);

    this.cars.add(car);
    return String.format(OutputMessages.CAR_CREATED, type, model);
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
    return
  }

  @Override
  public String createRace(String name, int laps) {
    return null;
  }

  // helpers

  private Driver getDriver(String name) {
    return this.drivers.getAll().stream()
            .filter(d -> d.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
