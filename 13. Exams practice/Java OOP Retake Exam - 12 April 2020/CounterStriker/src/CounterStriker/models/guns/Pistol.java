package CounterStriker.models.guns;

public class Pistol extends GunImpl {
  private static final int BULLETS_PER_TIME = 1;

  public Pistol(String name, int bulletsCount) {
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
