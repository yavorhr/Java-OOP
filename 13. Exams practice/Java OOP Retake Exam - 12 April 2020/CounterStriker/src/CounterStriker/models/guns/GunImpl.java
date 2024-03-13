package CounterStriker.models.guns;

import CounterStriker.validator.Validator;

public abstract class GunImpl implements Gun {
  private String name;
  private int bulletsCount;

  public GunImpl(String name, int bulletsCount) {
    this.setName(name);
    this.setBulletsCount(bulletsCount);
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
    Validator.throwErrIfBulletsAreOver(this.getBulletsCount());
    this.bulletsCount = bulletsCount;
  }

  protected void shoot(int bulletsPerTime) {
    this.bulletsCount -= bulletsPerTime;
  }
}
