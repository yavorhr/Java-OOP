package harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {
  private static double INITIAL_OXYGEN_LEVEL = 30;

  protected OpenWaterDiver(String name) {
    super(name, INITIAL_OXYGEN_LEVEL);
  }

  @Override
  public void shoot() {

  }
}
