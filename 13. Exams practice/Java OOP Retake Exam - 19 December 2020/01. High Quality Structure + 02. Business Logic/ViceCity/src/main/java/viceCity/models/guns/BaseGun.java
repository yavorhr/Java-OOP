package viceCity.models.guns;

public abstract class BaseGun implements Gun {
  private String name;
  private int bulletsPerBarrel;
  private int totalBullets;
  private boolean canFire;

  public BaseGun(String name) {
    this.name = name;
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
  public boolean canFire() {
    return false;
  }

  @Override
  public int getTotalBullets() {
    return this.totalBullets;
  }


}
