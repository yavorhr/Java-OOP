package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
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
  public double getPrice() {
    double componentsPrice = this.components.stream().mapToDouble(Product::getPrice).sum();
    double peripheralsPrice = this.peripherals.stream().mapToDouble(Product::getPrice).sum();

    return componentsPrice + peripheralsPrice + super.getPrice();
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
    if (this.components.stream().anyMatch(c -> c.getClass() == component.getClass())) {
      throw new IllegalArgumentException((String.format(ExceptionMessages.EXISTING_COMPONENT,
              component.getClass().getSimpleName(),
              this.getClass().getSimpleName(),
              this.getId())));
    }
    this.components.add(component);
  }

  @Override
  public Component removeComponent(String componentType) {
    if (this.components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
      throw new IllegalArgumentException((String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
              componentType,
              this.getClass().getSimpleName(),
              this.getId())));
    }

    int index = 0;
    for (int i = 0; i < components.size(); i++) {
      Component currentComp = this.components.get(i);
      if (currentComp.getClass().getSimpleName().equals(componentType)) {
        index = i;
      }
    }
    return this.components.remove(index);
  }

  @Override
  public void addPeripheral(Peripheral peripheral) {
    if (this.peripherals.stream().anyMatch(c -> c.getClass() == peripheral.getClass())) {
      throw new IllegalArgumentException((String.format(ExceptionMessages.EXISTING_PERIPHERAL,
              peripheral.getClass().getSimpleName(),
              this.getClass().getSimpleName(),
              this.getId())));
    }
    this.peripherals.add(peripheral);
  }


  @Override
  public Peripheral removePeripheral(String peripheralType) {
    if (this.peripherals.stream().noneMatch(c -> c.getClass().getSimpleName().equals(peripheralType))) {
      throw new IllegalArgumentException((String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
              peripheralType,
              this.getClass().getSimpleName(),
              this.getId())));
    }

    int index = 0;
    for (int i = 0; i < peripherals.size(); i++) {
      Peripheral currentPeripheral = this.peripherals.get(i);
      if (currentPeripheral.getClass().getSimpleName().equals(peripheralType)) {
        index = i;
      }
    }
    return this.peripherals.remove(index);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
            this.getOverallPerformance(),
            this.getPrice(),
            this.getClass().getSimpleName(),
            this.getManufacturer(),
            this.getModel(),
            this.getId()))
            .append(System.lineSeparator());

    sb.append(String.format(" Components (%d):", this.components.size()))
            .append(System.lineSeparator());

    this.components.forEach(c -> sb.append(c).append(System.lineSeparator()));

    sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
            this.peripherals.size(),
            this.getPeripheralsAverage()
    ))
            .append(System.lineSeparator());

    this.peripherals.forEach(sb::append);

    return sb.toString().trim();
  }

  protected double getComponentsAverage() {
    return this.components.stream()
            .mapToDouble(Product::getOverallPerformance)
            .average()
            .orElse(0) ;
  }

  private double getPeripheralsAverage() {
    return this.peripherals.stream()
            .mapToDouble(Product::getOverallPerformance)
            .average()
            .orElse(0) ;
  }
}
