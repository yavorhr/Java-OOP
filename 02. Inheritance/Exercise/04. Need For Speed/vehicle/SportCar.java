package vehicle;

public class SportCar extends Vehicle{
  final static double DEFAULT_FUEL_CONSUMPTION = 10;

  public SportCar(double fuel, int horsePower) {
    super(fuel, horsePower);
    super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
  }

  @Override
  public String toString() {
    return String.format("Vehicle of type %s has %.2f fuel left. It's default fuel consumption is %.2f per 100 km."
            ,getClass().getSimpleName(), super.getFuel(), DEFAULT_FUEL_CONSUMPTION);
  }
}
