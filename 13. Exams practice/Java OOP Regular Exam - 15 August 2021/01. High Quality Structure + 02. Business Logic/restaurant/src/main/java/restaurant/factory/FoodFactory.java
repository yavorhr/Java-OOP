package restaurant.factory;

import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public class FoodFactory {
  public static HealthyFood create(String type, double price, String name) {
    HealthyFood food = null;

    switch (type) {
      case "Salad" -> food = new Salad(name, price);
      case "VeganBiscuits" -> food = new VeganBiscuits(name, price);
      default -> throw new IllegalArgumentException("Invalid Food Type");
    }
    return food;
  }
}
