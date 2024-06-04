package vehicleShop.validator;

import vehicleShop.common.ExceptionMessages;

public class Validator {
  public void validateWorkersName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
    }
  }

  public void validateStrength(int strength) {
    if (strength < 0) {
      throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
    }
  }
}
