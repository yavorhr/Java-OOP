package christmasRaces.entities.cars;

public abstract class BaseCar implements Car {
  private String model;
  private int horsePower;
  private double cubicCentimeters;

  protected BaseCar(String model, int horsePower, double cubicCentimeters) {
    this.model = model;
    this.horsePower = horsePower;
    this.cubicCentimeters = cubicCentimeters;
  }

  @Override
  public String getModel() {
    return this.model;
  }

  @Override
  public int getHorsePower() {
    return this.horsePower;
  }

  @Override
  public double getCubicCentimeters() {
    return this.cubicCentimeters;
  }

  @Override
  public double calculateRacePoints(int laps) {
    return this.cubicCentimeters / this.horsePower * laps;
  }

  protected void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }
}
