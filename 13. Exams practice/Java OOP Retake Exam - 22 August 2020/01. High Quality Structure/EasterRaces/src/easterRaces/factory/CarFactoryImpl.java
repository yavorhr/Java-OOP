package easterRaces.factory;

import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;

public class CarFactoryImpl {

  public static Car createCar(String type, String model, int horsePower) {
    Car car = null;

    if (type.equals("MuscleCar")) {
      car = new MuscleCar(model, horsePower);
    } else if (type.equals("SportsCar")) {
      car = new SportsCar(model, horsePower);
    }
    return car;
  }
}
