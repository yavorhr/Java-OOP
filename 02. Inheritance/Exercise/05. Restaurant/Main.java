import restaurant.Coffee;
import restaurant.HotBeverage;
import restaurant.Tea;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    HotBeverage coffee = new Coffee("Cappuccino", 5);
    HotBeverage tea = new Tea("Mint", BigDecimal.valueOf(31), 50);

    List<HotBeverage> beverages = new ArrayList<>();
    beverages.add(coffee);
    beverages.add(tea);

    beverages.forEach(System.out::println);
  }
}