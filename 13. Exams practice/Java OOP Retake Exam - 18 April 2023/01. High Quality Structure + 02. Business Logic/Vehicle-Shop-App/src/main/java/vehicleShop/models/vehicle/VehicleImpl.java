package vehicleShop.models.vehicle;

import vehicleShop.validator.Validator;

public class VehicleImpl implements Vehicle {
  private String name;
  private int strengthRequired;

  public VehicleImpl(String name, int strengthRequired) {
    this.setName(name);
    this.setStrengthRequired(strengthRequired);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getStrengthRequired() {
    return this.strengthRequired;
  }

  private void setName(String name) {
    Validator.validateVehicleName(name);
    this.name = name;
  }

  private void setStrengthRequired(int strengthRequired) {
    Validator.validateRequiredStrength(strengthRequired);
    this.strengthRequired = strengthRequired;
  }

  @Override
  public boolean reached() {
    return this.strengthRequired == 0;
  }

  @Override
  public void making() {
    this.strengthRequired -= 5;
    if (this.strengthRequired < 0) {
      this.strengthRequired = 0;
    }
  }

}
