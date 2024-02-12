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
            String[] input = reader.readLine().split(" ");
            addPerson(people, input);
        }

        people.sort(new ComparatorByFirstNameAndAge());

        printList(people);
    }

    private static void addPerson(List<Person> people, String[] input) {
        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.parseInt(input[2]);

        people.add(new Person(firstName, lastName, age));
    }

    private static void printList(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
