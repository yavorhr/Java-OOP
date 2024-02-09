package vehicle;

public class Vehicle {
  final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
  private double fuelConsumption;
  private double fuel;
  private int horsePower;

  public Vehicle(double fuel, int horsePower) {
    setFuel(fuel);
    setHorsePower(horsePower);
    setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
  }

  public void drive(double kilometers) {
    double requiredFuel = this.fuelConsumption / 100 * kilometers;
    if (requiredFuel > fuel) {
      System.out.println("Not enough fuel to drive!");
    } else {
      this.fuel -=requiredFuel;
    }
  }

  public double getFuelConsumption() {
    return fuelConsumption;
  }

  public void setFuelConsumption(double fuelConsumption) {
    this.fuelConsumption = fuelConsumption;
  }

  public double getFuel() {
    return fuel;
  }

  public void setFuel(double fuel) {
    this.fuel = fuel;

  }

  public int getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }

  @Override
  public String toString() {
    return String.format("Vehicle of type %s has %.2f fuel left. It's default fuel consumption is %.2f per 100 km.", this.getClass().getSimpleName(), this.fuel, DEFAULT_FUEL_CONSUMPTION);
  }
}
