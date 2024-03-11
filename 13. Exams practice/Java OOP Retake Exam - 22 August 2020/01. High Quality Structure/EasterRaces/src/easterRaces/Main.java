package easterRaces;

import easterRaces.core.EngineImpl;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Car> motorcycleRepository = null; // TODO: new CarRepository<>();
        Repository<Race> raceRepository = null; // TODO: new RaceRepository<>();
        Repository<Driver> riderRepository = null; // TODO: new DriverRepository<>();

        Controller controller = null; // TODO: new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
