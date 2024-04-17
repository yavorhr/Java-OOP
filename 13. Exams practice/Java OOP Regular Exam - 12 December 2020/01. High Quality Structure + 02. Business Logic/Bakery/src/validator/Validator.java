package validator;

import bakery.common.ExceptionMessages;

public class Validator {
  private static void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
    }
  }

  private static void validateBrand(String brand) {
    if (brand == null || brand.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
    }
  }

  private static void validatePortion(int portion) {
    if (portion <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
    }
  }

  private static void validatePrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
    }
  }
}
