package CounterStriker.validator;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

public class Validator {

  public static void throwErrIfBulletsAreOver(int bullets) {
    if (bullets == 0) {
      throw new NullPointerException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
    }
  }

  public static void throwErrorIfNullArgumentIsPassed(Gun gun) {
    if (gun == null) {
      throw new NullPointerException(ExceptionMessages.INVALID_GUN);

    }
  }

  public static void throwErrorIfNullPlayerIsPassed(Player player) {
    if (player == null) {
      throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);

    }
  }

  public static void throwErrorIfGunIsNull(Gun gun) {
    if (gun == null) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN);
    }
  }

  public static void throwErrorIfGunNameIsNullOrEmpty(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_NAME);
    }
  }

  public static void throwErrIfNullOrEmptyPlayerUsername(String username) {
    if (username == null || username.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_NAME);
    }
  }

  public static void throwErrIfHealthIsBelowZero(int health) {
    if (health <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_HEALTH);
    }
  }

  public static void throwErrIfArmorIsBelowZero(int armor) {
    if (armor < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_ARMOR);
    }
  }

  public static void throwErrIfGunIsNull(Gun gun) {
    if (gun == null) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN);
    }
  }
}
