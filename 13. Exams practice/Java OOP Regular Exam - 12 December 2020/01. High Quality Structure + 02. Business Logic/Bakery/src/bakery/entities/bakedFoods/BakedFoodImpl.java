package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.validator.Validator;


public abstract class BakedFoodImpl implements BakedFood {
  private String name;
  private double portion;
  private double price;
  private String brand;

  public BakedFoodImpl(String name, double portion, double price, String brand) {
    this.setName(name);
    this.setPortion(portion);
    this.setPrice(price);
    this.setBrand(brand);
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

  private void setBrand(String brand) {
    Validator.validateBrand(brand);
    this.brand = brand;
  }
}
