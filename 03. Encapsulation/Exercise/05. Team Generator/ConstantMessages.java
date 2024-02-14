public class ConstantMessages {
  public static final String INVALID_NAME = "A name should not be empty.";

  public static String invalidStatInout(String stat) {
    return String.format("%s should be between 0 and 100.", stat);
  }

  public static String invalidPlayer(String player, String team) {
    return String.format("Player %s is not in %s team.", player, team);
  }

  public static String invalidTeam(String team) {
    return String.format("Team %s does not exist.", team);
  }
}
