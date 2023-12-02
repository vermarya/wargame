package ca.sheridancollege.project;

import java.util.Objects;

/**
 * Represents a playing card in a card game. Each card has a suit and a rank,
 * and
 * can be compared to other cards based on their ranks.
 * 
 * @author Keshav Keshav
 */
public class Game implements Comparable<Game> 
{
    private final Suit suit; // The suit of the card.
    private final Rank rank; // The rank of the card.
    private final String gameCard; // A formatted representation of the card.

    /**
     * Constructor for the Game class. Initializes a card with a specified rank and
     * suit.
     *
     * @param rank The rank of the card.
     * @param suit The suit of the card.
     */
    Game(Rank rank, Suit suit) 
    {
        if (rank == null || suit == null) 
        {
            throw new NullPointerException();
        }
        this.suit = suit;
        this.rank = rank;
        this.gameCard = String.format("%s%s", rank.toString(), suit.getSuitSymbol());
    }

    /**
     * Get the formatted information of the card.
     *
     * @return The formatted card information (e.g., "2H" for 2 of Hearts).
     */
    public String getCardInfo() 
    {
        return this.gameCard;
    }

    @Override
    public int compareTo(Game gameCard) 
    {
        return this.rank.getRankPoints().compareTo(gameCard.rank.getRankPoints());
    }

    /**
     * Check if the card has the same suit as another card.
     *
     * @param gameCard The other card to compare with.
     * @return True if the cards have the same suit, false otherwise.
     */
    public boolean isSameSuit(Game gameCard) 
    {
        return this.suit.equals(gameCard.suit);
    }

    /**
     * Check if the card has the same rank as another card.
     *
     * @param gameCard The other card to compare with.
     * @return True if the cards have the same rank, false otherwise.
     */
    public boolean isSameRank(Game gameCard) 
    {
        return this.rank.equals(gameCard.rank);
    }

    @Override
    public boolean equals(Object object) 
    {
        if (object == null) 
        {
            return false;
        }
        if (!Game.class.isAssignableFrom(object.getClass())) 
        {
            return false;
        }
        final Game otherCard = (Game) object;

        return this.suit == otherCard.suit && this.rank == otherCard.rank;
    }

    @Override
    public int hashCode() 
    {
        int hashValue = 4;
        hashValue = 69 * hashValue + Objects.hashCode(this.rank);
        hashValue = 69 * hashValue + Objects.hashCode(this.suit);

        return hashValue;
    }

    @Override
    public String toString() 
    {
        String rankName = this.rank.getRankName();
        String suitName = this.suit.getSuitName();
        String fullCardName = rankName + " of " + suitName;

        return fullCardName;
    }

    // Main method to start a game
    public static void main(String[] args) 
    {
        GamePlay gamePlay = new GamePlay();
        gamePlay.play();
    }
}

