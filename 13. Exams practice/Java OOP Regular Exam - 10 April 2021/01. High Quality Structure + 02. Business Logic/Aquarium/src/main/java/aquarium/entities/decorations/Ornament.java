package aquarium.entities.decorations;

public class Ornament extends BaseDecoration {
  private static final double PRICE = 5.00;
  private static final int COMFORT = 1;

  public Ornament() {
    super(COMFORT, PRICE);
  }
}
