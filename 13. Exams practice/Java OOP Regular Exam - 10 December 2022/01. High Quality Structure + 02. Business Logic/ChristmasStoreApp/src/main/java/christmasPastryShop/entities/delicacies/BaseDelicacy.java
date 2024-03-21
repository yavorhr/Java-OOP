package christmasPastryShop.entities.delicacies;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public abstract class BaseDelicacy implements Delicacy {
  private String name;
  private double portion;
  private double price;

  protected BaseDelicacy(String name, double portion, double price) {
    this.name = name;
    this.portion = portion;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getPortion() {
    return this.portion;
  }

  @Override
  public double getPrice() {
    return this.price;
  }
}
