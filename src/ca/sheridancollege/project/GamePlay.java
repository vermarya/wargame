package ca.sheridancollege.project;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the main game logic for the "Card War Game." Manages the flow of
 * the game,
 * including dealing cards, handling rounds, and determining the winner.
 * 
 * @author Aryan Verma
 * @author Keshav Keshav
 * @author Vaidehi Himanshu Dhamecha
 */
public class GamePlay 
{
    private GroupOfCards groupOfCards; // The group of cards used in the game.

    private Player playerOne; // Player one in the game.

    private Player playerTwo; // Player two in the game.

    /**
     * Prints information about the game.
     */
    private void printAboutGame() 
    {
        System.out.println("\n\t\t\tCard War Game\n" +
                "\nThe Game will be played automatically until the deck is empty." +
                "\nThe player(s) name will be required to play the game.\n");
    }

    /**
     * Prints the header with player names and the number of cards they have.
     *
     * @param playerOne Player one.
     * @param playerTwo Player two.
     */
    private void printHeader(Player playerOne, Player playerTwo) 
    {
        System.out.printf("\n%-25s   %-25s %-25s   %-25s %-25s \n\n", playerOne.getPlayerName(), "Hand Cards",
                playerTwo.getPlayerName(), "Hand Cards", "Round Victor");
    }

    /**
     * Prints the result of a round including which player wins.
     *
     * @param playerOne     Player one.
     * @param playerOneCard Player one's card in the round.
     * @param playerTwo     Player two.
     * @param playerTwoCard Player two's card in the round.
     * @param roundVictor   The player who wins the round.
     */
    private void printRoundVictor(Player playerOne, Game playerOneCard, Player playerTwo,
            Game playerTwoCard, String roundVictor) 
            {
        System.out.printf("%-25s   %-25s %-25s   %-25s %s is the victor of this round.\n", playerOneCard.toString(),
                playerOne.getPlayerHand().playerHandSize(), playerTwoCard.toString(),
                playerTwo.getPlayerHand().playerHandSize(),
                roundVictor);
    }

    /**
     * Prints a message indicating that a round is a WAR.
     */
    private void printWarRound() 
    {
        System.out.println("\n\nIt's a WAR!\n\n");
    }

    /**
     * Prints a message indicating that a round is a tie.
     */
    private void printTie() 
    {
        System.out.println("\n\nIt's a Tie! Both players have the same number of cards.\n\n");
    }

    /**
     * Prints the name of the player who wins the game.
     *
     * @param victor The player who wins the game.
     */
    private void printVictor(Player victor) 
    {
        System.out.printf("\n%s is the victor.\n", victor.getPlayerName());
        System.out.print("\nThanks for playing.");
    }

    /**
     * Deals cards from the group of cards to a player's hand.
     *
     * @param playerHand The player's hand to receive the cards.
     */
    public void dealGameCards(PlayerHand playerHand) 
    {
        for (int i = 0; i < 26; i++) 
        {
            playerHand.putCardAtTop(groupOfCards.dealTopCard());
        }
    }

    /**
     * Checks for a war situation in the game.
     *
     * @param playerOne  Player one.
     * @param playerTwo  Player two.
     * @param playerHand The hand that holds the war cards.
     * @return True if there is a war, false otherwise.
     */
    public boolean checkForWar(Player playerOne, Player playerTwo, PlayerHand playerHand) 
    {
        Game playerOneFaceUpCard = playerOne.getPlayerHand().removeTopCard();
        Game playerTwoFaceUpCard = playerTwo.getPlayerHand().removeTopCard();

        if (playerOneFaceUpCard == null) 
        {
            return false;
        }

        if (playerTwoFaceUpCard == null) 
        {
            return false;
        }

        if (playerHand == null) 
        {
            playerHand = new PlayerHand();
        }

        playerHand.putCardAtTop(playerOneFaceUpCard);
        playerHand.putCardAtTop(playerTwoFaceUpCard);

        int result = playerOneFaceUpCard.compareTo(playerTwoFaceUpCard);

        switch (result) 
        {
            case 0:
                printWarRound();

                List<Game> playerOneWar = playerOne.getPlayerHand().getHandCards(3);
                if (playerOneWar == null) {
                    return false;
                }
                playerHand.putCardsAtTop(playerOneWar);

                List<Game> playerTwoWar = playerTwo.getPlayerHand().getHandCards(3);
                if (playerTwoWar == null) {
                    return false;
                }
                playerHand.putCardsAtTop(playerTwoWar);

                return checkForWar(playerOne, playerTwo, playerHand);

            case 1:
                playerOne.getPlayerHand().mergeCards(playerHand);
                printRoundVictor(playerOne, playerOneFaceUpCard, playerTwo, playerTwoFaceUpCard,
                        playerOne.getPlayerName());
                break;

            case -1:
                playerTwo.getPlayerHand().mergeCards(playerHand);
                printRoundVictor(playerOne, playerOneFaceUpCard, playerTwo, playerTwoFaceUpCard,
                        playerTwo.getPlayerName());
                break;
        }

        return true;
    }

    /**
     * Main method to start the game.
     */
    public void play() 
    {
        printAboutGame();

        Scanner input = new Scanner(System.in);

        System.out.print("1. Play with Bot\n2. Play with Player\n3. Exit\nEnter your choice :");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter your name : ");
                String playerName = input.nextLine();
                this.playerOne = new Player();
                this.playerOne.setPlayerName(playerName);
                this.playerTwo = new Player();
                this.playerTwo.setPlayerName("Bot");
                break;
            case 2:
                System.out.print("Enter player one name : ");
                String playerOneName = input.nextLine();
                this.playerOne = new Player();
                this.playerOne.setPlayerName(playerOneName);

                System.out.print("\nEnter player two name : ");
                String playerTwoName = input.nextLine();
                this.playerTwo = new Player();
                this.playerTwo.setPlayerName(playerTwoName);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
        input.close();

        groupOfCards = new GroupOfCards();
        groupOfCards.shuffleCards();

        playerOne.setPlayerHand(new PlayerHand());
        playerTwo.setPlayerHand(new PlayerHand());

        dealGameCards(playerOne.getPlayerHand());
        dealGameCards(playerTwo.getPlayerHand());

        printHeader(playerOne, playerTwo);

        int maxRoundPlay = 27;
        Player victor = null;

        while (checkForWar(playerOne, playerTwo, null)) 
        {
            maxRoundPlay--;
            if (playerOne.getPlayerHand().playerHandSize() == 0) 
            {
                victor = playerTwo;
                break;
            } 
            else if (playerTwo.getPlayerHand().playerHandSize() == 0) 
            {
                victor = playerOne;
                break;
            }

            if (maxRoundPlay < 0) 
            {
                break;
            }
        }

        if (playerOne.getPlayerHand().playerHandSize() > playerTwo.getPlayerHand().playerHandSize()) 
        {
            victor = playerOne;
        } 
        else if (playerTwo.getPlayerHand().playerHandSize() > playerOne.getPlayerHand().playerHandSize()) 
        {
            victor = playerTwo;
        } 
        else 
        {
            printTie();
            return;
        }

        printVictor(victor);
    }

}
