package restaurant.entities.healthyFoods.interfaces;

public abstract class Food implements HealthyFood {
  private String name;
  private double portion;
  private double price;

  protected Food(String name, double portion, double price) {
    this.name = name;
    this.portion = portion;
    this.price = price;
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
