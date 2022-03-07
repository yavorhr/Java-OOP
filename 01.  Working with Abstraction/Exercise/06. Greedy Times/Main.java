import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long weight = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                bag.addCash(item, weight);
            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addGems(item, weight);

            } else if (item.toLowerCase().equals("gold")) {
                bag.addGold(weight);
            }
        }
        System.out.println(bag);
    }
}