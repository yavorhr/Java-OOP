import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Animal wolf = new Wolf("nss", 31, false);
    wolf.move();
    System.out.println(wolf);
  }
}
