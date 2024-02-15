import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if(Arrays.asList(citizenInterfaces).contains(Person.class)){
            Method[] methods = Person.class.getDeclaredMethods();

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            Person person = new Citizen(name,age);

            System.out.println(methods.length);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}

