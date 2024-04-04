package viceCity.models.guns;

public abstract class BaseGun implements Gun {
  private String name;
  private int bulletsPerBarrel;
  private int totalBullets;

  public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
    this.name = name;
    this.bulletsPerBarrel = bulletsPerBarrel;
    this.totalBullets = totalBullets;
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

  public void decreaseBulletsPerBarrel(int bulletsPerBarrel) {
    this.bulletsPerBarrel -= bulletsPerBarrel;
  }

  public void reloadGun(int newBullets) {
    this.totalBullets -= newBullets;
    this.bulletsPerBarrel += newBullets;
  }
}
