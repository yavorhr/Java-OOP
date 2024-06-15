package magicGame.factory;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;

public class MagicFactory {
  public static Magic create(String type, String name, int bulletsCount) {
    Magic magic = null;

    switch (type) {
      case "RedMagic" -> magic = new RedMagic(name, bulletsCount);
      case "BlackMagic" -> magic = new BlackMagic(name, bulletsCount);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
    }

    return magic;
  }
}
