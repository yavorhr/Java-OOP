package onlineShop.models.products.components;

public class CentralProcessingUnit extends BaseComponent {
  public static final double OVERALL_PERFORMANCE_MULTIPLIER = 1.25;

  protected CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
    super(id, manufacturer, model, price, OVERALL_PERFORMANCE_MULTIPLIER * 1.25, generation);
  }
}
