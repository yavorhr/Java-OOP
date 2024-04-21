package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.validator.Validator;


public abstract class BaseBakedFood implements BakedFood {
  private String name;
  private double portion;
  private double price;

  public BaseBakedFood(String name, double portion, double price) {
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

  @Override
  public String toString() {
    return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);
  }
}
