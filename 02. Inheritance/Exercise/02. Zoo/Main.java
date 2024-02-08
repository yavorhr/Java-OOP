package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Animal bear = new Bear("Pete");
    Animal gorilla = new Gorilla("King Kong");
    Animal snake = new Snake("Sassy");
    Animal lizard = new Lizard("Sneaky");

    List<Animal> animals = new ArrayList<>();

    animals.add(gorilla);
    animals.add(snake);
    animals.add(lizard);
    animals.add(bear);

    animals.forEach(a -> System.out.println(a.getName()));

  }
}