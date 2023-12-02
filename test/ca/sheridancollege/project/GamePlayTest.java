/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {

    private GamePlay gamePlay;

    @BeforeEach
    void setUp() {
        gamePlay = new GamePlay();
    }

    @Test
    void testCheckForWar() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        PlayerHand playerHand = new PlayerHand();        

        boolean result = gamePlay.checkForWar(playerOne, playerTwo, playerHand);
        assertFalse(result);
    }

    @Test
    void testDealGameCards() {
        PlayerHand playerHand = new PlayerHand();
        gamePlay.dealGameCards(playerHand);
        assertEquals(26, playerHand.playerHandSize());
    }

    @Test
    void testPlay() {       
         gamePlay.play();
    }

}
