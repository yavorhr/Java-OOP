package restaurant;

import java.math.BigDecimal;

public abstract class MainDish extends Food{

  public MainDish(String name, BigDecimal price, double grams) {
    super(name, price, grams);
  }
}
