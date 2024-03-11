package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {
  private static final int CUBIC_CENTIMETERS = 5000;

  public MuscleCar(String model, int horsePower) {
    super(model);
    super.setCubicCentimeters(cubicCentimeters);
    this.setHorsePower(horsePower);
  }

  @Override
  public void setHorsePower(int horsePower) {
    if (horsePower < 400 || horsePower > 600) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
    }
  }
}

