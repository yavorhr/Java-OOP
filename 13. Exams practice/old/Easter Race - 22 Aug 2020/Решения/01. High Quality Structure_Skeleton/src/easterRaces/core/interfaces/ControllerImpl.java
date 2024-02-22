package easterRaces.core.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = new CarRepository<>();
        this.driverRepository = new DriverRepository<>();
        this.raceRepository = new RaceRepository<>();
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }

        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        } else {
            carRepository.add(car);

            if (car == null) {
                return null;
            }

            return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
        }
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) == null) {
            Driver newDriver = new DriverImpl(driver);
            driverRepository.add(newDriver);
            return String.format(DRIVER_CREATED, driver);
        }

        throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver currentDriver = driverRepository.getByName(driverName);
        if (currentDriver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car currentCar = carRepository.getByName(carModel);
        if (currentCar == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        currentDriver.addCar(currentCar);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race currentRace = raceRepository.getByName(raceName);
        if (currentRace == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver currentDriver = driverRepository.getByName(driverName);
        if (currentDriver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        currentRace.addDriver(currentDriver);
        return String.format(DRIVER_ADDED, driverName, raceName);

    }

    @Override
    public String createRace(String name, int laps) {
        Race currentRace = new RaceImpl(name, laps);
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        } else {
            raceRepository.add(currentRace);
            return String.format(RACE_CREATED, name);
        }
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        int laps = race.getLaps();
        Collection<Driver> drivers = race.getDrivers();
        List<Driver> collect = drivers.stream().sorted((d1, d2) ->
                Double.compare(d2.getCar().calculateRacePoints(laps), d1.getCar().calculateRacePoints(laps))

        ).limit(3).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION, collect.get(0).getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, collect.get(1).getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, collect.get(2).getName(), raceName));
        return sb.toString();
    }
}



