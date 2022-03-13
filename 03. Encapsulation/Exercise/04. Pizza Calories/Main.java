import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        try {
            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
            tokens = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
            pizza.setDough(dough);

            input = scanner.nextLine();
            while (!input.equals("END")) {
                tokens = input.split("\\s+");
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(pizza.toString());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}




