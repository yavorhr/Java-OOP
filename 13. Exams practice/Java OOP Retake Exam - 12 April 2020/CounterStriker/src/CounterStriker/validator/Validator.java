package CounterStriker.validator;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

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
    if (gun ==null){
      throw new NullPointerException(ExceptionMessages.INVALID_GUN);

    }
  }
}
