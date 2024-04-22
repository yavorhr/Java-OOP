package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver {
  private String name;
  private double oxygen;
  private SeaCatch seaCatch;

  protected BaseDiver(String name, double oxygen) {
    this.name = name;
    this.oxygen = oxygen;
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
  
}
