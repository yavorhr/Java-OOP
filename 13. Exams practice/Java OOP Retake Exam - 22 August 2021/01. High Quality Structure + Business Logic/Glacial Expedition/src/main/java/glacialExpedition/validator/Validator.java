package glacialExpedition.validator;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.Explorer;

public class Validator {

  public static void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateEnergy(double energy) {
    if (energy < 0) {
      throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
    }
  }

  public static void validateExplorer(Explorer explorer) {
    if (explorer == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorer.getName()));
    }
  }
}
