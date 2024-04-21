package bakery.factory;

import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;

public class DrinkFactory {
  public static Drink create(String type, String name, int portion, String brand) {
    Drink drink = null;

    switch (type) {
      case "Tea" -> drink = new Tea(name, portion, brand);
      case "Water" -> drink = new Water(name, portion, brand);
    }
    return drink;
  }
}
