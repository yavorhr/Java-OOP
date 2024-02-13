import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personTokens = scanner.nextLine().split(";");
        String[] productTokens = scanner.nextLine().split(";");

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        addToList(people, products, personTokens, "person");
        addToList(people, products, productTokens, "product");

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] inputTokens = input.split(" ");
            String name = inputTokens[0];
            String product = inputTokens[1];

            if (inputsAreValid(people, products, name, product)) {
                try {
                    Person person = getPerson(name, people);
                    Product productObj = getProduct(product, products);
                    person.buyProduct(productObj);
                    System.out.println(name + " bought " + product);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            input = scanner.nextLine();
        }

        printOutput(people);
    }

    private static boolean inputsAreValid(List<Person> people, List<Product> products, String name, String product) {
        return getPerson(name, people) != null && getProduct(product, products) != null;
    }

    private static void printOutput(List<Person> people) {
        people.forEach(System.out::println);
    }

    private static Product getProduct(String product, List<Product> products) {
        return products.stream().filter(p -> p.getName().equals(product)).collect(Collectors.toList()).stream().findFirst().orElse(null);
    }

    private static Person getPerson(String name, List<Person> people) {
        return people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()).stream().findFirst().orElse(null);
    }

    private static void addToList(List<Person> people, List<Product> products, String[] tokens, String criteria) {
        for (String token : tokens) {
            String[] innerTokens = token.split("=");
            String name = innerTokens[0];
            double money = Double.parseDouble(innerTokens[1]);

            try {
                if (criteria.equals("person")) {
                    Person person = new Person(name, money);
                    people.add(person);
                } else {
                    Product product = new Product(name, money);
                    products.add(product);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}

