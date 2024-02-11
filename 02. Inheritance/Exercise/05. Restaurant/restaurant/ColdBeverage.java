package restaurant;

import java.math.BigDecimal;

public abstract class ColdBeverage extends Beverages{
  public ColdBeverage(String name, BigDecimal price, double milliliters) {
    super(name, price, milliliters);
  }
}
