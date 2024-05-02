package handball.Validator;

import handball.common.ExceptionMessages;

public class Validator {
  public static void validateTeamName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateGamePlayName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateCountryName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.TEAM_COUNTRY_NULL_OR_EMPTY);
    }
  }

  public static void validateAdvantage(int advantage) {
    if (advantage < 0) {
      throw new IllegalArgumentException(ExceptionMessages.TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
    }
  }
}
