package robotService.entities.robot;

import validator.Validator;

public abstract class BaseRobot implements Robot {
  private String name;
  private String kind;
  private int kilograms;
  private double price;

  protected BaseRobot(String name, String kind, double price) {
    this.setName(name);
    this.setKind(kind);
    this.setPrice(price);
  }

  protected BaseRobot(String name, String kind, double price, int kilograms) {
    this.setName(name);
    this.setKind(kind);
    this.setPrice(price);
    this.kilograms = kilograms;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getKilograms() {
    return this.kilograms;
    public double getPrice() {
      return this.price;
    }

    @Override
    public void setName(String name) {
      Validator.validateRobotName(name);
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

    protected void increaseKilos(int kg) {
      this.kilograms += kg;
    }
  }
  }

  @Override
