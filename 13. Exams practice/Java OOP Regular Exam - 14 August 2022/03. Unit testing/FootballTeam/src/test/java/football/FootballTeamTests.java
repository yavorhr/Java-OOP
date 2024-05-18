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

  // test constructors
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

  @Test(expected = NullPointerException.class)
  public void testSetNameOfFootballTeamShouldThrowExcWhenNullName() {
    new FootballTeam(null, 10);
  }

  @Test(expected = NullPointerException.class)
  public void testSetNameOfFootballTeamShouldThrowExcWhenEmptyName() {
    new FootballTeam("", 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetVacantPositionsShouldThrowExcWhenNegativeValue() {
    new FootballTeam("test", -5);
  }

  // test addFootballer()
  @Test
  public void testAddFootballerShouldWorksCorrect() {
    Assert.assertEquals(this.footballTeam.getCount(), 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddFootballerShouldThrowErrorWhenNoSpace() {
    this.footballTeam.addFootballer(new Footballer("test"));
  }

  // test removeFootballer()
  @Test
  public void testRemoveFootballerShouldWorksCorrect() {
    this.footballTeam.removeFootballer("Mike");
    int actual = this.footballTeam.getCount();
    int expected = 1;

    Assert.assertEquals(expected, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFootballerShouldThrowErrorWhenNoPlayer() {
    this.footballTeam.removeFootballer("invalidPlayer");
  }

  // footballerForSale()
  @Test
  public void testFootballerForSaleShouldWorksCorrect() {
    Footballer footballer = this.footballTeam.footballerForSale("Mike");

    Assert.assertFalse(footballer.isActive());
    Assert.assertEquals("Mike", footballer.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFootballerForSaleShouldThrowErrorWhenNoPlayer() {
    this.footballTeam.footballerForSale("invalidPlayer");
  }

  // getStatistics()
  @Test
  public void testGetStatisticsShouldWorksCorrect() {
    String actual = this.footballTeam.getStatistics();
    String expected = "The footballer Mike, George is in the team CSKA.";

    Assert.assertEquals(actual, expected);
  }
}
