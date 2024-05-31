package vehicleShop.models.vehicle;

public class VehicleImpl implements Vehicle {
  private String name;
  private int strengthRequired;

  public VehicleImpl(String name, int strengthRequired) {
    this.name = name;
    this.strengthRequired = strengthRequired;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getStrengthRequired() {
    return this.strengthRequired;
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
