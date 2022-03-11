import java.math.BigDecimal;

public class Salmon extends MainDish {
    static final double SALMON_GRAMS = 22.00;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
