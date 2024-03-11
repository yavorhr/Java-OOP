package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 3000;
    public SportsCar(String model, int horsePower) {
        super(model, CUBIC_CENTIMETERS);
        setHorsePower(horsePower);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (!(horsePower >= 250 && horsePower <= 450)) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
