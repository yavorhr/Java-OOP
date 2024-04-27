package fairyShop.models.helper;

public class Sleepy extends BaseHelper {
  private static final int INITIAL_ENERGY_UNITS = 50;
  private static final int DECREASE_UNITS_VALUE = 15;

  public Sleepy(String name) {
    super(name, INITIAL_ENERGY_UNITS);
  }

  @Override
  public void work() {
    super.decreaseEnergy(DECREASE_UNITS_VALUE);
  }
}
