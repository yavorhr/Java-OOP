import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            try {
                String[] input = reader.readLine().split(" ");
                addPerson(people, input);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(reader.readLine());

        increaseSalaries(people, bonus);

        printList(people);
    }

    private static void increaseSalaries(List<Person> people, double bonus) {
        for (Person person : people) {
            person.increaseSalary(bonus);
        }
    }

    private static void addPerson(List<Person> people, String[] input) {
        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.parseInt(input[2]);
        double salary = Double.parseDouble(input[3]);

        people.add(new Person(firstName, lastName, age, salary));
    }

    private static void printList(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
