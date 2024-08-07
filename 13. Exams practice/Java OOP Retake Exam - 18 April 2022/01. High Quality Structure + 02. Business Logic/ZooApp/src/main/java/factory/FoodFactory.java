package factory;

import zoo.common.ExceptionMessages;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;

public class FoodFactory {
  public static Food create(String type) {
    Food food = null;

    switch (type) {
      case "Vegetable" -> food = new Vegetable();
      case "Meat" -> food = new Meat();
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
    }

    return food;
  }
}
