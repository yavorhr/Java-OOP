package football;

import org.junit.Before;

public class FootballTeamTests {
  private FootballTeam footballTeam;
  private FootballTeam emptyFootballTeam;
  private Footballer player1;
  private Footballer player2;

  @Before
  public void setUp(){
    this.emptyFootballTeam = new FootballTeam("test",10);
    this.footballTeam = new FootballTeam("CSKA",2);
    this.player1 = new Footballer("Mike");
    this.player2 = new Footballer("George");
    this.footballTeam.addFootballer(player1);
    this.footballTeam.addFootballer(player2);
  }

}
