package ca.sheridancollege.project;

/**
 * Represents a player in a card game. Each player has a name and a hand of
 * cards.
 * 
 * @author Yug Patel
 */
public class Player 
{
    private PlayerHand playerHand; // The hand of cards held by the player.

    private String playerName; // The name of the player.

    /**
     * Set the player's hand.
     *
     * @param playerHand The hand of cards to be associated with the player.
     */
    public void setPlayerHand(PlayerHand playerHand) 
    {
        this.playerHand = playerHand;
    }

    /**
     * Get the player's hand.
     *
     * @return The hand of cards held by the player.
     */
    public PlayerHand getPlayerHand() 
    {
        return this.playerHand;
    }

    /**
     * Set the player's name.
     *
     * @param name The name to be assigned to the player.
     */
    public void setPlayerName(String name) 
    {
        this.playerName = name;
    }

    /**
     * Get the player's name.
     *
     * @return The name of the player.
     */
    public String getPlayerName() 
    {
        return this.playerName;
    }
}