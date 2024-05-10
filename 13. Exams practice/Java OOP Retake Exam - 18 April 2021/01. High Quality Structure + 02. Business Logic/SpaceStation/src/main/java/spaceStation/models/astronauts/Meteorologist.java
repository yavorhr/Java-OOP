package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
  private static final double INITIAL_OXYGEN = 90;
  private static final double DECREASE_VALUE_ON_BREATHE = 10;

  public Meteorologist(String name) {
    super(name, INITIAL_OXYGEN);
  }

  @Override
  public void breath() {
    super.decreaseOxygenWhenBreathe(DECREASE_VALUE_ON_BREATHE);
  }
}
