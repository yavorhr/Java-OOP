package catHouse.entities.cat;

public abstract class BaseCat implements Cat{
  private String name;
  private String breed;
  private int kilograms;
  private double price;

  public BaseCat(String name, String breed, int kilograms, double price) {
    this.name = name;
    this.breed = breed;
    this.kilograms = kilograms;
    this.price = price;
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

  }
}
