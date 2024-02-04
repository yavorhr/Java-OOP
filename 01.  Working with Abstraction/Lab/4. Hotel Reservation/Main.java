import enums.Discount;
import enums.Season;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        String dayOfWeek = tokens[2];
        String discountType = tokens[3];

        Season season = Season.valueOf(dayOfWeek.toUpperCase());
        Discount discount = Discount.valueOf(discountType);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discount);
        double result = priceCalculator.calculatePrice();

        System.out.printf("%.2f", result);
    }
}
