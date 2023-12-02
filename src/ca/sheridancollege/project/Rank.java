package ca.sheridancollege.project;

/**
 * This enum represents the ranks of playing cards in a standard deck.
 * Each rank has a name and a point value associated with it.
 * 
 * @author Aryan Verma
 */
public enum Rank 
{
    TWO("TWO", 2),
    THREE("THREE", 3),
    FOUR("FOUR", 4),
    FIVE("FIVE", 5),
    SIX("SIX", 6),
    SEVEN("SEVEN", 7),
    EIGHT("EIGHT", 8),
    NINE("NINE", 9),
    TEN("TEN", 10),
    JACK("JACK", 11),
    QUEEN("QUEEN", 12),
    KING("KING", 13),
    ACE("ACE", 14);

    private final String rankName;
    private final int rankPoints;

    /**
     * Constructor for the Rank enum.
     *
     * @param rankName   The name of the rank (e.g., "TWO").
     * @param rankPoints The point value of the rank (e.g., 2).
     */
    Rank(String rankName, int rankPoints) 
    {
        this.rankName = rankName;
        this.rankPoints = rankPoints;
    }

    /**
     * Get the name of the rank.
     *
     * @return The name of the rank (e.g., "TWO").
     */
    public String getRankName() 
    {
        return this.rankName;
    }

    /**
     * Get the point value of the rank.
     *
     * @return The point value of the rank (e.g., 2).
     */
    public Integer getRankPoints() 
    {
        return this.rankPoints;
    }

    @Override
    public String toString() 
    {
        if (this.getRankPoints() > 10) 
        {
            return this.getRankName().substring(0, 1);
        }

        return String.valueOf(this.getRankPoints());
    }
}
