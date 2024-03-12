package easterRaces.core;

import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.races.Race;
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

  }

  @Override
  public String addCarToDriver(String driverName, String carModel) {
    return null;
  }

  @Override
  public String addDriverToRace(String raceName, String driverName) {
    return null;
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
