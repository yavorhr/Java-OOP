import java.util.Map;

public class Dough {
    private static final Map<String, Double> FLOUR_TYPES_WITH_MODIFIERS = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0);

    private static final Map<String, Double> BAKING_TECHNIQUES = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPES_WITH_MODIFIERS.containsKey(flourType)) {
            throw new IllegalStateException(ConstantMessages.INVALID_DOUGH);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BAKING_TECHNIQUES.containsKey(bakingTechnique)) {
            throw new IllegalStateException(ConstantMessages.INVALID_DOUGH);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (!Validator.isDoughWeightInRange(weight)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_DOUGH_WEIGHT);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 *
                FLOUR_TYPES_WITH_MODIFIERS.get(this.flourType) *
                BAKING_TECHNIQUES.get(this.bakingTechnique);
    }
}
