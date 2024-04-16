package robots;

import org.junit.Before;

public class ServiceTests {
  private Service service;
  private Robot robot1;
  private Robot robot2;
  private Robot robot3;

  @Before
  public void setUp() {
    this.service = new Service("bestService", 3);
    robot1 = new Robot("robot1");
    robot2 = new Robot("robot2");
    robot3 = new Robot("robot3");
  }

}
