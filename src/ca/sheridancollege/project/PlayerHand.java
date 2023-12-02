package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's hand of cards in a card game. This class allows players
 * to
 * manage and manipulate their hand of cards, including adding, removing, and
 * merging cards.
 * 
 * @author Yug Patel
 */
public class PlayerHand 
{
    private final List<Game> cards;

    /**
     * Constructor for the PlayerHand class. Initializes an empty list to store
     * cards.
     */
    PlayerHand() 
    {
        this.cards = new ArrayList<>();
    }

    /**
     * Get a specified number of cards from the top of the player's hand.
     *
     * @param totalCards The number of cards to retrieve.
     * @return A list of cards from the top of the player's hand. Returns null if
     *         there are not enough cards.
     */
    public List<Game> getHandCards(int totalCards) 
    {
        if (totalCards > this.playerHandSize()) 
        {
            return null;
        }

        List<Game> openedCards = new ArrayList<>();
        for (int i = 0; i < totalCards; i++) 
        {
            openedCards.add(this.cards.remove(this.playerHandSize() - 1));
        }

        return openedCards;
    }

    /**
     * Put a card at the top of the player's hand.
     *
     * @param game The card to be added to the top of the hand. Must not be null.
     * @throws NullPointerException if the provided card is null.
     */
    public void putCardAtTop(Game card) 
    {
        if (card == null) 
        {
            throw new NullPointerException("Null card is not allowed");
        }
        cards.add(card);
    }

    /**
     * Put a list of cards at the top of the player's hand.
     *
     * @param gameCards The list of cards to be added to the top of the hand.
     */
    public void putCardsAtTop(List<Game> gameCards) 
    {
        this.cards.addAll(gameCards);
    }

    /**
     * Put a card at the bottom of the player's hand.
     *
     * @param game The card to be added to the bottom of the hand.
     */
    public void putCardAtBottom(Game card) 
    {
        cards.add(0, card);
    }

    /**
     * Remove and return the top card from the player's hand.
     *
     * @return The top card in the player's hand, or null if the hand is empty.
     */
    public Game removeTopCard() 
    {
        if (playerHandSize() < 1) 
        {
            return null;
        }

        return cards.remove(playerHandSize() - 1);
    }

    /**
     * Remove and return the bottom card from the player's hand.
     *
     * @return The bottom card in the player's hand, or null if the hand is empty.
     */
    public Game removeBottomCard() 
    {
        if (playerHandSize() < 1) 
        {
            return null;
        }

        return cards.remove(0);
    }

    /**
     * Merge the cards from another player's hand into this player's hand.
     *
     * @param playerHand The player hand from which to merge cards.
     */
    public void mergeCards(PlayerHand playerHand) 
    {
        for (Game cardGame : playerHand.cards) 
        {
            this.putCardAtBottom(cardGame);
        }
    }

    /**
     * Get the current size of the player's hand.
     *
     * @return The number of cards in the player's hand.
     */
    public int playerHandSize() 
    {
        return cards.size();
    }
}