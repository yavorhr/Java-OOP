package restaurant;

import java.math.BigDecimal;

public abstract class Starter extends Food {
  public Starter(String name, BigDecimal price, double grams) {
    super(name, price, grams);
  }
}
