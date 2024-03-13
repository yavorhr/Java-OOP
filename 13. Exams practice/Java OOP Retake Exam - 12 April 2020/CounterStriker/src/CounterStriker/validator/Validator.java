package CounterStriker.validator;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

public class Validator {

  public static void throwErrIfNameIsBlankOrEmpty(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.INVALID_GUN);
    }
  }

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
    if (gun == null){
      throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN);
    }
  }
}
