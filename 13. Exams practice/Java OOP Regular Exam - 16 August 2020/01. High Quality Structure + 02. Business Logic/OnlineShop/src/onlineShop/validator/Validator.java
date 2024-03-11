package onlineShop.validator;

import onlineShop.common.constants.ExceptionMessages;

public class Validator {
  public static void throwErrIfInvalidId(int id) {
    if (id <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_ID);
    }
  }

  public static void throwErrIfInvalidManufacturer(String string) {
    if (string == null || string.trim().isBlank()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MANUFACTURER);
    }
  }

  public static void throwErrIvInvalidModel(String string) {
    if (string == null || string.trim().isBlank()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MODEL);
    }
  }

  public static void throwErrIfInvalidPrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
    }
  }

  public static void throwErrIfInvalidPerformance(double performance) {
    if (performance <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_OVERALL_PERFORMANCE);
    }
  }
}
