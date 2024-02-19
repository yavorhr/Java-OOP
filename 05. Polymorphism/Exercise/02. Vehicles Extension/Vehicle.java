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
    if (requiredFuel > this.fuelQuantity) {
      throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
    }
    this.fuelQuantity -= requiredFuel;

    DecimalFormat formatter = new DecimalFormat("##.##");

    return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
  }

  protected void refuel(double liters) {
    if (liters <= 0) {
      throw new IllegalArgumentException("Fuel must be a positive number");
    }

    if (this.fuelQuantity + liters > this.tankCapacity) {
      throw new IllegalArgumentException("Cannot fit fuel in tank");
    }
    this.fuelQuantity += liters;
  }

  protected void addConsumption(){
    this.fuelConsumption += Bus.AIR_CONDITIONER_ADDITIONAL_CONSUMPTION;
  }

  protected void subtractConsumption(){
    this.fuelConsumption -= Bus.AIR_CONDITIONER_ADDITIONAL_CONSUMPTION;
  }

  private void setFuelQuantity(double fuelQuantity) {
    if (fuelQuantity <= 0) {
      throw new IllegalArgumentException("Fuel must be a positive number");
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
