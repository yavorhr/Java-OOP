package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
  private static final int INITIAL_KILOGRAMS = 9;
  private static final int INCREASE_KILOGRAMS = 3;

  protected FemaleRobot(String name, String kind, double price) {
    super(name, kind, price);
  }
}
