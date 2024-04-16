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

  @Test
  public void testServiceConstructorWorksAsExpected(){
    Assert.assertEquals(3, service.getCapacity());
    Assert.assertEquals(0, service.getCount());
    Assert.assertEquals("best", service.getName());
  }

  @Test
  public void testRobotConstructorWorksAsExpected(){
    Assert.assertEquals("robot1", robot1.getName());
  }

}
