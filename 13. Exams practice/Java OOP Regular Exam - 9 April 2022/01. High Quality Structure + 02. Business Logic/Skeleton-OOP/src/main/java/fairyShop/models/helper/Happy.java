package fairyShop.models.helper;

public class Happy extends BaseHelper {
  private static final int INITIAL_ENERGY_UNITS = 100;
  private static final int DECREASE_UNITS_VALUE = 10;

  public Happy(String name) {
    super(name, INITIAL_ENERGY_UNITS);
  }

  @Override
  public void work() {
    super.decreaseEnergy(DECREASE_UNITS_VALUE);
  }
}
