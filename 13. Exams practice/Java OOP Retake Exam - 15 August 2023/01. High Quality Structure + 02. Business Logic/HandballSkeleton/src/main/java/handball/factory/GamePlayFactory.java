package handball.factory;

import handball.common.ExceptionMessages;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;

public class GamePlayFactory {
  public static Gameplay create(String type, String name) {
    Gameplay gameplay = null;

    switch (type) {
      case "Outdoor" -> gameplay = new Outdoor(name);
      case "Indoor" -> gameplay = new Indoor(name);
      default -> throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
    }

    return gameplay;

  }
}
