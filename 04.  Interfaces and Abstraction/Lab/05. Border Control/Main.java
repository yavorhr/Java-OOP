import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> Identifiables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 3) {
                Identifiables.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            } else {
                Identifiables.add(new Robot(tokens[0], tokens[1]));
            }
            input = scanner.nextLine();
        }

        String postfixId = scanner.nextLine();

        for (Identifiable identifiable : Identifiables) {
            if (identifiable.getId().endsWith(postfixId)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}







