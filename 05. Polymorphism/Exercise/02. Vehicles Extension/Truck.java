public class Truck extends Vehicle {
    protected static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.6;
    protected static final double MAX_REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * MAX_REFUEL_PERCENTAGE);
    }
}


