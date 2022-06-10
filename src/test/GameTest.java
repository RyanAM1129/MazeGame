package test;

import model.Game;
import model.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Game Class.
 */
public class GameTest {
    /**
     * The Game used for testing.
     */
    Game testGame;

    /**
     * Initializes the testGame with a size of 3.
     */
    @Before
    public void init() {
        testGame = new Game(3);
    }

    /**
     * Tests the getHealth() method.
     */
    @Test
    public void getHealthTest() {
        final int expected = 4;
        final int actual = testGame.getHealth();
        assertEquals("The health values don't equal.", expected, actual);
    }

    /**
     * Tests the minusHealth() method.
     */
    @Test
    public void minusHealthTest() {
        final int expected = testGame.getHealth() - 1;
        testGame.minusHealth();
        final int actual = testGame.getHealth();
        assertEquals("The health values don't equal.", expected, actual);
    }

    /**
     * Tests the isMyGameOver() method with a true result.
     */
    @Test
    public void isMyGameOverTrueTest() {
        testGame = new Game(5, 1, 0, 0);
        final boolean expected = true;
        testGame.minusHealth();
        final boolean actual = testGame.isMyGameOver();
        assertEquals("The game is not over.", expected, actual);
    }

    /**
     * Tests the isMyGameOver() method with a false result.
     */
    @Test
    public void isMyGameOverFalseTest() {
        final boolean expected = false;
        final boolean actual = testGame.isMyGameOver();
        assertEquals("The game is over.", expected, actual);
    }

    /**
     * Tests the moveNorth() method.
     */
    @Test
    public void moveNorthTest() {
        testGame = new Game(3, 4, 1, 0);
        final Room expected = testGame.getLocation(testGame.getCurrentRow() - 1,
                testGame.getCurrentColumn());
        testGame.moveNorth();
        final Room actual = testGame.getCurrentLocation();
        assertEquals("The location did not move north.", expected, actual);
    }

    /**
     * Tests the moveWest() method.
     */
    @Test
    public void moveWestTest() {
        testGame = new Game(3, 4, 0, 1);
        final Room expected = testGame.getLocation(testGame.getCurrentRow(),
                testGame.getCurrentColumn() - 1);
        testGame.moveWest();
        final Room actual = testGame.getCurrentLocation();
        assertEquals("The location did not move west.", expected, actual);
    }

    /**
     * Tests the moveSouth() method.
     */
    @Test
    public void moveSouthTest() {
        final Room expected = testGame.getLocation(testGame.getCurrentRow() + 1,
                testGame.getCurrentColumn());
        testGame.moveSouth();
        final Room actual = testGame.getCurrentLocation();
        assertEquals("The location did not move south.", expected, actual);
    }

    /**
     * Tests the moveEast() method.
     */
    @Test
    public void moveEastTest() {
        final Room expected = testGame.getLocation(testGame.getCurrentRow(),
                testGame.getCurrentColumn() + 1);
        testGame.moveEast();
        final Room actual = testGame.getCurrentLocation();
        assertEquals("The location did not move east.", expected, actual);
    }
}
