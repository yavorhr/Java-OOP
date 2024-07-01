package magicGame.models.magics;

public class BlackMagic extends MagicImpl {
  private static final int SHOOT_BULLET_PER_TIME = 10;
  private int bullets = super.getBulletsCount();

  public BlackMagic(String name, int bulletsCount) {
    super(name, bulletsCount);
  }

  @Override
  public int fire() {
    if (bullets - SHOOT_BULLET_PER_TIME < 0) {
      bullets = 0;
      return 0;
    } else {
      bullets -= SHOOT_BULLET_PER_TIME;
      return SHOOT_BULLET_PER_TIME;
    }
  }
}
