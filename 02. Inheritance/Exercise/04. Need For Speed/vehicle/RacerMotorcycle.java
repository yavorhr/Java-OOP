package vehicle;

public class RacerMotorcycle extends Vehicle{
  final static double DEFAULT_FUEL_CONSUMPTION = 8;

  public RacerMotorcycle(double fuel, int horsePower) {
    super(fuel, horsePower);
    super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
  }

  @Override
  public String toString() {
    return String.format("Vehicle of type %s has %.2f fuel left. It's default fuel consumption is %.2f per 100 km",
            getClass().getSimpleName(), super.getFuel(), DEFAULT_FUEL_CONSUMPTION);
  }
}
