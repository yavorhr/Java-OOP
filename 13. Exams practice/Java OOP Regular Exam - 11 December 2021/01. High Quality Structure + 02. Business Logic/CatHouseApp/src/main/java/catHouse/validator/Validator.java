package catHouse.validator;

import catHouse.common.ExceptionMessages;

public class Validator {
  public static void validateCatName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateCatBreed(String breed) {
    if (breed == null || breed.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateCatPrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
    }
  }

  public static void validateIfHouseCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
    }
  }

  public static void validateHouseName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static boolean isCatSuitableToHouse(String houseType, String catType) {
    boolean result = true;

    switch (houseType) {
      case "ShortHouse" -> {
        if (catType.equals("LongHairCat")) {
          result = false;
        }
      }
      case "LongHouse" -> {
        if (catType.equals("ShortHairCat")) {
          result = false;
        }
      }
    }
    return result;
  }
}
