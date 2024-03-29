package easterRaces;

import easterRaces.core.ControllerImpl;
import easterRaces.core.EngineImpl;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.races.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Repository<Car> carRepository = new CarRepository();
    Repository<Driver> driverRepository = new DriverRepository();
    Repository<Race> raceRepository = new RaceRepository();

    Controller controller = new ControllerImpl(carRepository,driverRepository,raceRepository);

    ConsoleReader reader = new ConsoleReader();
    ConsoleWriter writer = new ConsoleWriter();

    EngineImpl engine = new EngineImpl(reader, writer, controller);
    engine.run();
  }
}
