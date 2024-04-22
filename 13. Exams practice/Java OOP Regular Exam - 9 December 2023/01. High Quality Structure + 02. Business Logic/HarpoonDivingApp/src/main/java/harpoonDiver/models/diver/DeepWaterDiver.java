package harpoonDiver.models.diver;

public class DeepWaterDiver extends BaseDiver {
  private static final double INITIAL_OXYGEN_LEVEL = 90;

  public DeepWaterDiver(String name) {
    super(name, INITIAL_OXYGEN_LEVEL);
  }

  @Override
  public void shoot() {

  }
}
