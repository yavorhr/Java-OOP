import enums.CardRank;
import enums.CardSuit;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;
    private int power;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
        setPower();
    }

    public void setPower() {
        this.power = cardRank.getPower() + cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank, this.cardSuit, this.power);
    }

}
