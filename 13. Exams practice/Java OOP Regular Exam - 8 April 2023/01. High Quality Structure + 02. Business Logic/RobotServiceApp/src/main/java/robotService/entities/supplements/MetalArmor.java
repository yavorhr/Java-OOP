package robotService.entities.supplements;

public class MetalArmor extends BaseSupplement {
  private static final int HARDNESS = 5;
  private static final double PRICE = 15.00;

  public MetalArmor(int hardness, double price) {
    super(hardness, price);
  }
}
