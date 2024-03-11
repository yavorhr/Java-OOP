package onlineShop.models.products;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.validator.Validator;

public abstract class BaseProduct implements Product {
  private int id;
  private String manufacturer;
  private String model;
  private double price;
  private double overallPerformance;

  protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
    this.setId(id);
    this.setManufacturer(manufacturer);
    this.setModel(model);
    this.setPrice(price);
    this.setOverallPerformance(overallPerformance);
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public String getManufacturer() {
    return this.manufacturer;
  }

  @Override
  public String getModel() {
    return this.model;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public double getOverallPerformance() {
    return this.overallPerformance;
  }

  @Override
  public String toString() {
    return String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
            this.getOverallPerformance(),
            this.getPrice(),
            this.getClass().getSimpleName(),
            this.getManufacturer(),
            this.getModel(),
            this.getId());
  }

  public void setId(int id) {
    Validator.throwErrIfInvalidId(id);
    this.id = id;
  }

  public void setManufacturer(String manufacturer) {
    Validator.throwErrIfInvalidManufacturer(manufacturer);
    this.manufacturer = manufacturer;
  }

  public void setModel(String model) {
    Validator.throwErrIvInvalidModel(model);
    this.model = model;
  }

  public void setPrice(double price) {
    Validator.throwErrIfInvalidPrice(price);
    this.price = price;
  }

  public void setOverallPerformance(double overallPerformance) {
    Validator.throwErrIfInvalidPerformance(overallPerformance);
    this.overallPerformance = overallPerformance;
  }

}
