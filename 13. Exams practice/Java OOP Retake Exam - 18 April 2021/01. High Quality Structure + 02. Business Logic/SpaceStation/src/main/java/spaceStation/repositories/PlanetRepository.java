package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;

public class PlanetRepository implements Repository<Planet> {
  private Collection<Planet> planets;

  @Override
  public Collection<Planet> getModels() {
    return this.planets;
  }

  @Override
  public void add(Planet planet) {
    this.planets.add(planet);
  }

  @Override
  public boolean remove(Planet planet) {
    return this.planets.remove(planet);
  }

  @Override
  public Planet findByName(String name) {
    return this.planets.stream()
            .filter(a -> a.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
