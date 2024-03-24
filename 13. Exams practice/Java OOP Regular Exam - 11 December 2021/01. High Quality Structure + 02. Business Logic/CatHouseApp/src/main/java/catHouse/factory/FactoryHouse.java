package catHouse.factory;

import catHouse.common.ExceptionMessages;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;

public class FactoryHouse {
  public static House create(String type, String name) {
    House house = null;

    switch (type) {
      case "ShortHouse" -> house = new ShortHouse(name);
      case "LongHouse" -> house = new LongHouse(name);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_HOUSE_TYPE);
    }

    return house;
  }

}
