package zoo.entities.foods;

public abstract class BaseFood implements Food {
  private double price;
  private int calories;

  protected BaseFood(double price, int calories) {
    this.price = price;
    this.calories = calories;
  }

  @Override
  public int getCalories() {
    return this.calories;
  }

  @Override
  public double getPrice() {
    return this.price;
  }


}
