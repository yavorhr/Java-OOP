package christmasRaces.entities.cars;


public class SportsCar extends BaseCar {
  private static final double CUBIC_CM = 3000;
  private static final int MIN_HORSE_POWER = 250;
  private static final int MAX_HORSE_POWER = 450;

  public SportsCar(String model, int horsePower) {
    super(model, horsePower, CUBIC_CM);
  }

  @Override
  protected void setHorsePower(int horsePower) {
    super.setHorsePower(horsePower);
  }
}
