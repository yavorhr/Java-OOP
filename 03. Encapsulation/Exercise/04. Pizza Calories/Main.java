import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaTokens = getTokens(scanner);
        String[] doughTokens = getTokens(scanner);

        try {
            Pizza pizza = getPizza(pizzaTokens);
            Dough dough = getDough(doughTokens);
            pizza.setDough(dough);

            String input = scanner.nextLine();
            while (!"END".equals(input)) {
                String[] toppingTokens = input.split("\\s+");
                Topping topping = getTopping(toppingTokens);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(pizza);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static Topping getTopping(String[] toppingTokens) {
        String name = toppingTokens[1];
        double weight = Double.parseDouble(toppingTokens[2]);
        return new Topping(name, weight);
    }

    private static Dough getDough(String[] tokens) {
        String name = tokens[1];
        String type = tokens[2];
        double weight = Double.parseDouble(tokens[3]);

        return new Dough(name, type, weight);
    }

    private static String[] getTokens(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static Pizza getPizza(String[] tokens) {
        String pizzaName = tokens[1];
        int toppingsCount = Integer.parseInt(tokens[2]);

        return new Pizza(pizzaName, toppingsCount);
    }
}
