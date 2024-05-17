package football.repositories;

import football.common.ExceptionMessages;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;

public class PlayerFactory {
  public static Player create(String playerType, String playerName, String nationality, int strength) {
    Player player = null;

    switch (playerType) {
      case "Men" -> player = new Men(playerName, nationality, strength);
      case "Women" -> player = new Women(playerName, nationality, strength);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
    }

    return player;
  }
}
