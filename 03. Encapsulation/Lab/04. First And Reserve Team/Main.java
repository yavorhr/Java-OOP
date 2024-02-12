import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Eagles");

        while (n-- > 0) {
            try {
                String[] input = reader.readLine().split(" ");
                addToTeam(team, input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        printOutput(team);
    }

    private static void printOutput(Team team) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("""
            First team have %d players
            Reserve team have %d players
            """, team.getFirstTeam().size(), team.getReserveTeam().size()));
        System.out.print(sb);
    }

    private static void addToTeam(Team team, String[] input) {
        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.parseInt(input[2]);
        double salary = Double.parseDouble(input[3]);

        team.addPlayer(new Person(firstName, lastName, age, salary));
    }
}
