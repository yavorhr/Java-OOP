package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
  private static int INITIAL_ENERGY = 60;

  public NaturalExplorer(String name) {
    super(name, INITIAL_ENERGY);
  }

  @Override
  public void search() {
    super.decreaseEnergy(INITIAL_ENERGY);
  }
}
