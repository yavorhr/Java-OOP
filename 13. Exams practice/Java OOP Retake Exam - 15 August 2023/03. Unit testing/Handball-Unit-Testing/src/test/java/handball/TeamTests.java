package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {
  private Team team1;
  private Team team2;
  private HandballPlayer player1;
  private HandballPlayer player2;

  @Before
  public void setup() {
    this.team1 = new Team("Arsenal", 3);
    this.team1.add(player1 = new HandballPlayer("Ivan"));
    this.team1.add(player2 = new HandballPlayer("Georgi"));

    this.team2 = new Team("Chelsea", 5);
  }

  //test team constructor

  @Test
  public void testTeamConstructorShouldWorksCorrect() {
    Assert.assertEquals(0, team2.getCount());
    Assert.assertEquals(5, team2.getPosition());
    Assert.assertEquals("Chelsea", team2.getName());
  }

  //test player constructor

  @Test
  public void testHandballPlayerConstructorShouldWorksCorrect() {
    Assert.assertTrue(player1.isActive());
    Assert.assertEquals("Ivan", player1.getName());
  }
}
