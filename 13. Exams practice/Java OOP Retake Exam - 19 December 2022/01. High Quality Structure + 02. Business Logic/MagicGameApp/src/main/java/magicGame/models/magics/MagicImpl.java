package magicGame.models.magics;

import validator.Validator;

public abstract class MagicImpl implements Magic {
  private String name;
  private int bulletsCount;

  public MagicImpl(String name, int bulletsCount) {
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

  protected void decreaseBulletsWhenShooting(int bullets) {
    this.bulletsCount -= bullets;
  }

  private void setName(String name) {
    Validator.validateMagicName(name);
    this.name = name;
  }

  private void setBulletsCount(int bulletsCount) {
    Validator.validateBulletsCount(bulletsCount);
    this.bulletsCount = bulletsCount;
  }
}
