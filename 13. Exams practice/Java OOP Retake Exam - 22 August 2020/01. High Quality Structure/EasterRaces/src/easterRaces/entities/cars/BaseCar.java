package easterRaces.entities.cars;

public abstract class BaseCar implements Car {
  String model;
  int horsePower;
  double cubicCentimeters;

  public BaseCar(String model, int horsePower, double cubicCentimeters) {
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
}
