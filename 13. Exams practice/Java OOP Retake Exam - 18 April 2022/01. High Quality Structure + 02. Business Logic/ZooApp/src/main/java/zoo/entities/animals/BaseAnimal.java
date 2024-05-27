package zoo.entities.animals;

import validator.Validator;

public abstract class BaseAnimal implements Animal {
  private String name;
  private String kind;
  private double kg;
  private double price;

  protected BaseAnimal(String name, String kind, double kg, double price) {
    this.setName(name);
    this.setKind(kind);
    this.kg = kg;
    this.setPrice(price);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getKg() {
    return this.kg;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  protected void increaseWeight(double kg) {
    this.kg += kg;
  }

  private void setName(String name) {
    Validator.validateAnimalName(name);
    this.name = name;
  }

  private void setKind(String kind) {
    Validator.validateAnimalKind(kind);
    this.kind = kind;
  }

  private void setPrice(double price) {
    Validator.validateAnimalPrice(price);
    this.price = price;
  }
}
