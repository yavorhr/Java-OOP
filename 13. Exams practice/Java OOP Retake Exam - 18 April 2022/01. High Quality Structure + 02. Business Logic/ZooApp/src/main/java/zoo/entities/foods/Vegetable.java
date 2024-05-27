package zoo.entities.foods;

public class Vegetable extends BaseFood {
  private static final int CALORIES = 50;

  public Vegetable(double price) {
    super(price, CALORIES);
  }
}
