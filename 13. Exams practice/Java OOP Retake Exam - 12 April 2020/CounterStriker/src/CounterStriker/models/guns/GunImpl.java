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
}
