package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    public SportsCar(String model, int horsePower) {
        super(model, 3000);
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
