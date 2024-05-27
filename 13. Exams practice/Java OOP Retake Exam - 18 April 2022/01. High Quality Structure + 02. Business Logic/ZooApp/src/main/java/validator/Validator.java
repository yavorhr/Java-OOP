package validator;

import zoo.common.ExceptionMessages;

public class Validator {

  public static void validateCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
    }
  }

  public static void validateAnimalName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.ANIMAL_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateAnimalKind(String kind) {
    if (kind == null || kind.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.ANIMAL_KIND_NULL_OR_EMPTY);
    }
  }

  public static void validateAnimalPrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
    }
  }
  public static void validateAAreaName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
    }
  }

}
