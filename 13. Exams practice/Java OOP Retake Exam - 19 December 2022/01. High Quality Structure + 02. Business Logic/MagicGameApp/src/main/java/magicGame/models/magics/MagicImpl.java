package magicGame.models.magics;

public class MagicImpl implements Magic {
  private String name;
  private int bulletsCount;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getBulletsCount() {
    return this.bulletsCount;
  }

  @Override
  public int fire() {
    return 0;
  }
}
