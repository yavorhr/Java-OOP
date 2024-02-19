import Animal.*;
import Food.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] animalTokens = input.split(" ");
            String[] vegetableTokens = scanner.nextLine().split(" ");

            Animal animal = null;
            try {
                animal = createAnimal(animalTokens);
                Food food = createFood(vegetableTokens);
                animal.eat(food);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            printAnimal(animal);
            input = scanner.nextLine();
        }
    }

    private static void printAnimal(Animal animal) {
        System.out.println(animal);
    }


    private static Food createFood(String[] tokens) {
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        Food food = null;

        switch (type) {
            case "Vegetable" -> food = new Vegetable(quantity);
            case "Meat" -> food = new Meat(quantity);
        }

        return food;
    }

    private static Animal createAnimal(String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        double weight = Double.parseDouble(tokens[2]);
        String region = tokens[3];

        Animal animal = null;

        switch (type) {
            case "Cat" -> animal = new Cat(type, name, weight, tokens[4], region);
            case "Tiger" -> animal = new Tiger(type, name, weight, region);
            case "Mouse" -> animal = new Mouse(type, name, weight, region);
            case "Zebra" -> animal = new Zebra(type, name, weight, region);
        }

        return animal;
    }
}


