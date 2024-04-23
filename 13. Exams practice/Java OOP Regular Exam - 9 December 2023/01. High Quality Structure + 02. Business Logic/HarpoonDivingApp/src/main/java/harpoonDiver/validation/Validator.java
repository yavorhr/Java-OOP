package harpoonDiver.validation;

import harpoonDiver.common.ExceptionMessages;

public class Validator {
  private static void validateSiteName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
    }
  }
}
