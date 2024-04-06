package viceCity.models.guns;

public class Rifle extends BaseGun {
  private static final int BULLETS_PER_BARREL = 50;
  private static final int FIRE_BULLETS_PER_TIME = 5;
  private static final int INITIAL_TOTAL_BULLETS = 500;

  public Rifle(String name) {
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


