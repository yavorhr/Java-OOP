import java.util.Map;

public class Topping {
    private static final Map<String, Double> TOPPING_TYPES_WITH_MODIFIERS = Map.of("Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9);

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_TYPES_WITH_MODIFIERS.containsKey(toppingType)) {
            throw new IllegalArgumentException(ConstantMessages.invalidTopping(toppingType));
        }
        this.toppingType = toppingType;
    }

    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (!Validator.isToppingWeightInRange(weight)) {
            throw new IllegalArgumentException(ConstantMessages.invalidToppingWeight(this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * TOPPING_TYPES_WITH_MODIFIERS.get(this.toppingType);
    }
}
