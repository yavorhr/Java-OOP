package easterRaces.entities.cars;

import easterRaces.validator.Validator;

public abstract class BaseCar implements Car {
  String model;
  int horsePower;
  double cubicCentimeters;

  public BaseCar(String model, int horsePower, double cubicCentimeters) {
    this.setModel(model);
    this.horsePower = horsePower;
    this.cubicCentimeters = cubicCentimeters;
  }

  public BaseCar(String model, double cubicCentimeters) {
    this.setModel(model);
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

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }

  public void setCubicCentimeters(double cubicCentimeters) {
    this.cubicCentimeters = cubicCentimeters;
  }

  private void setModel(String model) {
    Validator.throwExceptionIfInvalidModel(model);
    this.model = model;
  }
}
