package spaceStation.models.planets;

import spaceStation.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet {
  private String name;
  private List<String> items;

  public PlanetImpl(String name) {
    this.setName(name);
    this.items = new ArrayList<>();
  }

  @Override
  public Collection<String> getItems() {
    return this.items;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    Validator.validatePlanetName(name);
    this.name = name;
  }
}
