package christmasPastryShop.entities.cocktails;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.validator.Validator;

public abstract class BaseCocktail implements Cocktail {
  private String name;
  private int size;
  private double price;
  private String brand;

  public BaseCocktail(String name, int size, double price, String brand) {
    this.setName(name);
    this.setSize(size);
    this.setPrice(price);
    this.setBrand(brand);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public String getBrand() {
    return this.brand;
  }

  private void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  private void setSize(int size) {
    Validator.validateSize(size);
    this.size = size;
  }

  private void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }

  private void setBrand(String brand) {
    Validator.validateBrand(brand);
    this.brand = brand;
  }

  @Override
  public String toString() {
    return String.format("%s %s - %dml - %.2flv",
            this.name,
            this.brand,
            this.size,
            this.price);
  }
}
