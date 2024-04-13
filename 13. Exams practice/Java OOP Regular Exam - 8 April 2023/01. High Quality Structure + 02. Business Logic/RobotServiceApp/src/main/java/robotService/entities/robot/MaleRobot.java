package robotService.entities.robot;

public class MaleRobot extends BaseRobot {
  private static final int INITIAL_KILOGRAMS = 9;
  private static final int INCREASE_KILOGRAMS = 3;

  protected MaleRobot(String name, String kind, double price) {
    super(name, kind, price, INITIAL_KILOGRAMS);
  }

  @Override
  public void eating() {
    super.increaseKilos(INCREASE_KILOGRAMS);
  }
}
