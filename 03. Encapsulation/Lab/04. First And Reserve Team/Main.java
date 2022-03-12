import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> playersLIst = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String firstName = personData[0];
            String lastName = personData[1];
            int age = Integer.parseInt(personData[2]);
            double salary = Double.parseDouble(personData[3]);

            Person person = new Person(firstName, lastName, age, salary);
            playersLIst.add(person);
        }

        Team team = new Team("Black eagles");
        for (Person player : playersLIst){
            team.addPlayer(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
