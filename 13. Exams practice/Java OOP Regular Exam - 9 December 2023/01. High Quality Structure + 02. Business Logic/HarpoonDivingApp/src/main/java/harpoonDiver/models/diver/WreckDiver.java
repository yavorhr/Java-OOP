package harpoonDiver.models.diver;

public class WreckDiver extends BaseDiver {
  private static final double INITIAL_OXYGEN_LEVEL = 150;

  public WreckDiver(String name) {
    super(name, INITIAL_OXYGEN_LEVEL);
  }

}
