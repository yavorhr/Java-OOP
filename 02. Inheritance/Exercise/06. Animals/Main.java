import animals.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();
        while (!"Beast!".equals(animalType)) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                if (age <= 0) {
                    throw new IllegalStateException("Invalid input!");
                }

                if (!gender.equals("Male") && !gender.equals("Female")) {
                    throw new IllegalStateException("Invalid input!");
                }

            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                animalType = scanner.nextLine();
                continue;
            }

            Object animalObj = getObject(animalType, name, age, gender);
            printResult(animalType, animalObj);

            animalType = scanner.nextLine();
        }
    }

    private static void printResult(String animalType, Object currentAnimal) {
        System.out.println(animalType);
        System.out.println(currentAnimal.toString());

        if (currentAnimal instanceof Tomcat tomcat) {
            tomcat.produceSound();
        } else if (currentAnimal instanceof Kitten kitten) {
            kitten.produceSound();
        } else if (currentAnimal instanceof Frog frog) {
            frog.produceSound();
        } else if (currentAnimal instanceof Dog dog) {
            dog.produceSound();
        }
    }

    private static Object getObject(String animalType, String name, int age, String gender) {
        Object animal = null;

        switch (animalType) {
            case "Cat" -> {
                if (gender.equals("Female")) {
                    animal = new Kitten(name, age);
                }
                animal = new Tomcat(name, age);
            }

            case "Dog" -> animal = new Dog(name, age, gender);
            case "Frog" -> animal = new Frog(name, age, gender);
        }

        return animal;
    }
}