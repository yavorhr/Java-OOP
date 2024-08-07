package football.entities.player;

public class Men extends BasePlayer {
  private static final double INITIAL_KG = 85;
  private static final int STIMULATE_STRENGTH_VALUE = 145;

  public Men(String name, String nationality, int strength) {
    super(name, nationality, INITIAL_KG, strength);
  }

  @Override
  public void stimulation() {
    super.increaseStrength(STIMULATE_STRENGTH_VALUE);
  }
}
