package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
  private static double INITIAL_ENERGY = 40;

  protected GlacierExplorer(String name) {
    super(name, INITIAL_ENERGY);
  }

  @Override
  public void search() {

  }
}
