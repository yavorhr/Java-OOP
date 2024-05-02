package handball.entities.team;

import handball.Validator.Validator;

public abstract class BaseTeam implements Team {
  private String name;
  private String country;
  private int advantage;

  protected BaseTeam(String name, String country, int advantage) {
    this.setName(name);
    this.setCountry(country);
    this.setAdvantage(advantage);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getAdvantage() {
    return this.advantage;
  }

  @Override
  public void setName(String name) {
    Validator.validateTeamName(name);
    this.name = name;
  }

  protected void setAdvantage(int advantage) {
    Validator.validateAdvantage(advantage);
    this.advantage = advantage;
  }

  public void setCountry(String country) {
    Validator.validateCountryName(country);
    this.country = country;
  }
}
