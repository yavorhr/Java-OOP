package easterRaces.entities.cars;

import easterRaces.validator.Validator;

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
    Validator.throwExceptionIfInvalidModel(model);
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

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }

  public void setCubicCentimeters(double cubicCentimeters) {
    this.cubicCentimeters = cubicCentimeters;
  }



}
