package zoo.entities.animals;

public abstract class BaseAnimal implements Animal {
  private String name;
  private String kind;
  private double kg;
  private double price;

  protected BaseAnimal(String name, String kind, double kg, double price) {
    this.name = name;
    this.kind = kind;
    this.kg = kg;
    this.price = price;
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

  @Override
  public void eat() {

  }
}
