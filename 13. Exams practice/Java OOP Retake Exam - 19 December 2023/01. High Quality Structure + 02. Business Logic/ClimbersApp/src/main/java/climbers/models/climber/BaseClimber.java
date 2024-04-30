package climbers.models.climber;

import climbers.models.roster.Roster;

public abstract class BaseClimber implements Climber {
  private String name;
  private double strength;
  private Roster roster;

  protected BaseClimber(String name, double strength) {
    this.name = name;
    this.strength = strength;
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
}
