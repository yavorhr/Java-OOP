import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String seasonString = input[2];
        String discountString = input[3];

        Season season = Season.valueOf(seasonString.toUpperCase());
        Discount discount = Discount.valueOf(discountString);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discount);
        System.out.printf("%.2f",priceCalculator.calculatePrice());


    }
}