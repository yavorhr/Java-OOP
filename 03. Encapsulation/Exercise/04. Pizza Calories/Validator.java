public class Validator {
  public static boolean isDoughWeightInRange(double value) {
    return value >= 1 && value <= 200;
  }

  public static boolean isToppingWeightInRange(double value) {
    return value >= 1 && value <= 50;
  }

  public static boolean isPizzaNameValid(String name) {
    return name.trim().length() > 0 && name.length() <= 15;
  }

  public static boolean numberOfToppingsIsAllowed(int value) {
    return value >= 0 && value <= 10;
  }
}
