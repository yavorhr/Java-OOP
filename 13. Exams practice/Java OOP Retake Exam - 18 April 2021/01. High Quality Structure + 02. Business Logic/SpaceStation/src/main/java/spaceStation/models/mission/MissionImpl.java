package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
  private static int MISSIONS_COUNT = 0;

  @Override
  public void explore(Planet planet, Collection<Astronaut> astronauts) {
    MISSIONS_COUNT++;
    while (planet.getItems().size() > 0 && astronautsLeft(astronauts)) {
      for (Astronaut astronaut : astronauts) {
        while (astronaut.canBreath() && !"".equals(getItem(planet))) {
          String item = getItem(planet);

          astronaut.getBag().getItems().add(item);
          planet.getItems().remove(item);
          astronaut.breath();
        }
      }
    }
  }

  @Override
  public int getExploredPlanets() {
    return MISSIONS_COUNT;
  }


  // Helpers
  private boolean astronautsLeft(Collection<Astronaut> astronauts) {
    return astronauts.stream().anyMatch(Astronaut::canBreath);
  }

  private String getItem(Planet planet) {
    return planet.getItems().stream().findFirst().orElse("");
  }
}
