package bakery.entities.bakedFoods;

public class Cake extends BaseBakedFood {
  private static final double INITIAL_BREAD_PORTION = 245;

  public Cake(String name, double price) {
    super(name, INITIAL_BREAD_PORTION, price);
  }
}
