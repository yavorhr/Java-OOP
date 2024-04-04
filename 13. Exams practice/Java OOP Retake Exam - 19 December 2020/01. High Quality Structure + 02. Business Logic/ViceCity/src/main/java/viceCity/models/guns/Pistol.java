package viceCity.models.guns;

public class Pistol extends BaseGun {
  private static int BULLETS_PER_BARREL = 10;
  private static int TOTAL_BULLETS = 100;
  private static int FIRE_BULLETS_PER_TIME = 1;

  public Pistol(String name) {
    super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
  }

  @Override
  public int fire() {
    if (this.canFire()) {
      super.decreaseBulletsPerBarrel(FIRE_BULLETS_PER_TIME);
    } else if (super.getTotalBullets() >= BULLETS_PER_BARREL) {
      super.reloadGun(BULLETS_PER_BARREL);
    }
    return FIRE_BULLETS_PER_TIME;
  }

  @Override
  public boolean canFire() {
    return super.getTotalBullets() >= FIRE_BULLETS_PER_TIME;
  }
}
