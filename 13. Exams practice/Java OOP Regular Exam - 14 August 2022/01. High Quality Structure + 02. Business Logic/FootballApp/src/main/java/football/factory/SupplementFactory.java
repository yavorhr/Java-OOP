package football.factory;

import football.common.ExceptionMessages;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;

public class SupplementFactory {
  public static Supplement create(String type) {
    Supplement supplement = null;

    switch (type) {
      case "Powdered" -> supplement = new Powdered();
      case "Liquid" -> supplement = new Liquid();
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
    }

    return supplement;
  }
}
