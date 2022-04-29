package model;

/**
 * An abstract data type representing a Maze game board.
 *
 * @param <T> The type of Object the array holds.
 */
public class MazeADT<T> implements Maze {
    /**
     * A generic 2d array representing the game board.
     * It is always square.
     */
    private T[][] myBoard;
    /**
     * The number of rows and columns.
     */
    private int mySize;

    /**
     * A constructor for a MazeADT that takes the size as a parameter.
     *
     * @param theSize the desired number of rows and columns.
     */
    public MazeADT(final int theSize) {
        mySize = theSize;
        myBoard = (T[][]) new Object[mySize][];
        //Makes sure every row is initialized.
        for (int i = 0; i < mySize; i++) {
            myBoard[i] = (T[]) new Object[mySize];
        }
    }

    /**
     * Returns the 2d array representing the game board.
     *
     * @return the 2d array.
     */
    @Override
    public <T> T[][] getBoard() {
        return (T[][]) myBoard;
    }

    /**
     * Returns the number of rows (which is also the number of columns).
     *
     * @return the number of rows (which is also the number of columns).
     */
    @Override
    public int getSize() {
        return mySize;
    }

    /**
     * Returns the value of the given location.
     *
     * @param theRow the row index.
     * @param theColumn the column index.
     * @param <T> the type of Object the array holds.
     * @return the Object at given location.
     */
    @Override
    public <T> T getLocation(final int theRow, final int theColumn) {
        return (T) myBoard[theRow][theColumn];
    }

    /**
     * Sets the value at a given location.
     * Will probably only be used for testing. Consider deleting.
     *
     * @param theRow the row index.
     * @param theColumn the column index.
     * @param theObject the Object you want to set the location as.
     */
    public void setLocation(final int theRow, final int theColumn,
                            final T theObject) {
        myBoard[theRow][theColumn] = theObject;
    }
}
