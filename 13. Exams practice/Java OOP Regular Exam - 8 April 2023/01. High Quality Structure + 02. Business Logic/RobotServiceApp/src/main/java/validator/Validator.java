package validator;

import robotService.common.ExceptionMessages;

public class Validator {
  public static void validateRobotName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateServiceName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateKind(String kind) {
    if (kind == null || kind.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validatePrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
    }
  }

  public static void validateCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NO_CAPACITY);
    }
  }
}
