package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

public class CentralProcessingUnit extends BaseComponent {
    public CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, 1.25 * overallPerformance, generation);
    }


}
