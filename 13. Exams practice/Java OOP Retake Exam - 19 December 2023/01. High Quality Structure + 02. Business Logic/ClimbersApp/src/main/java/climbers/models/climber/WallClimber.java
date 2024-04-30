package climbers.models.climber;

public class WallClimber extends BaseClimber {
  protected static final double INITIAL_STRENGTH = 90;

  public WallClimber(String name) {
    super(name, INITIAL_STRENGTH);
  }

  @Override
  public void climb() {

  }
}
