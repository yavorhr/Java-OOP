package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

public abstract class BaseBeverage implements Beverages {
  private String name;
  private int counter;
  private double price;
  private String brand;

  protected BaseBeverage(String name, int counter, double price, String brand) {
    this.name = name;
    this.counter = counter;
    this.price = price;
    this.brand = brand;
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
}
