package viceCity.models.guns;

public class Pistol extends BaseGun {
  private static final int BULLETS_PER_BARREL = 10;
  private static final int FIRE_BULLETS_PER_TIME = 1;
  private static final int INITIAL_TOTAL_BULLETS = 100;

  private int currentBullets;
  private int currentTotalBullets;

  public Pistol(String name) {
    super(name, BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
    this.currentBullets = BULLETS_PER_BARREL;
    this.currentTotalBullets = INITIAL_TOTAL_BULLETS;
  }

  @Override
  public int fire() {
    if (this.canFire() && this.currentBullets > 0) {
      this.currentBullets -= FIRE_BULLETS_PER_TIME;
    } else if (this.currentBullets == 0 && this.currentTotalBullets >= BULLETS_PER_BARREL) {
      this.reloadGunAndShoot();
    } else {
      return 0;
    }

    return FIRE_BULLETS_PER_TIME;
  }

  @Override
  public boolean canFire() {
    return this.currentTotalBullets >= BULLETS_PER_BARREL || this.currentBullets > 0;
  }

  private void reloadGunAndShoot() {
    this.currentTotalBullets -= BULLETS_PER_BARREL;
    this.currentBullets += BULLETS_PER_BARREL;
    this.currentBullets -= FIRE_BULLETS_PER_TIME;
  }
}
