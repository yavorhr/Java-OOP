package fairyShop.models.present;

public class PresentImpl implements Present {
  private static final int DECREASE_ENERGY_VALUE = 10;
  private String name;
  private int energyRequired;

  public PresentImpl(String name, int energyRequired) {
    this.name = name;
    this.energyRequired = energyRequired;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getEnergyRequired() {
    return this.energyRequired;
  }

  @Override
  public boolean isDone() {
    return this.energyRequired == 0;
  }

  @Override
  public void getCrafted() {
    this.energyRequired = Math.max(energyRequired - DECREASE_ENERGY_VALUE, 0);
  }
}
