package viceCity.models.guns;

public class Rifle extends BaseGun{
  private static final int BULLETS_PER_BARREL = 50;
  private static  int CURRENT_BULLETS = 10;
  private static int TOTAL_BULLETS = 500;
  private static final int FIRE_BULLETS_PER_TIME = 5;

  public Rifle(String name) {
    super(name,  BULLETS_PER_BARREL, TOTAL_BULLETS);
  }

  @Override
  public int fire() {
    if (this.canFire() && CURRENT_BULLETS > 0) {
      CURRENT_BULLETS -= FIRE_BULLETS_PER_TIME;
    } else if (CURRENT_BULLETS == 0 && TOTAL_BULLETS >= BULLETS_PER_BARREL) {
      this.reloadGun();
    }
    return FIRE_BULLETS_PER_TIME;
  }

  private void reloadGun() {
    TOTAL_BULLETS -= BULLETS_PER_BARREL;
    CURRENT_BULLETS += BULLETS_PER_BARREL;
  }
  @Override
  public boolean canFire() {
    return super.getBulletsPerBarrel() >= FIRE_BULLETS_PER_TIME;
  }
}
