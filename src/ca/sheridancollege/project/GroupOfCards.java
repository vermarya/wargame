package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a group of playing cards in a card game. This class provides
 * functionality to manage and manipulate a collection of cards.
 * 
 * @author Aryan Verma
 * @author Vaidehi Himanshu Dhamecha
 */
public class GroupOfCards 
{
    private final List<Game> cards; // The list of cards in the group.

    /**
     * Constructor for the GroupOfCards class. Initializes an empty list of cards
     * and
     * generates a standard deck of playing cards.
     */
    GroupOfCards() 
    {
        this.cards = new ArrayList<>();
        generateCards();
    }

    /**
     * Generates a standard deck of playing cards by combining all possible suits
     * and ranks.
     */
    private void generateCards() 
    {
        for (Suit suit : Suit.values()) 
        {
            for (Rank rank : Rank.values()) 
            {
                cards.add(new Game(rank, suit));
            }
        }
    }

    /**
     * Shuffle the cards in the group.
     */
    public void shuffleCards() 
    {
        Collections.shuffle(this.cards);
    }

    /**
     * Deal the top card from the group.
     *
     * @return The top card in the group or null if the group is empty.
     */
    public Game dealTopCard() 
    {
        int groupSize = this.cards.size();

        if (groupSize > 0) 
        {
            return this.cards.remove(groupSize - 1);
        } 
        else 
        {
            return null;
        }
    }

    /**
     * Put a card at the bottom of the group.
     *
     * @param game The card to be added to the bottom of the group.
     */
    public void putCardAtBottom(Game game) 
    {
        this.cards.add(0, game);
    }

    /**
     * Get the number of cards in the group.
     *
     * @return The number of cards in the group.
     */
    public int getNumberOfCards() 
    {
        return this.cards.size();
    }

    /**
     * Get the list of cards in the group.
     *
     * @return The list of cards in the group.
     */
    public List<Game> getCards() 
    {
        return this.cards;
    }

    @Override
    public String toString() 
    {
        String cardSequence = this.cards.toString();
        return cardSequence;
    }
}