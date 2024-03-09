package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

public class Motherboard extends BaseComponent {
  public static final double OVERALL_PERFORMANCE_MULTIPLIER = 1.25;

  protected Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
    super(id, manufacturer, model, price, overallPerformance * OVERALL_PERFORMANCE_MULTIPLIER, generation);
  }
}
