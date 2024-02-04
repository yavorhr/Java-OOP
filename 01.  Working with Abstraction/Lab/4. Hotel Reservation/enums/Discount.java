package enums;

public enum Discount {
  VIP(0.2),
  SecondVisit(0.1),
  None(0.0);

  double discountAmount;

  Discount(double discountAmount) {
    this.discountAmount = discountAmount;
  }

  public double getDiscountAmount() {
    return discountAmount;
  }
}
