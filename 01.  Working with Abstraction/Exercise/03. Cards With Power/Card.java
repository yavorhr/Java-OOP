public class Card {
    private CardRanks number;
    private CardSuits color;
    private int power;

    public Card(CardRanks number, CardSuits color) {
        this.number = number;
        this.color = color;
        this.power = number.getPower() + color.getPower();
    }

    @Override
    public String toString() {
        String cardName = this.number + " of " + this.color;
        return String.format("Card name: %s; Card power: %d", cardName, this.power);
    }
}
