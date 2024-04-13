package robotService.entities.robot;

import validator.Validator;

public class BaseRobot implements Robot {
  private String name;
  private String kind;
  private int kilograms;
  private double price;

  protected BaseRobot(String name, String kind, double price) {
    this.setName(name);
    this.setKind(kind);
    this.setPrice(price);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getKilograms() {
    return this.kilograms;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  private void setKind(String kind) {
    Validator.validateKind(kind);
    this.kind = kind;
  }

  private void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }

  @Override
  public void eating() {

  }
}
