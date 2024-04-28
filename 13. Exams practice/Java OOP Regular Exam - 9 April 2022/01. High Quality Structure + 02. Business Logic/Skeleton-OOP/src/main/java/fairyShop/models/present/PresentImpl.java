package fairyShop.models.present;
import fairyShop.validator.Validator;

public class PresentImpl implements Present {
  private static final int DECREASE_ENERGY_VALUE = 10;
  private String name;
  private int energyRequired;

  public PresentImpl(String name, int energyRequired) {
    this.setName(name);
    this.setEnergyRequired(energyRequired);
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

  private void setName(String name) {
    Validator.validatePresentName(name);
    this.name = name;
  }

  private void setEnergyRequired(int energyRequired) {
    Validator.validatePresentEnergy(energyRequired);
    this.energyRequired = energyRequired;
  }
}
