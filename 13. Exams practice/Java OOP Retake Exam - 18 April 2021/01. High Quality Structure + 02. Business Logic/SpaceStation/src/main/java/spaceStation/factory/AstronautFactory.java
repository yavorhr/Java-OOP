package spaceStation.factory;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;

public class AstronautFactory {
  public Astronaut create(String type, String name) {
    Astronaut astronaut = null;

    switch (type) {
      case "Biologist" -> astronaut = new Biologist(name);
      case "Geodesist" -> astronaut = new Geodesist(name);
      case "Meteorologist" -> astronaut = new Meteorologist(name);
      default -> throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
    }

    return astronaut;
  }
}
