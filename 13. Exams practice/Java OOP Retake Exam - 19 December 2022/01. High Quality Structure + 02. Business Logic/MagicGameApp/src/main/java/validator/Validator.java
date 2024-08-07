package validator;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;

public class Validator {
  public static void validateMagicName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
    }
  }

  public static void validateBulletsCount(int count) {
    if (count < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
    }
  }

  public static void validateUsername(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
    }
  }

  public static void validateHealthPoints(int healthPoints) {
    if (healthPoints < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
    }
  }

  public static void validateProtectionPoints(int protectionPoints) {
    if (protectionPoints < 0) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
    }
  }

  public static void validateMagicWhenAddedToMagician(Magic magic) {
    if (magic == null) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
    }
  }

  public static void validateIfMagicExists(Magic magic) {
    if (magic == null) {
      throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
    }
  }

  public static void validateIfMagicIsNotNull(Magic magic) {
    if (magic == null) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
    }
  }

  public static void validateIfMagicianIsNotNull(Magician magician) {
    if (magician == null) {
      throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
    }
  }
}
