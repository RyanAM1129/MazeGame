package model;

public class Game extends Maze {
    private int myHealth;
    private boolean myGameWon;
    private boolean myGameLost;

    public Game() {
        super(5);
        myHealth = 4;
        myGameWon = false;
        myGameLost = false;
    }

    public Game(final int theBoardSize) {
        super(theBoardSize);
        myHealth = 4;
        myGameWon = false;
        myGameLost = false;
    }

    public Game(final int theBoardSize, final int theHealth, final int theStartingRow,
                final int theStartingColumn) {
        super(theBoardSize, theStartingRow, theStartingColumn);
        myHealth = theHealth;
        myGameWon = false;
        myGameLost = false;
    }

    public int getHealth() {
        return myHealth;
    }

    public boolean isMyGameOver() {
        return myGameWon || myGameLost;
    }

    public boolean isMyGameLost() {
        return myGameLost;
    }

    public boolean isMyGameWon() {
        return myGameWon;
    }

    public void moveNorth() {
        myCurrentRow--;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    public void moveWest() {
        myCurrentColumn--;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    public void moveSouth() {
        myCurrentRow++;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    public void moveEast() {
        if(myCurrentColumn + 1 == mySize) {
            myGameWon = true;
        } else {
            myCurrentColumn++;
            myRooms[myCurrentRow][myCurrentColumn].visit();
        }
    }

    public void minusHealth() {
        myHealth--;
        if (myHealth <= 0) {
            myGameLost = true;
        }
    }
}
