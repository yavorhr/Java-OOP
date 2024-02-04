import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        printOutput();
    }

    private static void printOutput() {
        StringBuilder sb = new StringBuilder("Card Ranks:\n");

        Arrays.stream(Card
                .values())
                .forEach(c ->
                        sb.append(String.format("Ordinal value: %d; Name value: %s\n", c.ordinal(), c)));

        System.out.println(sb);
    }
}
