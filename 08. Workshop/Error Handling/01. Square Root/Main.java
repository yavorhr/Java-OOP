import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      double number = Double.parseDouble(scanner.nextLine());
      System.out.println(sqrt(number));
    } catch (IllegalArgumentException ex) {
      System.out.println("Error: " + "Invalid number!");
      ex.printStackTrace();

    } finally {
      System.out.println("Good bye");
    }
  }

  public static double sqrt(double value) {
    if (value < 0) {
      throw new IllegalArgumentException("Invalid number!");
    }
    return Math.sqrt(value);
  }
}
