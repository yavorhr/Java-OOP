public class Validator {
  public static boolean validateName(String name) {
    return name.trim().length() > 0;
  }

  public static boolean validateStat(int value) {
    return value >= 0 && value <= 100;
  }
}
