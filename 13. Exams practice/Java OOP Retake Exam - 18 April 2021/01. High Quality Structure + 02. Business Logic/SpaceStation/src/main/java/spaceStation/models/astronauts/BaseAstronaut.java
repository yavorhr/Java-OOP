package spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;
import spaceStation.validator.Validator;

public abstract class BaseAstronaut implements Astronaut {
  private String name;
  private double oxygen;
  private Bag bag;

  protected BaseAstronaut(String name, double oxygen) {
    this.setName(name);
    this.setOxygen(oxygen);
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
  public boolean canBreath() {
    return this.oxygen > 0;
  }

  @Override
  public Bag getBag() {
    return this.bag;
  }

  protected void decreaseOxygenWhenBreathe(double value) {
    this.oxygen -= value;

    if (oxygen < 0) {
      oxygen = 0;
    }
  }

  private void setName(String name) {
    Validator.validateAstronautName(name);
    this.name = name;
  }

  public void setOxygen(double oxygen) {
    Validator.validateAstronautOxygen(oxygen);
    this.oxygen = oxygen;
  }
}
