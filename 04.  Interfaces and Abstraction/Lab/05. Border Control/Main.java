

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");

            addToList(tokens, identifiables);
            input = scanner.nextLine();
        }

        String postfixId = scanner.nextLine();
        printFakeIds(postfixId, identifiables);
    }

    private static void printFakeIds(String fakeId, List<Identifiable> identifiables) {
        identifiables.stream()
                .filter(i -> i.getId().endsWith(fakeId))
                .forEach(i -> System.out.println(i.getId()));
    }

    private static void addToList(String[] tokens, List<Identifiable> identifiables) {
        if (tokens.length == 3) {
            identifiables.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
        } else {
            identifiables.add(new Robot(tokens[0], tokens[1]));
        }
    }
}

