public class Bus extends Vehicle {
    protected static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        super.addConsumption();
        String out = super.drive(distance);
        super.subtractConsumption();
        return out;
    }
}
