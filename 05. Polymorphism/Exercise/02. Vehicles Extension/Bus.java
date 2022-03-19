public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        //Add consumption
        super.addConsumption(AIR_CONDITIONER_ADDITIONAL_CONSUMPTION);
        //Drive
        String out = super.drive(distance);
        super.subtractConsumption(AIR_CONDITIONER_ADDITIONAL_CONSUMPTION);
        //Remove consumption
        return out;
    }
}
