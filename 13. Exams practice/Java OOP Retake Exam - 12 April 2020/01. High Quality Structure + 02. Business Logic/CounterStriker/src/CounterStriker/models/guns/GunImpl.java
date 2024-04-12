package CounterStriker.models.guns;

import CounterStriker.validator.Validator;

public abstract class GunImpl implements Gun {
  private String name;
  private int bulletsCount;
  private final int bulletsPerTime;

  public GunImpl(String name, int bulletsCount, int bulletsPerTime) {
    this.setName(name);
    this.setBulletsCount(bulletsCount);
    this.bulletsPerTime = bulletsPerTime;
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
    Validator.throwErrorIfGunNameIsNullOrEmpty(name);
    this.name = name;
  }

  public void setBulletsCount(int bulletsCount) {
    Validator.throwErrIfBulletsAreOver(bulletsCount);
    this.bulletsCount = bulletsCount;
  }

  protected void shoot(int bulletsPerTime) {
    this.bulletsCount -= bulletsPerTime;
  }

  @Override
  public int fire() {
    Validator.throwErrIfBulletsAreOver(this.getBulletsCount());

    if (this.getBulletsCount() < this.bulletsPerTime) {
      return 0;
    }

    this.shoot(this.bulletsPerTime);
    return this.bulletsPerTime;
  }
}
