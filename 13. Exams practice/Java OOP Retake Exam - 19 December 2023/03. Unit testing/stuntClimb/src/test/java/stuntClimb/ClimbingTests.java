package stuntClimb;


import org.junit.Before;

public class ClimbingTests {
  private Climbing climbing;
  private Climbing emptyClimbing;
  private RockClimber rockClimber1;
  private RockClimber rockClimber2;

  @Before
  public void setUp() {
    this.emptyClimbing = new Climbing("empty", 5);

    this.climbing = new Climbing("best", 2);
    this.rockClimber1 = new RockClimber("Mike", 50);
    this.rockClimber2 = new RockClimber("Dean", 100);
    this.climbing.addRockClimber(rockClimber1);
    this.climbing.addRockClimber(rockClimber2);
  }

}
