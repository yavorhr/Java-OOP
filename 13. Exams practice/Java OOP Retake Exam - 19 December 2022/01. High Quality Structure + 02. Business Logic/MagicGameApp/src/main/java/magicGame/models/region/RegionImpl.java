package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class RegionImpl implements Region {

  public RegionImpl() {

  }

  @Override
  public String start(Collection<Magician> magicians) {
    Collection<Magician> wizards = getMagicians(magicians, "Wizard");
    Collection<Magician> blackWidows = getMagicians(magicians, "Black Widow");

    while (!wizards.isEmpty() || !blackWidows.isEmpty()) {
      for (Magician attacker : wizards) {
        for (Magician defender : blackWidows) {
          int damage = attacker.getMagic().fire();

          if (damage == 0) {
            break;
          }
          defender.takeDamage(damage);
        }
      }

      blackWidows = filterAliveMagicians(blackWidows);
    }


    return null;
  }

  //Helpers

  private List<Magician> filterAliveMagicians(Collection<Magician> magicians) {
    return magicians
            .stream()
            .filter(Magician::isAlive)
            .collect(Collectors.toList());;
  }

  private List<Magician> getMagicians(Collection<Magician> magicians, String type) {
    return magicians
            .stream()
            .filter(m -> m.getClass().getSimpleName().equals(type))
            .collect(Collectors.toList());
  }
}
