import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] birthableMethods = Birthable.class.getDeclaredMethods();
            Method[]   identifiableMethods = Identifiable.class.getDeclaredMethods();

            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();

            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);

            System.out.println(identifiableMethods.length);
            System.out.println(identifiableMethods[0].getReturnType().getSimpleName());
            System.out.println(birthableMethods.length);
            System.out.println(birthableMethods[0].getReturnType().getSimpleName());
        }
    }
}

