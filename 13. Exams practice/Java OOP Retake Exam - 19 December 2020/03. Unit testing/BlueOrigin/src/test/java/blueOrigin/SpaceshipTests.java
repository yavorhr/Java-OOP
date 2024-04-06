package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

  @Before
  public void setUp() {
    Astronaut astronaut = new Astronaut("Steven", 90);
    Astronaut astronaut2 = new Astronaut("Mike", 50);
    Astronaut astronaut3 = new Astronaut("George", 80);

    Spaceship spaceship = new Spaceship("StarOfDeath", 3);
    spaceship.add(astronaut);
    spaceship.add(astronaut2);
    spaceship.add(astronaut3);
  }

  @Test
  public void testSpaceShipCtorWhenInitObjWorksCorrect() {

  }
}
