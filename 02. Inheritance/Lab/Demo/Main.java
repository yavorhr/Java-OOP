import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Animal wolf = new Wolf("Vulcho", 31, false);
    wolf.move();

    //bark is implemented in Wolf class.
    wolf.bark();

    Wolf wolf2 = new Wolf("Anastas", 42, true);
    wolf2.bark();

    System.out.println(wolf);
  }
}
