package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static int FIRE_RIFLE_BULLETS = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < FIRE_RIFLE_BULLETS) {
            return 0;
        }
        super.decreaseBullets(FIRE_RIFLE_BULLETS);
        return FIRE_RIFLE_BULLETS;
    }
}
