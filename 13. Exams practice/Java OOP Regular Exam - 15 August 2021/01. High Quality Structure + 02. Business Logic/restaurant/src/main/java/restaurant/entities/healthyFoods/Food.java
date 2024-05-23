package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.validator.Validator;

public abstract class Food implements HealthyFood {
  private String name;
  private double portion;
  private double price;

  protected Food(String name, double portion, double price) {
    this.setName(name);
    this.setPortion(portion);
    this.setPrice(price);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getPortion() {
    return this.portion;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  private void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  private void setPortion(double portion) {
    Validator.validatePortion(portion);
    this.portion = portion;
  }

  private void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }
}
