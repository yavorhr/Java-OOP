package magicGame.factory;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;

public class MagicianFactory {

  public static Magician create(String type, String username, int health, int protection, Magic magicName) {
    Magician magician = null;

    switch (type) {
      case "Wizard" -> magician = new Wizard(username, health, protection, magicName);
      case "BlackWidow" -> magician = new BlackWidow(username, health, protection, magicName);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
    }

    return magician;
  }
}
