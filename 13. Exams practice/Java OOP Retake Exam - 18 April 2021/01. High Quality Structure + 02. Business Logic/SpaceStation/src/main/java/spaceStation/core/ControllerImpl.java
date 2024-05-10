package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.factory.AstronautFactory;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private Repository<Astronaut> astronautRepository;
  private Repository<Planet> planetRepository;
  private Mission mission;

  public ControllerImpl() {
    this.astronautRepository = new AstronautRepository();
    this.planetRepository = new PlanetRepository();
    this.mission = new MissionImpl();
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
    Astronaut astronaut = this.astronautRepository.findByName(astronautName);

    if (astronaut == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
    }

    this.astronautRepository.remove(astronaut);
    return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronaut);
  }

  @Override
  public String explorePlanet(String planetName) {
    Planet planet = this.planetRepository.findByName(planetName);
    List<Astronaut> astronauts = getAstronautsWithEnoughOxygen();
    int initAstronautsSize = astronauts.size();

    if (astronauts.size() == 0) {
      throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
    }

    this.mission.explore(planet, astronauts);

    return String.format(ConstantMessages.PLANET_EXPLORED, planetName, getDeadAstronauts(initAstronautsSize));
  }


  @Override
  public String report() {
    return null;
  }

  // Helpers
  private List<Astronaut> getAstronautsWithEnoughOxygen() {
    return this.astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
  }

  private int getDeadAstronauts(int size) {
    return size - getAstronautsWithEnoughOxygen().size();
  }
}
