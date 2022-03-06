public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay,  int days, Season season, Discount discount) {
        this.season = season;
        this.discount = discount;
        this.pricePerDay = pricePerDay;
        this.days = days;
    }

    public double calculatePrice() {
        return this.days * this.pricePerDay * this.season.getMultiplier()
                * (1.00 - (discount.getDiscount() / 100.00));
    }
}
