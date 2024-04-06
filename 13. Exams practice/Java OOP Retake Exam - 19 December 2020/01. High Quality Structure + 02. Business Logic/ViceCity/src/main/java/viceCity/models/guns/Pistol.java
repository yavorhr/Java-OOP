package viceCity.models.guns;

public class Pistol extends BaseGun {
  private static final int BULLETS_PER_BARREL = 10;
  private static final int FIRE_BULLETS_PER_TIME = 1;
  private static final int INITIAL_TOTAL_BULLETS = 100;

  public Pistol(String name) {
    super(name, BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
  }

  @Override
  public int fire() {
    if (super.canFire()) {
      super.setCurrentBullets(FIRE_BULLETS_PER_TIME);
    } else if (!super.canFire() && super.hasAmmo()) {
      super.reloadAndShoot(FIRE_BULLETS_PER_TIME);
    } else {
      return 0;
    }
    return FIRE_BULLETS_PER_TIME;
  }
}
