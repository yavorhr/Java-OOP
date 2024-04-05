package viceCity.factory;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;

public class GunFactory {
  public static Gun create(String type, String name) {
    Gun gun = null;

    switch (type) {
      case "Pistol" -> gun = new Pistol(name);
      case "Rifle" -> gun = new Rifle(name);
    }

    return gun;
  }
}
