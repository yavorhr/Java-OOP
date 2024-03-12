package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.races.Race;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

public class ControllerImpl implements Controller {
  Repository<Car> cars;
  Repository<Driver> drivers;
  Repository<Race> races;

  public ControllerImpl() {
    this.cars = new CarRepository();
    this.drivers = new DriverRepository();
    this.races = new RaceRepository();
  }

  @Override
  public String createDriver(String driver) {
    return null;
  }

  @Override
  public String createCar(String type, String model, int horsePower) {
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
