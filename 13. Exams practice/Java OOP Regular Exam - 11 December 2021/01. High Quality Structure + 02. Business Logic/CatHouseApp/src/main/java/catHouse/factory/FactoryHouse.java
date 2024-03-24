package catHouse.factory;

import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;

public class FactoryHouse {
  public static House create(String type, String name) {
    House house = null;

    switch (type) {
      case "ShortHouse":
        house = new ShortHouse(name);
        break;
      case "LongHouse":
        house = new LongHouse(name);
        break;
    }

    return house;
  }
}
