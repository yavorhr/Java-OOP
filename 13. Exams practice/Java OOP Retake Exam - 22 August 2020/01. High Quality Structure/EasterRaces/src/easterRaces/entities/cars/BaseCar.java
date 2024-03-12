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

  public BaseCar(String model, int horsePower) {
    setModel(model);
    this.horsePower = horsePower;
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

  public void setModel(String model) {
    this.model = model;
  }

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }

  public void setCubicCentimeters(double cubicCentimeters) {
    this.cubicCentimeters = cubicCentimeters;
  }

  @Override
  public double calculateRacePoints(int laps) {
    return 0;
  }


}
