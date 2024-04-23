package harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {
  private static final double INITIAL_OXYGEN_LEVEL = 30;

  public OpenWaterDiver(String name) {
    super(name, INITIAL_OXYGEN_LEVEL);
  }


}
