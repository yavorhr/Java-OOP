package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
  private static final double INITIAL_OXYGEN = 50;
  private static final double DECREASE_VALUE_ON_BREATHE = 10;

  public Geodesist(String name) {
    super(name, INITIAL_OXYGEN);
  }

  @Override
  public void breath() {
    super.decreaseOxygenWhenBreathe(DECREASE_VALUE_ON_BREATHE);
  }
}
