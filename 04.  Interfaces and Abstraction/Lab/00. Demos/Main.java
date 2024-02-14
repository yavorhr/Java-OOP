import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Animal snake = new Snake();
    Animal goat = new Goat();
    Animal wolf = new Wolf();

    List<Animal> animals = new ArrayList<>();
    animals.add(snake);
    animals.add(goat);
    animals.add(wolf);

    animals.forEach(Animal::eat);
  }
}
