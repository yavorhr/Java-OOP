package christmasPastryShop.entities.delicacies;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.validator.Validator;

public abstract class BaseDelicacy implements Delicacy {
  private String name;
  private double portion;
  private double price;

  protected BaseDelicacy(String name, double portion, double price) {
    this.setName(name);
    this.setPortion(portion);
    this.setPrice(price);
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

  @Override
  public String toString() {
    return String.format("%s: %.2fg - %.2f",
            this.name,
            this.portion,
            this.portion);
  }

  private void setName(String name) {
    Validator.validateDelicacyName(name);
    this.name = name;
  }

  private void setPortion(double portion) {
    Validator.validatePortion(portion);

    this.portion = portion;
  }

  private void setPrice(double price) {
    Validator.validatePrice(price);
    this.price = price;
  }
}
