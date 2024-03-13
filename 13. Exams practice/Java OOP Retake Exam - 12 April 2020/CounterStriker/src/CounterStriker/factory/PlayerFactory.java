package CounterStriker.factory;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

public class PlayerFactory {
  public static Player createPlayer(String type, String username, int health, int armor, Gun gun) {
    Player player = null;

    switch (type) {
      case "Terrorist" -> player = new Terrorist(username, health, armor, gun);
      case "CounterTerrorist" -> player = new CounterTerrorist(username, health, armor, gun);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
    }
    return player;
  }
}
