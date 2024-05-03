package handball.factory;

import handball.common.ExceptionMessages;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;

public class TeamFactory {
  public static Team create(String type, String teamName, String country, int advantage) {
    Team team;

    switch (type) {
      case "Germany" -> team = new Germany(teamName, country, advantage);
      case "Bulgaria" -> team = new Bulgaria(teamName, country, advantage);
      default -> throw new IllegalArgumentException(ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY);
    }
    return team;
  }
}
