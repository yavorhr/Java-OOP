package climbers.models.climber;

import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;
import climbers.validation.Validator;

public abstract class BaseClimber implements Climber {
  private String name;
  private double strength;
  private Roster roster;

  protected BaseClimber(String name, double strength) {
    this.setName(name);
    this.setStrength(strength);
    this.roster = new RosterImpl();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getStrength() {
    return this.strength;
  }

  @Override
  public boolean canClimb() {
    return this.strength > 0;
  }

  @Override
  public Roster getRoster() {
    return this.roster;
  }

  protected void decreaseStrengthWhenClimbing(double strengthValue) {
    this.strength -= strengthValue;

    if (this.strength < 0) {
      this.strength = 0;
    }
  }

  private void setName(String name) {
    Validator.validateClimberName(name);
    this.name = name;
  }

  private void setStrength(double strength) {
    Validator.validateClimberStrength(strength);
    this.strength = strength;
  }
}
