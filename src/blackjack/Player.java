package blackjack;
public class Player {
    private String name;
    private int score = 0;
    private Card[] cards = new Card[11];
    private int index = 0;
    private boolean alreadyLost;
    private boolean blackJack;

    //A function that adds a card to the player's hand
    public void setCards(Card card) {
        cards[index] = card;
        index++;
        updateScore(card.getValue());
    }
    // a function that updates the score of each player after every hit
    public void updateScore(int x) {

        score += x;
        System.out.println("Score " + score);

        setAlreadyLost((this.score > 21));
        setBlackJack((this.score == 21));
    }

    public boolean isAlreadyLost() {
        return alreadyLost;
    }

    public void setAlreadyLost(boolean alreadyLost) {
        this.alreadyLost = alreadyLost;
    }

    public boolean isBlackJack() {
        return blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public int getScore() {
        return score;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }



}
