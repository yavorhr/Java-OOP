import java.util.ArrayList;
import java.util.List;

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
    if (!Validator.validateName(name)) {
      throw new IllegalArgumentException(ConstantMessages.INVALID_NAME);
    }
    this.name = name;
  }

  public void addPlayer(Player player) {

  }

  public void removePlayer(String name) {

  }

  public double getRating() {

  }
}
