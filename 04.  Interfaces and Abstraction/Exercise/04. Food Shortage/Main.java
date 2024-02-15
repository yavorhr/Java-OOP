import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Buyer> buyers = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            addBuyersToList(buyers, tokens);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            if (buyers.containsKey(input)) {
                Buyer buyer = buyers.get(input);
                buyer.buyFood();
            }
            input = scanner.nextLine();
        }
        printBoughtFood(buyers);

    }

    private static void printBoughtFood(Map<String,Buyer> buyers) {
        double food =   buyers.values().stream().mapToDouble(Buyer::getFood).sum();
        System.out.printf("%.0f", food);
    }

    private static void addBuyersToList(Map<String, Buyer> buyers, String[] tokens) {
        if (tokens.length == 4) {
            buyers.put(tokens[0], new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
        } else {
            buyers.put(tokens[0], new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
        }
    }
}

