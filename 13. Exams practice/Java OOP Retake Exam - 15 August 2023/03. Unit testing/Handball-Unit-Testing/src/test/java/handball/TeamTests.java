package handball;

import org.junit.Before;

public class TeamTests {
  private Team team1;
  private Team team2;
  private HandballPlayer player1;
  private HandballPlayer player2;

  @Before
  public void setup() {
    this.team1 = new Team("Arsenal", 3);
    this.team1.add(player1);
    this.team1.add(player2);

    this.team2 = new Team("Chelsea", 5);
  }
}
