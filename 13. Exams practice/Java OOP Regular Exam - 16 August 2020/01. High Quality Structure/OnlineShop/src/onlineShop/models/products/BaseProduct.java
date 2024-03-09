package onlineShop.models.products;

public abstract class BaseProduct implements Product {
  private int id;
  private String manufacturer;
  private String model;
  private double price;
  private double overallPerformance;

  protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
    this.id = id;
    this.manufacturer = manufacturer;
    this.model = model;
    this.price = price;
    this.overallPerformance = overallPerformance;
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
    return "Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})";
  }
}
