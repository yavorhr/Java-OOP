package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
  private static double INITIAL_ENERGY = 60;

  protected AnimalExplorer(String name) {
    super(name, INITIAL_ENERGY);
  }

  @Override
  public void search() {

  }
}