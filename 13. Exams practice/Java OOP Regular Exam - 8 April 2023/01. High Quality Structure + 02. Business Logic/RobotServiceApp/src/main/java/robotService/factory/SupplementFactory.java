package robotService.factory;

import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import validator.Validator;

public class SupplementFactory {
  public static Supplement create(String type) {
    Validator.validateSupplementType(type);

    Supplement supplement = null;

    switch (type) {
      case "PlasticArmor" -> supplement = new PlasticArmor();
      case "MetalArmor" -> supplement = new MetalArmor();
    }

    return supplement;
  }
}
