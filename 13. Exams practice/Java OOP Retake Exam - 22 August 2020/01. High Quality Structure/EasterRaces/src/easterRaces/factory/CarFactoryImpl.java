package easterRaces.factory;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;

public class CarFactoryImpl {
  public static Car createCar(String type, String model, int horsePower) {
    Car car = null;

    if (type.equals("Muscle")) {
      car = new MuscleCar(model, horsePower);
    } else if (type.equals("Sports")) {
      car = new SportsCar(model, horsePower);
    } else {
      throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
    }

    return car;
  }
}
