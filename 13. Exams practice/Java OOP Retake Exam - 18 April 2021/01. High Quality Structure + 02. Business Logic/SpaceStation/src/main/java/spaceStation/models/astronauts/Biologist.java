package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
  private static final double INITIAL_OXYGEN = 70;
  private static final double DECREASE_VALUE_ON_BREATHE = 5;

  public Biologist(String name) {
    super(name, INITIAL_OXYGEN);
  }

  @Override
  public void breath() {
    super.decreaseOxygenWhenBreathe(DECREASE_VALUE_ON_BREATHE);
  }
}
