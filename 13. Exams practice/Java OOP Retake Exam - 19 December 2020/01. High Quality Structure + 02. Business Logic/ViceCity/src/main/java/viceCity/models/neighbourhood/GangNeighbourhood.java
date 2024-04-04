package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {

  @Override
  public void action(Player mainPlayer, Collection<Player> civilPlayers) {
    Collection<Gun> playerGuns = getPlayerGuns(mainPlayer);

    for (Gun gun : playerGuns) {
      for (Player civilPlayer : civilPlayers) {
        while (gun.canFire() && civilPlayer.isAlive()) {
          civilPlayer.takeLifePoints(gun.fire());
        }
      }
    }
    civilPlayers = filterAliveCivilPlayers(civilPlayers);

    for (Player civilPlayer : civilPlayers) {
      Collection<Gun> civilPlayerGuns = getPlayerGuns(civilPlayer);

      for (Gun gun : civilPlayerGuns) {
        while (gun.canFire() && mainPlayer.isAlive()) {
          mainPlayer.takeLifePoints(gun.fire());
        }
      }
    }
  }



  private Collection<Player> filterAliveCivilPlayers(Collection<Player> civilPlayers) {
    return civilPlayers
            .stream()
            .filter(Player::isAlive)
            .collect(Collectors.toList());
  }

  private boolean allPlayersAreDead(Collection<Player> civilPlayers) {
    return civilPlayers.stream().noneMatch(Player::isAlive);
  }

  private Collection<Gun> getPlayerGuns(Player player) {
    return player.getGunRepository().getModels();
  }
}
