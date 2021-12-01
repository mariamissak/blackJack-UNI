package blackjack;
public class Card {
    final private int suit;
    final private int rank;
    final private int value;

//constructor with the three parameters
    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
// copy constructor
    public Card(Card card) {
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

}
