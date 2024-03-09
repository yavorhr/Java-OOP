package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
  List<Component> components;
  List<Peripheral> peripherals;

  protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
    super(id, manufacturer, model, price, overallPerformance);
    this.components = new ArrayList<>();
    this.peripherals = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "not implemented";
  }

  @Override
  public List<Component> getComponents() {
    return this.components;
  }

  @Override
  public List<Peripheral> getPeripherals() {
    return this.peripherals;
  }

  @Override
  public void addComponent(Component component) {
    this.components.add(component);
  }

  @Override
  public Component removeComponent(String componentType) {
   return null;
  }

  @Override
  public void addPeripheral(Peripheral peripheral) {

  }

  @Override
  public Peripheral removePeripheral(String peripheralType) {
    return null;
  }

  protected double getComponentsAverage(){
    return this.components.stream()
            .mapToDouble(Product::getOverallPerformance)
            .average()
            .orElse(0);
  }
}
