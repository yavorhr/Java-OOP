package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer {
  public static final double OVERALL_PERFORMANCE = 15;

  public DesktopComputer(Integer id, String manufacturer, String model, double price) {
    super(id, manufacturer, model, price, OVERALL_PERFORMANCE);
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
