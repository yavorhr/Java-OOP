package christmasPastryShop.entities.delicacies;

public class GingerBread extends BaseDelicacy {
  private static final double INITIAL_PORTION = 200;

  public GingerBread(String name, double price) {
    super(name, INITIAL_PORTION, price);
  }
}
