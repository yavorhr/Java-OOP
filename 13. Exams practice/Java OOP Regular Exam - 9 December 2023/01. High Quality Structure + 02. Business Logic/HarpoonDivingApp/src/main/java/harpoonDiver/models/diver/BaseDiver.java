package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;
import harpoonDiver.validation.Validator;

public abstract class BaseDiver implements Diver {
  private String name;
  private double oxygen;
  private SeaCatch seaCatch;

  protected BaseDiver(String name, double oxygen) {
    this.setName(name);
    this.setOxygen(oxygen);
    this.seaCatch = new BaseSeaCatch();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getOxygen() {
    return this.oxygen;
  }

  @Override
  public boolean canDive() {
    return this.oxygen > 0;
  }

  @Override
  public SeaCatch getSeaCatch() {
    return this.seaCatch;
  }

  @Override
  public void shoot() {

  }

  private void setOxygen(double oxygen) {
    Validator.validateDiversOxygen(oxygen);
    this.oxygen = oxygen;
  }

  private void setName(String name) {
    Validator.validateDiverName(name);
    this.name = name;
  }
}
