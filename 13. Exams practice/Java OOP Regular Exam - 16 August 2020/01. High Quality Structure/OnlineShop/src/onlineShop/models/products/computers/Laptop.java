package onlineShop.models.products.computers;

public class Laptop extends BaseComputer {
  public static final double OVERALL_PERFORMANCE_MULTIPLIER = 10;

  protected Laptop(int id, String manufacturer, String model, double price, double overallPerformance) {
    super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE_MULTIPLIER);
  }
}
