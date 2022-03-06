public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    private final int discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }
}
