import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, Team> teamsMap = new HashMap<>();

    String input = scanner.nextLine();
    while (!"END".equals(input)) {
      String[] tokens = input.split(";");
      String command = tokens[0];
      String teamName = tokens[1];

      try {
        switch (command) {
          case "Add" -> {
            if (!Validator.doesTeamExist(teamsMap, teamName)) {
              throw new IllegalArgumentException(ConstantMessages.invalidTeam(teamName));
            }

            addPlayerToTeam(teamsMap.get(teamName), tokens);
          }
          case "Remove" -> {
            if (!Validator.doesTeamExist(teamsMap, teamName)) {
              throw new IllegalArgumentException(ConstantMessages.invalidTeam(teamName));
            }

            String playerName = tokens[2];
            teamsMap.get(teamName).removePlayer(playerName);
          }
          case "Team" -> teamsMap.putIfAbsent(teamName, new Team(teamName));
          case "Rating" -> {
            if (!Validator.doesTeamExist(teamsMap, teamName)) {
              throw new IllegalArgumentException(ConstantMessages.invalidTeam(teamName));
            }
            double rating = teamsMap.get(teamName).getRating();
            printRating(teamName,rating);
          }
        }
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }

      input = scanner.nextLine();
    }
  }

  private static void printRating(String teamName, double rating) {
    System.out.printf("%s - %.0f", teamName,rating);
  }

  private static void addPlayerToTeam(Team team, String[] tokens) {
    String playerName = tokens[2];
    int endurance = Integer.parseInt(tokens[3]);
    int sprint = Integer.parseInt(tokens[4]);
    int dribble = Integer.parseInt(tokens[5]);
    int passing = Integer.parseInt(tokens[6]);
    int shooting = Integer.parseInt(tokens[7]);
    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

    team.addPlayer(player);
  }
}
