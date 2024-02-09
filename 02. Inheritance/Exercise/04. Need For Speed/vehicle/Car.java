package vehicle;

public class Car extends Vehicle{
  final static double DEFAULT_FUEL_CONSUMPTION = 3;

  public Car(double fuel, int horsePower) {
    super(fuel, horsePower);
    super.setFuelConsumption(3);
  }

  @Override
  public String toString() {
    return String.format("Vehicle of type %s has %.2f fuel left. It's default fuel consumption is %.2f per 100 km."
            ,getClass().getSimpleName(), super.getFuel(), DEFAULT_FUEL_CONSUMPTION);
  }
}
