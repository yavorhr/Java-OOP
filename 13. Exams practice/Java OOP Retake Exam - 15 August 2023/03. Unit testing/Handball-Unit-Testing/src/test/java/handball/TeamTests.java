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
    this.team1 = new Team("Arsenal", 2);
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

  //test setPosition() validation

  @Test(expected = IllegalArgumentException.class)
  public void testTeamConstructorShouldThrowErrorWhenNegativePosition() {
    new Team("test", -3);
  }

  //test addHandballPlayer
  @Test
  public void testAddHandballPlayerShouldWorksCorrect() {
    Assert.assertEquals(2, team1.getCount());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddHandballPlayerShouldThrowErrorWhenTeamIsFull() {
    team1.add(new HandballPlayer("Mike"));
  }

  //test removeHandballPlayer
  @Test
  public void testRemoveHandballPlayerShouldWorksCorrect(){
    this.team1.remove("Ivan");
    Assert.assertEquals(1, team1.getCount());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveHandballPlayerShouldThrowErrorWhenPlayerIsNotExisting(){
    this.team1.remove("none_existing_player");
  }
}
