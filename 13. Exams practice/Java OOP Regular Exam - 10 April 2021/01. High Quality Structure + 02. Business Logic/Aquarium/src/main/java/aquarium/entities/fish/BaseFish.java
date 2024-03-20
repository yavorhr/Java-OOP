package aquarium.entities.fish;

import aquarium.validator.Validator;

public abstract class BaseFish implements Fish {
  private String name;
  private String species;
  private int size;
  private double price;

  public BaseFish(String name, String species, int size, double price) {
    this.setName(name);
    this.setSpecies(species);
    this.size = size;
    this.setPrice(price);
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


  private void setName(String name) {
    Validator.validateFishName(name);
    this.name = name;
  }

  private void setSpecies(String species) {
    Validator.validateFishSpecies(species);
    this.species = species;
  }

  private void setPrice(double price) {
    Validator.validateFishPrice(price);
    this.price = price;
  }
}
