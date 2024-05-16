package football.entities.player;

import football.Validator.Validator;

public abstract class BasePlayer implements Player {
  private String name;
  private String nationality;
  private double kg;
  private int strength;

  protected BasePlayer(String name, String nationality, double kg, int strength) {
    this.setName(name);
    this.setNationality(nationality);
    this.kg = kg;
    this.setStrength(strength);
  }

  @Override
  public void setName(String name) {
    Validator.validatePlayerName(name);
    this.name = name;
  }

  @Override
  public double getKg() {
    return this.kg;
  }

  @Override
  public String getName() {
    Validator.validatePlayerName(name);
    return this.name;
  }

  @Override
  public int getStrength() {
    return this.strength;
  }

  protected void increaseStrength(int strength) {
    this.strength += strength;
  }

  private void setStrength(int strength) {
    Validator.validateStrength(strength);
    this.strength = strength;
  }

  private void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
