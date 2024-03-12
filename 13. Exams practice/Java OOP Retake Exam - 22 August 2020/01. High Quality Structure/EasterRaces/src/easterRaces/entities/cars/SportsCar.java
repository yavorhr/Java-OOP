package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {
  private static final int CUBIC_CENTIMETERS = 3000;

  public SportsCar(String model, int horsePower) {
    super(model, horsePower, CUBIC_CENTIMETERS);
  }

  @Override
  public void setHorsePower(int horsePower) {
    if (horsePower < 400 || horsePower > 600) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }
}
