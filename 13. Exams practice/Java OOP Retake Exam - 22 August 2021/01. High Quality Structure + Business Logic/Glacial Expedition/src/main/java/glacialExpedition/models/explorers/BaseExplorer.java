package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {
  private String name;
  private double energy;
  private Suitcase suitcase;

  protected BaseExplorer(String name, double energy) {
    this.name = name;
    this.energy = energy;
    this.suitcase = new Carton();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getEnergy() {
    return this.energy;
  }

  @Override
  public boolean canSearch() {
    return this.energy > 0;
  }

  @Override
  public Suitcase getSuitcase() {
    return this.suitcase;
  }

  @Override
  public void search() {

  }
}
