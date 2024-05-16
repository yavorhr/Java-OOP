package football.entities.player;

public class Women extends BasePlayer {
  private static final double INITIAL_KG = 60;
  private static final int STIMULATE_STRENGTH_VALUE = 115;

  protected Women(String name, String nationality, int strength) {
    super(name, nationality, INITIAL_KG, strength);
  }

  @Override
  public void stimulation() {
    super.increaseStrength(STIMULATE_STRENGTH_VALUE);
  }
}
