package bakery.factory;

import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;

public class FoodFactory {
  public static BakedFood create(String type, String name, double price) {
    BakedFood food = null;

    switch (type) {
      case "Bread" -> food = new Bread(name, price);
      case "Cake" -> food = new Cake(name, price);
    }
    return food;
  }
}
