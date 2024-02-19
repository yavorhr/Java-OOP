public class Validator {
  public static boolean negativeValue(double value) {
    return value <= 0;
  }

  public static boolean tankCapacityIsExceeded(double currentQuantity, double givenLiters, double currentTankCapaicty) {
    return currentQuantity + givenLiters > currentTankCapaicty;
  }

  public static boolean isFuelEnoughToDrive(double requiredFuel, double currentFuel) {

    return requiredFuel >= currentFuel;
  }
}
