package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static int FIRE_PISTOL_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < FIRE_PISTOL_BULLETS) {
            return 0;
        }
        super.decreaseBullets(FIRE_PISTOL_BULLETS);
        return FIRE_PISTOL_BULLETS;
    }
}
