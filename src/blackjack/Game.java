package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] players = new Player[4];
    private Card[] deck = new Card[52];
    private int validHS = 0;


    //A function that generates the card deck array (52 cards with different suits, ranks and values)
    void generateDeck()
    {
        for(int i =0 ; i<52 ; i++)
        {
            if( i%13 > 9)
                deck[i] = new Card(i/13 , i%13 ,10);
            else deck[i] = new Card(i/13 , i%13 ,(i+1)%13);
            System.out.println("Suit " + deck[i].getSuit() + " Rank " + deck[i].getRank() +  " Value " + deck[i].getValue());
        }

    }
//A function that draws a card randomly from the card deck array
    public Card drawCard()
    {
        //Generate a random index number using Random class that indicates the index of the card to be drawn from the card deck.
        Random rand = new Random();
        int randomChoice = rand.nextInt(52);

        while (deck[randomChoice] == null) {
            randomChoice = rand.nextInt(52);
        }
        //Saves that card object in a new object to be returned
        Card c = deck[randomChoice];

        //Make that object equals null in the card deck array
        deck[randomChoice] = null;

        //Return the new card object created that holds the drawn card from the deck
        return c;
    }
//A function that sets the information of the players
    public void setInfo()
    {
        for (int i = 0; i<4; i++)
        {
            players[i] = new Player();
            if(i!=3)
            {
                System.out.println("Please enter player "+(i+1)+" name:");
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                players[i].setName(name);
            }

            players[i].setCards(drawCard());
            players[i].setCards(drawCard());


        }
    }

    //A function to update the game maximum score of all players after any player draw a card to his hand.
    public void updateHS() {
        validHS = getValidHS();
    }

    public int getValidHS() {
        int mx = 0;
        for(int i = 0; i < 3; i++) {
            if(players[i].getScore() <= 21) {
                mx = java.lang.Math.max(players[i].getScore(), mx);
            }
        }
        
        return mx;
    }

    public Card[] getDeck() {
        return deck;
    }

    public Player getPlayer(int i)
    {
        return players[i];
    }
}
