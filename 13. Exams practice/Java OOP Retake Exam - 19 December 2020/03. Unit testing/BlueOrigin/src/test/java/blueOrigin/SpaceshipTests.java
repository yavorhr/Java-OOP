package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
  private Astronaut astronaut;
  private Astronaut astronaut2;
  private Astronaut astronaut3;
  private Spaceship spaceship;

  @Before
  public void setUp() {
   this.astronaut = new Astronaut("Steven", 90);
   this.astronaut2 = new Astronaut("Mike", 50);
   this.astronaut3 = new Astronaut("George", 80);

    this.spaceship = new Spaceship("StarOfDeath", 3);
    this.spaceship.add(astronaut);
    this.spaceship.add(astronaut2);
    this.spaceship.add(astronaut3);
  }

  @Test
  public void testSpaceShipCtorWhenInitObjWorksCorrect() {
    Assert.assertEquals("StarOfDeath", this.sp);
  }
}
