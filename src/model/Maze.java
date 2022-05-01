package model;

public interface Maze {
    /**
     * Returns the 2d array representing the game board.
     *
     * @return the 2d array.
     * @param <T> the type of Object the array holds.
     */
    <T> T[][] getBoard();
    /**
     * Returns the number of rows (which is also the number of columns).
     *
     * @return the number of rows (which is also the number of columns).
     */
    int getSize();
    /**
     * Returns the value of the given location.
     *
     * @param theRow the row index.
     * @param theColumn the column index.
     * @param <T> the type of Object the array holds.
     * @return the Object at given location.
     */
    <T> T getLocation(int theRow, int theColumn);
}
