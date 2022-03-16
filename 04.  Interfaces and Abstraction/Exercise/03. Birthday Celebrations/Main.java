import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean birthablesIsEmpty = true;
        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] tokens = input.split("\\s+");
            //String name, int age, String id, String birthDate
            if (tokens[0].equals("Citizen")) {
                birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
            } else if (tokens[0].equals("Pet")) {
                birthables.add(new Pet(tokens[1], tokens[2]));
            }
            input = scanner.nextLine();
        }

        String yearOutput = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(yearOutput)) {
                birthablesIsEmpty = false;
                System.out.println(birthable.getBirthDate());
            }
        }

        if (birthablesIsEmpty) {
            System.out.println("<no output>");
        }
    }
}






