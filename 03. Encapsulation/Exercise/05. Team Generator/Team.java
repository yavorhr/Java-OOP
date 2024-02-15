import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Team {
  private String name;
  private List<Player> players;

  public Team(String name) {
    setName(name);
    this.players = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    if (Validator.invalidName(name)) {
      throw new IllegalArgumentException(ConstantMessages.INVALID_NAME);
    }
    this.name = name;
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public void removePlayer(String playerName) {
    if (!Validator.doesTeamContainPlayer(this.players, getPlayer(playerName))) {
      throw new IllegalArgumentException(ConstantMessages.invalidPlayer(playerName, this.name));
    }
    this.players.remove(getPlayer(playerName));
  }

  public double getRating() {
    return this.calcRating();
  }

  private double calcRating() {
    return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).sum());
  }

  private Player getPlayer(String name) {
    return this.players
            .stream()
            .filter(p -> p.getName().equals(name))
            .collect(Collectors.toList())
            .stream()
            .findFirst()
            .orElse(null);
  }


}
