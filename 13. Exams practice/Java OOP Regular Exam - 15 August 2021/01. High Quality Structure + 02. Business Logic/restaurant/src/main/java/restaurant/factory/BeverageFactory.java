package restaurant.factory;

import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.drinks.interfaces.Beverages;

public class BeverageFactory {

  public static Beverages create(String type, int counter, String brand, String name) {
    Beverages beverages = null;

    switch (type) {
      case "Smoothie" -> beverages = new Smoothie(name, counter, brand);
      case "Fresh" -> beverages = new Fresh(name, counter, brand);
      default -> throw new IllegalArgumentException("Invalid beverage type!");
    }
    return beverages;
  }
}
