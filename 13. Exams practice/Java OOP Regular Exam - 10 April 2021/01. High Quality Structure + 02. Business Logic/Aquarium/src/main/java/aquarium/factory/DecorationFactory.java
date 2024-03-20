package aquarium.factory;

import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;

public class DecorationFactory {
  public static Decoration create(String type) {
    Decoration decoration = null;

    switch (type) {
      case "Ornament" -> decoration = new Ornament();
      case "Plant" -> decoration = new Plant();
      default -> throw new NullPointerException(ExceptionMessages.INVALID_DECORATION_TYPE);
    }

    return decoration;
  }
}

