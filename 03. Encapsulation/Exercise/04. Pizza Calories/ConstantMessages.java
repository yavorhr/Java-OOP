public class ConstantMessages {

  public static final String INVALID_DOUGH = "Invalid type of dough.";
  public static final String INVALID_DOUGH_WEIGHT = "Dough weight should be in the range [1..200].";
  public static final String INVALID_PIZZA_NAME = "Pizza name should be between 1 and 15 symbols.";
  public static final String INVALID_NUMBER_OF_TOPPINGS = "Number of toppings should be in range [0..10].";

  public static String invalidTopping(String topping) {
    return String.format("Cannot place %s on top of your pizza.", topping);
  }

  public static String invalidToppingWeight(String topping) {
    return String.format("%s weight should be in the range [1..50].", topping);
  }
}

