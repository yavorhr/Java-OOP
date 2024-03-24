package catHouse.factory;

import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;

public class FactoryCat {
  public static Cat create(String catType, String catName, String catBreed, double price) {
    Cat cat = null;

    switch (catType) {
      case "ShorthairCat" -> cat = new ShorthairCat(catName, catBreed, price);
      case "LonghairCat" -> cat = new LonghairCat(catName, catBreed, price);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
    }

    return cat;
  }
}
