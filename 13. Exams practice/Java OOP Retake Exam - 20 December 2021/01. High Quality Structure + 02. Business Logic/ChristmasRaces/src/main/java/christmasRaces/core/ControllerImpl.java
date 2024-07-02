package christmasRaces.core;

import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;
import validations.Validator;

public class ControllerImpl implements Controller {
  private Repository<Car> cars;
  private Repository<Driver> drivers;
  private Repository<Race> races;

  public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
    this.drivers = drivers;
    this.cars = cars;
    this.races = races;
  }

  @Override
  public String createDriver(String driverName) {
    Validator.throwExceptionIfDriverAlreadyIsCreated(this.drivers.getAll(), driverName);
    Driver driver = new DriverImpl(driverName);
    this.drivers.add(driver);

    return String.format(OutputMessages.DRIVER_CREATED, driverName);
  }

  @Override
  public String createCar(String type, String model, int horsePower) {
    Validator.throwErrorIfCarModelIsAlreadyAddedToRepository(this.cars.getAll(), model);

    return null;
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
    return null;
  }

  @Override
  public String createRace(String name, int laps) {
    return null;
  }
}
