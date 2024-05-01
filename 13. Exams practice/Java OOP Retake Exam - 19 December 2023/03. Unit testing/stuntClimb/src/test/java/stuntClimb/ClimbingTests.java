package stuntClimb;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

  //test constructors
  @Test
  public void testClimbingCtorShouldWorksCorrect(){
    Assert.assertEquals("empty", this.emptyClimbing.getName());
    Assert.assertEquals(0, this.emptyClimbing.getCount());
    Assert.assertEquals(5, this.emptyClimbing.getCapacity());
  }

  @Test
  public void testRockClimberCtorShouldWorksCorrect(){
    Assert.assertEquals("Mike", this.rockClimber1.getName());
    Assert.assertEquals(50, this.rockClimber1.getStrength(),0);
    
  }

}
