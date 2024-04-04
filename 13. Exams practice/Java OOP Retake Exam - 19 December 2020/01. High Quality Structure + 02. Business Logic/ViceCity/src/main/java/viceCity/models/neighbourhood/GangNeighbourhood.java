package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

  @Override
  public void action(Player mainPlayer, Collection<Player> civilPlayers) {
    Collection<Gun> playerGuns = mainPlayer.getGunRepository().getModels();

    for (Player currentCivilPlayer : civilPlayers) {
      for (Gun currentGun : playerGuns) {
        while (currentGun.canFire() && currentCivilPlayer.isAlive()) {
            currentCivilPlayer.takeLifePoints(currentGun.fire());
        }
      }
    }
  }
}
