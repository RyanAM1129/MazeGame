package model;

/**
 * A class representing a Trivia Game.
 * @see model.Maze
 */
public class Game extends Maze {
    /**
     * The remaining wrong answers, or health.
     */
    private int myHealth;
    /**
     * A boolean value of whether the game was won or not.
     */
    private boolean myGameWon;
    /**
     * A boolean value of whether the game was lost or not.
     */
    private boolean myGameLost;

    /**
     * Default constructor.
     * Size of the {@link Maze} is set to 5.
     * Health is set to 4.
     */
    public Game() {
        super(5);
        myHealth = 4;
        myGameWon = false;
        myGameLost = false;
    }

    /**
     * Overloaded Constructor for a given Maze size.
     * Health is set to 4.
     * @param theBoardSize the given size.
     */
    public Game(final int theBoardSize) {
        super(theBoardSize);
        myHealth = 4;
        myGameWon = false;
        myGameLost = false;
    }

    /**
     * Overloaded Constructor for given {@link Maze} size, health, and starting position.
     * @param theBoardSize the given size.
     * @param theHealth the given health.
     * @param theStartingRow the row of the starting location.
     * @param theStartingColumn the column of the starting location.
     */
    public Game(final int theBoardSize, final int theHealth, final int theStartingRow,
                final int theStartingColumn) {
        super(theBoardSize, theStartingRow, theStartingColumn);
        myHealth = theHealth;
        myGameWon = false;
        myGameLost = false;
    }

    /**
     * Returns the current Health.
     * @return current health.
     */
    public int getHealth() {
        return myHealth;
    }

    /**
     * Returns a boolean based on if the game is over. It returns true if the game is
     * over, and returns false if it is not. It is true is either myGameWon or myGameLost
     * is true.
     * @return true if the game is over, false if not.
     */
    public boolean isMyGameOver() {
        return myGameWon || myGameLost;
    }

    /**
     * Returns a boolean based on if the game is lost or not. It returns true if the game
     * has been lost, false if not.
     * @return true if the game has been lost, false if not.
     */
    public boolean isMyGameLost() {
        return myGameLost;
    }

    /**
     * Returns a boolean based on if the game is won or not. It returns true if the game
     * has been won, false if not.
     * @return true if the game has been won, false if not.
     */
    public boolean isMyGameWon() {
        return myGameWon;
    }

    /**
     * Moves the current location north and visits the new location.
     */
    public void moveNorth() {
        myCurrentRow--;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    /**
     * Moves the current location west and visits the new location.
     */
    public void moveWest() {
        myCurrentColumn--;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    /**
     * Moves the current location south and visits the new location.
     */
    public void moveSouth() {
        myCurrentRow++;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    /**
     * Checks if the move would be out of bounds and moves the current location east and
     * visits the new location if not. If it is, it marks the game as won.
     */
    public void moveEast() {
        if(myCurrentColumn + 1 == mySize) {
            myGameWon = true;
        } else {
            myCurrentColumn++;
            myRooms[myCurrentRow][myCurrentColumn].visit();
        }
    }

    /**
     * Subtracts one from the current total health. If the health reaches 0 it marks the
     * game as lost.
     */
    public void minusHealth() {
        myHealth--;
        if (myHealth <= 0) {
            myGameLost = true;
        }
    }
}
