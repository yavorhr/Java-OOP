public class Audi extends CarImpl implements Rentable {
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\nMinimum rental period of %d days. Price per day %.0f",
                        this.minRentDay, this.pricePerDay);
    }
}
