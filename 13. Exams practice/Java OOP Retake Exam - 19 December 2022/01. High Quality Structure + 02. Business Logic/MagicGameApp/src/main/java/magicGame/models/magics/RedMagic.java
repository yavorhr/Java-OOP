package magicGame.models.magics;

public class RedMagic extends MagicImpl {
  private static final int SHOOT_BULLET_PER_TIME = 1;

  public RedMagic(String name, int bulletsCount) {
    super(name, bulletsCount);
  }

  @Override
  public int fire() {
    if (super.getBulletsCount() == 0) {
      return 0;
    }
    super.decreaseBulletsWhenShooting(SHOOT_BULLET_PER_TIME);

    return SHOOT_BULLET_PER_TIME;
  }
}
