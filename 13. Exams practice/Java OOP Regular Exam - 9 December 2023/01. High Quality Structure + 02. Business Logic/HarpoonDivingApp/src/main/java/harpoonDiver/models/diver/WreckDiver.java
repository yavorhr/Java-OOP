package harpoonDiver.models.diver;

public class WreckDiver extends BaseDiver {
  private static final double INITIAL_OXYGEN_LEVEL = 150;

  protected WreckDiver(String name, double oxygen) {
    super(name, oxygen);
  }

  @Override
  public void shoot() {

  }
}
