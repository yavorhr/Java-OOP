package viceCity.models.guns;

public class Rifle extends BaseGun{
  private static int BULLETS_PER_BARREL = 50;
  private static int TOTAL_BULLETS = 500;
  private static int FIRE_BULLETS_PER_TIME = 5;

  public Rifle(String name) {
    super(name,  BULLETS_PER_BARREL, TOTAL_BULLETS);
  }

  @Override
  public int fire() {
    if (this.canFire()) {
      super.decreaseBulletsPerBarrel(FIRE_BULLETS_PER_TIME);
    } else if (!this.canFire()) {
      super.reloadGun(BULLETS_PER_BARREL);
    }
    return FIRE_BULLETS_PER_TIME;
  }

  @Override
  public boolean canFire() {
    return super.getBulletsPerBarrel() >= FIRE_BULLETS_PER_TIME;
  }
}
