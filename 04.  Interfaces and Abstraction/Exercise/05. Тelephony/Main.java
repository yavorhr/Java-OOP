import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersInput = getList(scanner);
        List<String> urlsInput = getList(scanner);

        Smartphone smartphone = new Smartphone(numbersInput, urlsInput);

        printOutput(smartphone);
    }

    private static void printOutput(Smartphone smartphone) {
        System.out.println(smartphone.call());
        System.out.println( smartphone.browse());
    }

    private static List<String> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
    }
}






