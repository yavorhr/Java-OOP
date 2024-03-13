package CounterStriker.factory;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;

public class GunFactory {
  public static Gun createGun(String type, String name, int bulletsCount) {
    Gun gun = null;

    switch (type) {
      case "Pistol" -> gun = new Pistol(name, bulletsCount);
      case "Rifle" -> gun = new Rifle(name, bulletsCount);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
    }
    return gun;
  }
}
