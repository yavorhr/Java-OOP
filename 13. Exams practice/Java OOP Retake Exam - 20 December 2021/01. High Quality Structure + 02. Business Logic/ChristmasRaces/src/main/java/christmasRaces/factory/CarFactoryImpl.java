package christmasRaces.factory;
import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;

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
