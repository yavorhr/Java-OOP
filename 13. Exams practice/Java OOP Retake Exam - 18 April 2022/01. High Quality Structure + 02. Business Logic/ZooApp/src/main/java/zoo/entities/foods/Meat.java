package zoo.entities.foods;

public class Meat extends BaseFood {
  private static final int CALORIES = 70;

  public Meat(double price) {
    super(price, CALORIES);
  }
}
