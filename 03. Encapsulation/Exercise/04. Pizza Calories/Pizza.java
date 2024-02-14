import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (!Validator.isPizzaNameValid(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_PIZZA_NAME);
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(int toppings) {
        if (!Validator.numberOfToppingsIsAllowed(toppings)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NUMBER_OF_TOPPINGS);
        }
        this.toppings = new ArrayList<>(toppings);
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() >= 10) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NUMBER_OF_TOPPINGS);
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double toppingsCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        double doughCal = this.dough.calculateCalories();
        return toppingsCalories + +doughCal;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
