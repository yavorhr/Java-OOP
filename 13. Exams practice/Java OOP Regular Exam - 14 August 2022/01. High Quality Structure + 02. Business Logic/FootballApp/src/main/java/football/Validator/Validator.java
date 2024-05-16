package football.Validator;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;

public class Validator {

  public static void validateIfCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
    }
  }

  public static void validatePlayerName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateNationality(String nationality) {
    if (nationality == null || nationality.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
    }
  }

  public static void validateStrength(int strength) {
    if (strength <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
    }
  }


  public static void validateFieldName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
    }
  }
}
