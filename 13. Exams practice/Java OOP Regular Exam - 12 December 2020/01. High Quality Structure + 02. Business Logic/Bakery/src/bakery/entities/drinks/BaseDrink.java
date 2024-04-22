package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;
import bakery.validator.Validator;

public class BaseDrink implements Drink {
  private String name;
  private int portion;
  private double price;
  private String brand;

  protected BaseDrink(String name, int portion, double price, String brand) {
    this.name = name;
    this.setPortion(portion);
    this.setPrice(price);
    this.setBrand(brand);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getPortion() {
    return this.portion;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public String getBrand() {
    return this.brand;
  }

  @Override
  public String toString() {
    return String.format("%s: %dml - %.2f", this.name, this.portion, this.price);
  }

  private void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  private void setPortion(int portion) {
    Validator.validatePortion(portion);
    this.portion = portion;
  }

  private void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }

  private void setBrand(String brand) {
    Validator.validateBrand(brand);
    this.brand = brand;
  }
}
