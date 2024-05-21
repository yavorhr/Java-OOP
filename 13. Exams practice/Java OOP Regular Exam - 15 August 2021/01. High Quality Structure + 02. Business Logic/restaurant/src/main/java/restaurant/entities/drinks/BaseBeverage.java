package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.validator.Validator;

public abstract class BaseBeverage implements Beverages {
  private String name;
  private int counter;
  private double price;
  private String brand;

  protected BaseBeverage(String name, int counter, double price, String brand) {
    this.setName(name);
    this.setCounter(counter);
    this.setPrice(price);
    this.setBrand(brand);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getCounter() {
    return this.counter;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public String getBrand() {
    return this.brand;
  }

  public void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  public void setCounter(int counter) {
    Validator.validateCounter(counter);
    this.counter = counter;
  }

  public void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }

  public void setBrand(String brand) {
    Validator.validateBrand(brand);
    this.brand = brand;
  }
}
