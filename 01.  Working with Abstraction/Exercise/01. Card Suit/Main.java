public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardSuits suit : CardSuits.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", suit.ordinal(), suit));
        }
        System.out.println();
    }
}
