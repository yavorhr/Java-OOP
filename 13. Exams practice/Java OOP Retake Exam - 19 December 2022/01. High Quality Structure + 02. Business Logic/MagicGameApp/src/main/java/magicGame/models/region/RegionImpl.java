package magicGame.models.region;

import magicGame.common.OutputMessages;
import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class RegionImpl implements Region {

  public RegionImpl() {

  }

  @Override
  public String start(Collection<Magician> magicians) {
    List<Magician> wizards = getMagicians(magicians, "Wizard");
    List<Magician> blackWidows = getMagicians(magicians, "BlackWidow");

    while (aliveMagiciansLeft(wizards) && aliveMagiciansLeft(blackWidows)) {
      fight(wizards, blackWidows);

      blackWidows = filterAliveMagicians(blackWidows);

      wizards = filterAliveMagicians(wizards);
    }

    return getOutput(wizards, blackWidows);
  }

  // Helpers

  private boolean aliveMagiciansLeft(Collection<Magician> magicians) {
    return magicians.stream().anyMatch(Magician::isAlive);
  }

  private List<Magician> filterAliveMagicians(Collection<Magician> magicians) {
    return magicians
            .stream()
            .filter(Magician::isAlive)
            .collect(Collectors.toList());
  }

  private List<Magician> getMagicians(Collection<Magician> magicians, String type) {
    return magicians
            .stream()
            .filter(m -> m.getClass().getSimpleName().equals(type))
            .collect(Collectors.toList());
  }

  private String getOutput(Collection<Magician> wizards, Collection<Magician> blackWidows) {
    if (!aliveMagiciansLeft(wizards)) {
      return "Black widows win!";
    }
    return "Wizards win!";
  }

  private void fight(List<Magician> wizards, List<Magician> blackWidows) {
    for (Magician attacker : wizards) {
      for (Magician defender : blackWidows) {
        while (attacker.getMagic().getBulletsCount() > 0 && defender.isAlive()) {
          int damage = attacker.getMagic().fire();
          defender.takeDamage(damage);
        }
      }
    }
  }

}
