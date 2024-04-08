package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.validator.Validator;

public abstract class BaseExplorer implements Explorer {
  private String name;
  private double energy;
  private Suitcase suitcase;

  protected BaseExplorer(String name, double energy) {
    this.setName(name);
    this.setEnergy(energy);
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
  
  private void setName(String name) {
    Validator.validateName(name);
    this.name = name;
  }

  private void setEnergy(double energy) {
    Validator.validateEnergy(energy);
    this.energy = energy;
  }
}
