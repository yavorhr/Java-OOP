package CounterStriker.models.guns;

public abstract class GunImpl implements Gun {
  private String name;
  private int bulletsCount;

  public GunImpl(String name, int bulletsCount) {
    this.name = name;
    this.bulletsCount = bulletsCount;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getBulletsCount() {
    return this.bulletsCount;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBulletsCount(int bulletsCount) {
    this.bulletsCount = bulletsCount;
  }

  protected void shoot(int bulletsPerTime) {
    this.bulletsCount -= bulletsPerTime;
  }
}
