package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car {
    private static final int MODEL_CANNOT_BE_LESS_THAN_FOUR_SYMBOLS = 4;
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    protected BaseCar(String model, double cubicCentimeters) {
        setModel(model);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        if (model == null || model.length() < MODEL_CANNOT_BE_LESS_THAN_FOUR_SYMBOLS || model.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, MODEL_CANNOT_BE_LESS_THAN_FOUR_SYMBOLS));
        }
        this.model = model;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / horsePower * laps;
    }
}
