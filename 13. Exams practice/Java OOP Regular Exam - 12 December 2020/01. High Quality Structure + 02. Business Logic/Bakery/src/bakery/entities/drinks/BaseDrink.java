package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;

public class BaseDrink implements Drink {
  private String name;
  private int portion;
  private double price;
  private String brand;

  protected BaseDrink(String name, int portion, double price, String brand) {
    this.name = name;
    this.portion = portion;
    this.price = price;
    this.brand = brand;
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
}
