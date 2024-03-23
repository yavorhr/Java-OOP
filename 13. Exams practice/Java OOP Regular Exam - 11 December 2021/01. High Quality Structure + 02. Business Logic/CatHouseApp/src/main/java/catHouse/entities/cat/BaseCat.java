package catHouse.entities.cat;

import catHouse.validator.Validator;

public abstract class BaseCat implements Cat {
  private String name;
  private String breed;
  private int kilograms;
  private double price;

  public BaseCat(String name, String breed, int kilograms, double price) {
    this.setName(name);
    this.setBreed(breed);
    this.kilograms = kilograms;
    this.setPrice(price);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getKilograms() {
    return this.kilograms;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void eating() {

  }

  @Override
  public void setName(String name) {
    Validator.validateCatName(name);
    this.name = name;
  }

  private void setBreed(String breed) {
    Validator.validateCatBreed(breed);
    this.breed = breed;
  }

  private void setPrice(double price) {
    Validator.validateCatPrice(price);
    this.price = price;
  }
}
