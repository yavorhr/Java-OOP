package viceCity.validator;

import viceCity.common.ExceptionMessages;

public class Validator {
  public static void validatePlayerName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
    }
  }

  public static void validatePlayerLifePoints(int points) {
    if (points < 0) {
      throw new NullPointerException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
    }
  }
}
