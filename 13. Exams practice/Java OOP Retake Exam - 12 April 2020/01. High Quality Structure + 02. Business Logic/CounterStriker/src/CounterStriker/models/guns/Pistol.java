package CounterStriker.models.guns;

import CounterStriker.validator.Validator;

public class Pistol extends GunImpl {
  private static final int BULLETS_PER_TIME = 1;

  public Pistol(String name, int bulletsCount) {
    super(name, bulletsCount, BULLETS_PER_TIME);
  }


}
