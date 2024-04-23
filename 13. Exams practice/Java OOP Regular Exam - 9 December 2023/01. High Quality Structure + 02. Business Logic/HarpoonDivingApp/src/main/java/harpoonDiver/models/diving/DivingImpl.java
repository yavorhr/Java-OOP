package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Optional;

public class DivingImpl implements Diving {

  @Override
  public void searching(DivingSite divingSite, Collection<Diver> divers) {
    for (Diver diver : divers) {
      while (diver.getOxygen() >= 0 && divingSite.getSeaCreatures().size() > 0) {
        diver.shoot();
        String creature = divingSite
                .getSeaCreatures()
                .stream()
                .findFirst()
                .orElse("");

        divingSite.getSeaCreatures().remove(creature);
        diver.getSeaCatch().getSeaCreatures().add(creature);
      }
    }
  }
}
