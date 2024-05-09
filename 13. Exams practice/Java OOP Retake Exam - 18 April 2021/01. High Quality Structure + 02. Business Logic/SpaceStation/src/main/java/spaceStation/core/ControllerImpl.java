package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.factory.AstronautFactory;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;

public class ControllerImpl implements Controller {
  Repository<Astronaut> astronautRepository;
  Repository<Planet> planetRepository;

  public ControllerImpl() {
    this.astronautRepository = new AstronautRepository();
    this.planetRepository = new PlanetRepository();
  }

  @Override
  public String addAstronaut(String type, String astronautName) {
    Astronaut astronaut = AstronautFactory.create(type, astronautName);
    this.astronautRepository.add(astronaut);

    return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
  }

  @Override
  public String addPlanet(String planetName, String... items) {
    Planet planet = createPlanet(planetName, items);
    this.planetRepository.add(planet);

    return String.format(ConstantMessages.PLANET_ADDED, planetName);
  }

  private Planet createPlanet(String planetName, String[] items) {
    Planet planet = new PlanetImpl(planetName);
    if (items.length > 0) {
      Arrays.stream(items).forEach(i -> planet.getItems().add(i));
    }

    return planet;
  }

  @Override
  public String retireAstronaut(String astronautName) {
    return null;
  }

  @Override
  public String explorePlanet(String planetName) {
    return null;
  }

  @Override
  public String report() {
    return null;
  }
}
