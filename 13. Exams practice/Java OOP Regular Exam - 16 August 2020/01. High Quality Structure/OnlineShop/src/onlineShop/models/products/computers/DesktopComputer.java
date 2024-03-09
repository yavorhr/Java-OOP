package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer{
  public static final double OVERALL_PERFORMANCE_MULTIPLIER = 15;

  protected DesktopComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
    super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE_MULTIPLIER);
  }
}
