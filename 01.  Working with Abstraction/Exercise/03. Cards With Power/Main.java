import enums.CardRank;
import enums.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentCard = scanner.nextLine();
        String currentSuit = scanner.nextLine();

        Card card = new Card(CardRank.valueOf(currentCard), CardSuit.valueOf(currentSuit));

        System.out.println(card);
    }
}
