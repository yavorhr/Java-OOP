package bakery.entities.bakedFoods;

public class Bread extends BaseBakedFood {
  private static final double INITIAL_BREAD_PORTION = 200;

  public Bread(String name, double price) {
    super(name, INITIAL_BREAD_PORTION, price);
  }
}
