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
    List<Magician> wizards = divideMagiciansByType(magicians, "Wizard");
    List<Magician> blackWidows = divideMagiciansByType(magicians, "BlackWidow");

    while (aliveMagiciansLeft(wizards) && aliveMagiciansLeft(blackWidows)) {
      fight(wizards, blackWidows);
      blackWidows = filterLiveMagicians(blackWidows);

      if (!aliveMagiciansLeft(blackWidows)){
        break;
      }

      fight(blackWidows, wizards);
      wizards = filterLiveMagicians(wizards);
    }

    return getOutput(wizards);
  }

  // Helpers
  private boolean aliveMagiciansLeft(Collection<Magician> magicians) {
    return magicians.stream().anyMatch(Magician::isAlive);
  }

  private List<Magician> filterLiveMagicians(Collection<Magician> magicians) {
    return magicians
            .stream()
            .filter(Magician::isAlive)
            .collect(Collectors.toList());
  }

  private List<Magician> divideMagiciansByType(Collection<Magician> magicians, String type) {
    return magicians
            .stream()
            .filter(m -> m.getClass().getSimpleName().equals(type))
            .collect(Collectors.toList());
  }


  private void fight(List<Magician> wizards, List<Magician> blackWidows) {
    Magician attacker = wizards.stream().filter(w -> w.getMagic().getBulletsCount() > 0).findFirst().orElse(null);
    Magician defender = blackWidows.get(0);

    while (canShoot(attacker) && defender.isAlive()) {
      int damage = attacker.getMagic().fire();

      if (damage == 0) {
        break;
      }

      defender.takeDamage(damage);
    }
  }

  private boolean canShoot(Magician attacker) {
    return attacker.getMagic().getBulletsCount() > 0;
  }

  private String getOutput(Collection<Magician> wizards) {
    if (!aliveMagiciansLeft(wizards)) {
      return "Black widows win!";
    }
    return "Wizards win!";
  }
}
