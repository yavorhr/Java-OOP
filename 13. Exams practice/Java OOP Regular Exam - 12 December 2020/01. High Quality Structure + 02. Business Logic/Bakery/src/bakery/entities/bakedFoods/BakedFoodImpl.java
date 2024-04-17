package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

public abstract class BakedFoodImpl implements BakedFood {
  private String name;
  private double portion;
  private double price;
  private String brand;

  public BakedFoodImpl(String name, double portion, double price, String brand) {
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
  public double getPortion() {
    return this.portion;
  }

  @Override
  public double getPrice() {
    return this.price;
  }
}
