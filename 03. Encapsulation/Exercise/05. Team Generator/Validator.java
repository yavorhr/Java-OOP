import java.util.List;
import java.util.Map;

public class Validator {
  public static boolean invalidName(String name) {
    return name.trim().length() <= 0;
  }

  public static boolean invalidStat(int value) {
    return value < 0 || value > 100;
  }

  public static boolean doesTeamExist(Map<String, Team> teamsMap, String teamName) {
    return teamsMap.containsKey(teamName);
  }

  public static boolean doesTeamContainPlayer(List<Player> players, Player player) {
    return players.contains(player);
  }
}