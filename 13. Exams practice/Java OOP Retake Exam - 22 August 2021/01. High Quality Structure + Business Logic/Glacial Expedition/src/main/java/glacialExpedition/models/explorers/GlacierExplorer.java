package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
  private static int INITIAL_ENERGY = 40;

  public GlacierExplorer(String name) {
    super(name, INITIAL_ENERGY);
  }

  @Override
  public void search() {
    super.decreaseEnergy(INITIAL_ENERGY);
  }
}
