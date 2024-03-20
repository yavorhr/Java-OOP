package aquarium.factory;

import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;

public class AquariumFactory {
  public static Aquarium create(String type, String name) {
    Aquarium aquarium = null;

    switch (type) {
      case "FreshwaterAquarium" -> aquarium = new FreshwaterAquarium(name);
      case "SaltwaterAquarium" -> aquarium = new SaltwaterAquarium(name);
      default -> throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
    }

    return aquarium;
  }
}
