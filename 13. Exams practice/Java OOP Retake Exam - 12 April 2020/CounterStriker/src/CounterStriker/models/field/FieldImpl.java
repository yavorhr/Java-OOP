package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {


  @Override
  public String start(Collection<Player> players) {
    //1. Separate teams
    //2. Terrorist -> Counter Terrorist
    //3. Check if counterTerrorist are alive
    //4. Counter -> Terrorst
    //5. Check if Terrorist are alive

    List<Player> terrorists = getPlayers(players, "Terrorist");
    List<Player> counterTerrorists = getPlayers(players, "CounterTerrorist");

    while (teamIsNotKilled(terrorists) || teamIsNotKilled(counterTerrorists)) {
      startShooting(terrorists, counterTerrorists);
      counterTerrorists = filterAlivePlayers(counterTerrorists);

      if (teamIsDead(counterTerrorists)) {
        break;
      }
      startShooting(counterTerrorists, terrorists);

      terrorists = filterAlivePlayers(terrorists);

      if (teamIsDead(terrorists)) {
        break;
      }
    }

    if (terrorists.size() == 0) {
      return "Counter Terrorist wins!";
    }

    return "Terrorist wins!";
  }

  private boolean teamIsDead(List<Player> counterTerrorists) {
    if (counterTerrorists.size() == 0) {
      return true;
    }
    return false;
  }

  private List<Player> filterAlivePlayers(List<Player> counterTerrorists) {
    return counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
  }

  // Helpers
  private List<Player> getPlayers(Collection<Player> players, String terrorist) {
    return players.stream().filter(p -> getClass().getSimpleName().equals(terrorist)).collect(Collectors.toList());
  }

  private boolean teamIsNotKilled(Collection<Player> team) {
    return team.stream().anyMatch(Player::isAlive);
  }

  private void startShooting(Collection<Player> attackers, Collection<Player> defenders) {
    for (Player attacker : attackers) {
      int damage = attacker.getGun().fire();
      for (Player defender : defenders) {
        defender.takeDamage(damage);
      }
    }
  }
}
