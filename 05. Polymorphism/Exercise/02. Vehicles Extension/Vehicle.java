import java.text.DecimalFormat;

public abstract class Vehicle {
  private double fuelQuantity;
  private double fuelConsumption;
  private double tankCapacity;

  protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
    setFuelQuantity(fuelQuantity);
    this.fuelConsumption = fuelConsumption;
    this.tankCapacity = tankCapacity;
  }

  public String drive(double distance) {
    double requiredFuel = distance * this.fuelConsumption;

    if (Validator.isFuelEnoughToDrive(requiredFuel, this.fuelQuantity)) {
      throw new IllegalArgumentException(ConstantMessages.vehicleNeedsRefuel(this.getClass().getSimpleName()));
    }
    this.fuelQuantity -= requiredFuel;

    return ConstantMessages.vehicleTravelledKm(this.getClass().getSimpleName(), distance);
  }

  protected void refuel(double liters) {
    if (Validator.negativeValue(liters)) {
      throw new IllegalArgumentException(ConstantMessages.MUST_BE_POSITIVE);
    }

    if (Validator.tankCapacityIsExceeded(this.fuelQuantity, liters, this.tankCapacity)) {
      throw new IllegalArgumentException(ConstantMessages.CANNOT_FIT_FUEL);
    }
    this.fuelQuantity += liters;
  }

  protected void addConsumption() {
    this.fuelConsumption += Bus.AIR_CONDITIONER_ADDITIONAL_CONSUMPTION;
  }

  protected void subtractConsumption() {
    this.fuelConsumption -= Bus.AIR_CONDITIONER_ADDITIONAL_CONSUMPTION;
  }

  private void setFuelQuantity(double fuelQuantity) {
    if (Validator.negativeValue(fuelQuantity)) {
      throw new IllegalArgumentException(ConstantMessages.MUST_BE_POSITIVE);
    }
    this.fuelQuantity += fuelQuantity;
  }

  public void setFuelConsumption(double fuelConsumption) {
    this.fuelConsumption = fuelConsumption;
  }

  public double getFuelConsumption() {
    return fuelConsumption;
  }

  @Override
  public String toString() {
    return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
  }
}
