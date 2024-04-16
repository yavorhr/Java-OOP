package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
  private Service service;
  private Robot robot1;
  private Robot robot2;
  private Robot robot3;

  @Before
  public void setUp() {
    this.service = new Service("best", 3);
    robot1 = new Robot("robot1");
    robot2 = new Robot("robot2");
    robot3 = new Robot("robot3");
  }

  // test constructors works correct
  @Test
  public void testServiceConstructorWorksAsExpected() {
    Assert.assertEquals(3, service.getCapacity());
    Assert.assertEquals(0, service.getCount());
    Assert.assertEquals("best", service.getName());
  }

  @Test
  public void testRobotConstructorWorksAsExpected() {
    Assert.assertEquals("robot1", robot1.getName());
  }

  // test constructors if throw errors
  @Test(expected = NullPointerException.class)
  public void testServiceConstructorThrowErrorWhenEmptyNameIsGiven() {
    new Service("", 3);
  }

  @Test(expected = NullPointerException.class)
  public void testServiceConstructorThrowErrorWhenNullNameIsGiven() {
    new Service(null, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testServiceConstructorThrowErrorWhenNegativeCapacityIsGiven() {
    new Service("test", -1);
  }

  // test addRobot()
  @Test
  public void testAddRobotWorksCorrect() {
    this.service.add(robot1);
    this.service.add(robot2);
    this.service.add(robot3);

    Assert.assertEquals(3, this.service.getCount());
  }

  // test addRobot() throw error
  @Test(expected = IllegalArgumentException.class)
  public void testAddRobotThrowsErrorWhenNoCapacity() {
    this.service.add(robot1);
    this.service.add(robot2);
    this.service.add(robot3);
    this.service.add(robot3);
  }

  // test remove()
  @Test
  public void testRemoveShouldWorksCorrect() {
    this.service.add(robot1);
    this.service.remove("robot1");
    Assert.assertEquals(0, this.service.getCount());
  }

  // test remove() should throw error when none existing robot
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShouldThrowErrorWhenRobotDoesNotExist() {
    this.service.add(robot1);
    this.service.remove("robot2");
  }

  // test forSale()
  @Test
  public void testForSaleShouldWorksCorrect() {
    this.service.add(robot1);
    this.service.forSale("robot1");
    Assert.assertFalse(robot1.isReadyForSale());
  }

  // test forSale() throws error when robot does not exist
  @Test(expected = IllegalArgumentException.class)
  public void testForSaleShouldThrowErrorWhenRobotDoesNotExist() {
    this.service.add(robot1);
    this.service.forSale("robot2");

  }

}
