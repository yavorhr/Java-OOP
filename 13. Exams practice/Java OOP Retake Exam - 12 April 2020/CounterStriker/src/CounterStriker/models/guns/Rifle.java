package CounterStriker.models.guns;

public class Rifle extends GunImpl {
  private static final int BULLETS_PER_TIME = 10;

  public Rifle(String name, int bulletsCount) {
    super(name, bulletsCount);
  }

  @Override
  public int fire() {
    if (super.getBulletsCount() < BULLETS_PER_TIME) {
      return 0;
    }
    super.shoot(BULLETS_PER_TIME);
    return BULLETS_PER_TIME;
  }
}
