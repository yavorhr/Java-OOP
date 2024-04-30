package climbers.models.climber;

public class RockClimber extends BaseClimber {
  protected static final double INITIAL_STRENGTH = 120;
  protected static final double DECREASE_STRENGTH_VALUE = 60;


  protected RockClimber(String name) {
    super(name, INITIAL_STRENGTH);
  }

  @Override
  public void climb() {
    super.decreaseStrengthWhenClimbing(DECREASE_STRENGTH_VALUE);
  }
}
