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
      throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
    }
  }

  public static void validateServiceType(String type) {
    if (!(type.equals("MainService") || type.equals("SecondaryService"))) {
      throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
    }
  }

  public static void validateSupplementType(String type) {
    if (!(type.equals("PlasticArmor") || type.equals("MetalArmor"))) {
      throw new NullPointerException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
    }
  }

  public static void validateRobotType(String type) {
    if (!(type.equals("MaleRobot") || type.equals("FemaleRobot"))) {
      throw new NullPointerException(ExceptionMessages.INVALID_ROBOT_TYPE);
    }
  }

  public static void validateRobotServiceArea(String serviceType, String robotType) {
    if (serviceType.equals("SecondaryService") && robotType.equals("MaleRobot") ||
            serviceType.equals("MainService") && robotType.equals("FemaleRobot")) {
      throw new IllegalArgumentException(ExceptionMessages.UNSUITABLE_SERVICE);
    }
  }

}
