package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
  private FootballTeam footballTeam;
  private FootballTeam emptyFootballTeam;
  private Footballer player1;
  private Footballer player2;

  @Before
  public void setUp() {
    this.emptyFootballTeam = new FootballTeam("test", 10);
    this.footballTeam = new FootballTeam("CSKA", 2);
    this.player1 = new Footballer("Mike");
    this.player2 = new Footballer("George");
    this.footballTeam.addFootballer(player1);
    this.footballTeam.addFootballer(player2);
  }

  // test constructor
  @Test
  public void testFootballTeamCtorShouldWorksCorrect() {
    Assert.assertEquals("test", emptyFootballTeam.getName());
    Assert.assertEquals(0, emptyFootballTeam.getCount());
    Assert.assertEquals(10, emptyFootballTeam.getVacantPositions());
  }

  @Test
  public void testFootballTerCtorShouldWorksCorrect() {
    Assert.assertEquals("Mike", player1.getName());
  }

}
