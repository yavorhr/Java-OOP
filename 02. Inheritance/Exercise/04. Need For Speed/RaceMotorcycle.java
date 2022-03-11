public class RaceMotorcycle extends Motorcycle {

    protected final static double DEFAULT_FUEL_CONSUMPTION = 8.00;

    public RaceMotorcycle(double fuel,int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
