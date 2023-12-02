package ca.sheridancollege.project;

/**
 * This enum represents the different suits in a standard deck of playing cards.
 * Each suit has a name and a symbol associated with it.
 * 
 * @author Aryan Verma
 */
public enum Suit 
{
    HEARTS("HEART", "H"),
    SPADES("SPADE", "S"),
    DIAMONDS("DIAMOND", "D"),
    CLUBS("CLUB", "C");

    private final String suitName;
    private final String suitSymbol;

    /**
     * Constructor for the Suit enum.
     *
     * @param suitName   The name of the suit (e.g., "HEART").
     * @param suitSymbol The symbol representing the suit (e.g., "H").
     */
    Suit(String suitName, String suitSymbol) 
    {
        this.suitName = suitName;
        this.suitSymbol = suitSymbol;
    }

    /**
     * Get the name of the suit.
     *
     * @return The name of the suit (e.g., "HEART").
     */
    public String getSuitName() 
    {
        return this.suitName;
    }

    /**
     * Get the symbol representing the suit.
     *
     * @return The symbol representing the suit (e.g., "H").
     */
    public String getSuitSymbol() 
    {
        return this.suitSymbol;
    }

    @Override
    public String toString() 
    {
        return this.getSuitSymbol();
    }
}

