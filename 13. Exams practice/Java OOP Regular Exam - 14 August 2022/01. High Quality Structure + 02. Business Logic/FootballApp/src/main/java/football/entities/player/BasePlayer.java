package football.entities.player;

public abstract class BasePlayer implements Player {
  private String name;
  private String nationality;
  private double kg;
  private int strength;

  protected BasePlayer(String name, String nationality, double kg, int strength) {
    this.name = name;
    this.nationality = nationality;
    this.kg = kg;
    this.strength = strength;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public double getKg() {
    return this.kg;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getStrength() {
    return this.strength;
  }
}
