package restaurant.validator;

import restaurant.common.ExceptionMessages;

public class Validator {
  public void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
    }
  }

  public void validatePortion(double portion) {
    if (portion <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
    }
  }

  public void validatePrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
    }
  }
}
