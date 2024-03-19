package bank.validator;

import bank.common.ExceptionMessages;

public class Validator {
  public static void validateClientName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateClientId(String id) {
    if (id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateClientIncome(double income) {
    if (income <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
    }
  }

}
