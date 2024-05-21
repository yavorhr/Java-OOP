package restaurant.validator;

import restaurant.common.ExceptionMessages;

public class Validator {
  public static void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
    }
  }

  public static void validatePortion(double portion) {
    if (portion <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
    }
  }

  public static void validatePrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
    }
  }

  public static void validateCounter(int counter) {
    if (counter <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_COUNTER);
    }
  }

  public static void validateBrand(String brand) {
    if (brand == null || brand.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
    }
  }
}
