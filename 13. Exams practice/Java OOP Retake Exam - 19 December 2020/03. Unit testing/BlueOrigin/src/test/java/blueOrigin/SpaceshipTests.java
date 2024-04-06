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

  // test Constructor
  @Test
  public void testSpaceShipCtorWhenInitObjWorksCorrect() {
    Assert.assertEquals("StarOfDeath", this.spaceship.getName());
    Assert.assertEquals(3, this.spaceship.getCapacity());
    Assert.assertEquals(3, this.spaceship.getCount());

    Spaceship demoShip = new Spaceship("demoShip", 5);
    Assert.assertEquals(0, demoShip.getCount());
  }

  // test setCapacity()
  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidCapacityWhenInitSpaceship() {
    new Spaceship("someShip", -1);
  }

  // test setName with empty name()
  @Test(expected = NullPointerException.class)
  public void testSetNameWithEmptyValueShouldThrowError() {
    new Spaceship("", 5);
  }

  // test setName with null value()
  @Test(expected = NullPointerException.class)
  public void testSetNameWithNullValueThrowError() {
    new Spaceship(null, 5);
  }

  // test addAstronaut()
  @Test(expected = IllegalArgumentException.class)
  public void testAddAstronautShouldThrowErrorWhenFullCapacity() {
    this.spaceship.add(new Astronaut("Florenze", 90));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddAstronautShouldThrowErrorWhenAstronautAlreadyExists() {
    this.spaceship.add(new Astronaut("Steven", 90));
  }

  // test removeAstronaut()
  @Test
  public void testRemoveAstronautShouldWorksCorrect() {
    Assert.assertTrue(this.spaceship.remove("Mike"));
    Assert.assertFalse(this.spaceship.remove("invalid_name"));
  }

  //test astronaut
  @Test
  public void testAstronautsInitShouldWorksCorrect() {
    Assert.assertEquals(90, this.astronaut.getOxygenInPercentage(), 0);
    Assert.assertEquals("Steven", this.astronaut.getName());

  }

}
