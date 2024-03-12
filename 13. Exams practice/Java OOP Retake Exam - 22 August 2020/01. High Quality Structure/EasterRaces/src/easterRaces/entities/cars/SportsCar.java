package easterRaces.entities.cars;
import easterRaces.validator.Validator;

public class SportsCar extends BaseCar {
  private static final double CUBIC_CENTIMETERS = 3000;
  private static final int MIN_HORSE_POWER = 250;
  private static final int MAX_HORSE_POWER = 450;

  public SportsCar(String model, int horsePower) {
    super(model, CUBIC_CENTIMETERS);
    this.setHorsePower(horsePower);
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
