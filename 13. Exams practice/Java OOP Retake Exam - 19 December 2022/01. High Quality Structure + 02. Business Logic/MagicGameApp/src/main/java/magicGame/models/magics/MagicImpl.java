package magicGame.models.magics;

public abstract class MagicImpl implements Magic {
  private String name;
  private int bulletsCount;

  public MagicImpl(String name, int bulletsCount) {
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

  protected void decreaseBulletsWhenShooting(int bullets) {
    this.bulletsCount -= bullets;
  }
}
