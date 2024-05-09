package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.factory.AstronautFactory;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.Repository;

public class ControllerImpl implements Controller {
  Repository<Astronaut> astronautRepository;

  public ControllerImpl() {
    astronautRepository = new AstronautRepository();
  }

  @Override
  public String addAstronaut(String type, String astronautName) {
    Astronaut astronaut = AstronautFactory.create(type, astronautName);
    this.astronautRepository.add(astronaut);

    return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
  }

  @Override
  public String addPlanet(String planetName, String... items) {
    return null;
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
