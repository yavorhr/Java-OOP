package viceCity.models.guns;

public abstract class BaseGun implements Gun {
  private String name;
  private final int bulletsPerBarrel;
  private final int totalBullets;

  private int currentBullets;
  private int currentTotalBullets;

  public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
    this.name = name;
    this.bulletsPerBarrel = bulletsPerBarrel;
    this.totalBullets = totalBullets;

    this.currentBullets = bulletsPerBarrel;
    this.currentTotalBullets = totalBullets;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getBulletsPerBarrel() {
    return this.bulletsPerBarrel;
  }

  @Override
  public int getTotalBullets() {
    return this.totalBullets;
  }

  @Override
  public boolean canFire() {
    return this.currentBullets > 0;
  }

  public boolean hasAmmo() {
    return this.currentTotalBullets >= this.bulletsPerBarrel;
  }

  protected void setCurrentBullets(int firedBullets) {
    this.currentBullets -= firedBullets;
  }

  protected void reloadAndShoot(int shootPerTime) {
    this.currentTotalBullets -= this.bulletsPerBarrel;
    this.currentBullets += this.bulletsPerBarrel;
    this.currentBullets -= shootPerTime;
  }

  @Override
  public int getCurrentTotalBullets() {
    return this.currentTotalBullets;
  }
}
