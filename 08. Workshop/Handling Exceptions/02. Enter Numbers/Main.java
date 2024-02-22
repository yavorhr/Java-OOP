import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean succeeded = false;

    while (!succeeded) {
      try {
        succeeded = printRangeOfTwoNumbers(scanner);
      } catch (InvalidNumberInputException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  private static boolean printRangeOfTwoNumbers(Scanner scanner) {
    try {
      int[] numbers = readTwoNumbers(scanner);
      printRange(numbers[0], numbers[1]);
      return true;
    } catch (NumberFormatException ex) {
      throw new InvalidNumberInputException("One of the input values was not a number!", ex);
    }
  }

  public static int[] readTwoNumbers(Scanner scanner) {
    int[] res = new int[2];
    res[0] = readSingleNumber(scanner);
    res[1] = readSingleNumber(scanner);
    return res;
  }

  public static int readSingleNumber(Scanner scanner) {
    return Integer.parseInt(scanner.nextLine());
  }

  public static void printRange(int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.println(i);
    }
  }
}
