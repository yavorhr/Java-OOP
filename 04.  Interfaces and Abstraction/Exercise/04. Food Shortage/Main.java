import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();
        int peopleCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                citizen.buyFood();
                buyers.add(citizen);
            } else if (tokens.length == 3) {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                rebel.buyFood();
                buyers.add(rebel);
            }
        }

        int foodSum = 0;
        String name = scanner.nextLine();

        while (!name.equalsIgnoreCase("end")) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equalsIgnoreCase(name)) {
                    foodSum += buyer.getFood();
                }
            }
            name = scanner.nextLine();
        }
        System.out.println(foodSum);
    }
}






