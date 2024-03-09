package onlineShop.models.products.computers;

public class Laptop extends BaseComputer {
  public static final double OVERALL_PERFORMANCE = 10;

  protected Laptop(int id, String manufacturer, String model, double price, double overallPerformance) {
    super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE);
  }

  @Override
  public double getOverallPerformance() {
    if (super.getComponents().isEmpty()) {
      return OVERALL_PERFORMANCE;
    }

    double componentsAvgPerformance = super.getComponentsAverage();
    return OVERALL_PERFORMANCE + componentsAvgPerformance;
  }
}
