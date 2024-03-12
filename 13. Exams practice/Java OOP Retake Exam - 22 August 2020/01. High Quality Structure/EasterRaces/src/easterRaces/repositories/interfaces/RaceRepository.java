package easterRaces.repositories.interfaces;

import easterRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RaceRepository implements Repository<Race> {
  List<Race> races;

  public RaceRepository() {
    this.races = new ArrayList<>();
  }

  @Override
  public Race getByName(String race) {
    return this.races.stream()
            .filter(c -> c.getName().equals(race))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Race> getAll() {
    return this.races;
  }

  @Override
  public void add(Race race) {
    this.races.add(race);
  }

  @Override
  public boolean remove(Race race) {
    return this.races.remove(race);
  }
}
