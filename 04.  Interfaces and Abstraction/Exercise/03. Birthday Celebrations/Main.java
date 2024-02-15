import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");

            if (!tokens[0].equals("Robot")) {
                addToBirthables(tokens, birthables);
            }

            input = scanner.nextLine();
        }

        String date = scanner.nextLine();
        printBirthdays(date, birthables);
    }

    private static void printBirthdays(String birthday, List<Birthable> birthables) {
        List<Birthable> filtered = birthables.stream()
                .filter(i -> i.getBirthDate()
                        .endsWith(birthday)).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("<no output>");
        } else {
            filtered.forEach(b -> System.out.println(b.getBirthDate()));
        }
    }

    private static void addToBirthables(String[] tokens, List<Birthable> birthables) {
        if (tokens.length == 5) {
            birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
        } else {
            birthables.add(new Pet(tokens[1], tokens[2]));
        }
    }

}


