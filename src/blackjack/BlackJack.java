package blackjack;
import java.util.Scanner; 
public class BlackJack {

    static Game game = new Game();

    public static void main(String[] args)
    {
        GUI gui = new GUI();
        game.generateDeck();
        game.setInfo();
        gui.runGUI(game.getDeck(), game.getPlayer(0).getCards(), game.getPlayer(1).getCards(), game.getPlayer(2).getCards(), game.getPlayer(3).getCards() );

        // a loop to go over the 3 players
        for(int i = 0;i<3;i++)
        {
            Scanner in = new Scanner(System.in);

            while(game.getPlayer(i).getScore()<22)
            {
                //checks if score = 21 if yes breaks out of loop
                if(game.getPlayer(i).getScore() == 21) break;

                //check for player input
                System.out.println("Hit (h) or Stand (s)?");
                char choice = in.next().charAt(0);

                // if hit then will draw a card
                if(choice == 'h' || choice == 'H')
                {
                    gui.updatePlayerHand(drawAfter(i), i);
                }

                //if stand it will break out of the loop
                else if ( choice == 'S' || choice == 's')
                {
                    System.out.println("Current Score " + game.getPlayer(i).getScore());
                    break;
                }
            }

            
        }
        //updates game high score
        game.updateHS();
        System.out.println("High Score " + game.getValidHS());

        //dealer
        while (game.getPlayer(3).getScore() <= game.getValidHS()) {
            gui.updateDealerHand(drawAfter(3), game.getDeck());

            if (game.getPlayer(3).getScore() >= 21)
                break;
        }

        result();
    }
    
    // a function that draws cards after setting info
    public static Card drawAfter(int i)
    {
        Card c = game.drawCard();
        game.getPlayer(i).setCards(c);
        return c;
    }

    // a function that prints out result
    public static void result()
    {
        int counter = 0;
        int mx = game.getValidHS();
        if (game.getPlayer(3).getScore() <= 21)
            mx = java.lang.Math.max(mx, game.getPlayer(3).getScore());
        
        for(int i = 0; i < 4; i++)
        {
            if (game.getPlayer(i).getScore() == mx) {
                counter++;
            }
        }


        if(counter == 1)
        {
            for (int i = 0; i < 4; i++)
            {
                if (game.getPlayer(i).getScore() == mx)
                {
                    if(i!=3) System.out.println("Player " + (i+1) + " Wins!");
                    else System.out.println("Dealer Wins!");
                }

            }
        }
        else
        {
            System.out.println("Push!");
        }
    }
}
