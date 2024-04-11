package easterRaces.entities.cars;

import easterRaces.validator.Validator;

public class MuscleCar extends BaseCar {
  private static final double CUBIC_CENTIMETERS = 5000;
  private static final int MIN_HORSE_POWER = 400;
  private static final int MAX_HORSE_POWER = 600;

  public MuscleCar(String model, int horsePower) {
    super(model, horsePower, CUBIC_CENTIMETERS);
  }

  @Override
  public void setHorsePower(int horsePower) {
    Validator.throwExceptionIfInvalidHorsePower(horsePower, MIN_HORSE_POWER, MAX_HORSE_POWER);
    this.horsePower = horsePower;
  }

  @Override
  public double calculateRacePoints(int laps) {
    return CUBIC_CENTIMETERS / super.getHorsePower() * laps;
  }
}

