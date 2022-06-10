package model;

import controller.MazeBuilder;

/**
 * A Maze used for a trivia maze game.
 */
public class Maze {
    /**
     * All the rooms of the maze stored in s 2d-array.
     */
    protected final Room[][] myRooms;
    /**
     * The height and width of the maze. Or in other words, the number of rows
     * and columns.
     */
    protected final int mySize;
    /**
     * The current location's row index.
     */
    protected int myCurrentRow;
    /**
     * The current location's column index.
     */
    protected int myCurrentColumn;

    /**
     * Constructor using a given size.
     * Sets the current row and column to 0.
     * @param theSize the given size.
     */
    public Maze(final int theSize) {
        mySize = theSize;
        myRooms = MazeBuilder.buildRooms(mySize);
        myCurrentRow = 0;
        myCurrentColumn = 0;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    /**
     * Constructor using a given size and starting row and column.
     * @param theSize the given size.
     */
    public Maze(final int theSize, final int theStartingRow, final int theStartingColumn) {
        mySize = theSize;
        myRooms = MazeBuilder.buildRooms(mySize);
        myCurrentRow = theStartingRow;
        myCurrentColumn = theStartingColumn;
        myRooms[myCurrentRow][myCurrentColumn].visit();
    }

    /**
     * Gets the size of the Maze. Because a Maze is always square,
     * this is both length and width.
     * @return the size of the Maze.
     */
    public int getSize() {
        return mySize;
    }

    /**
     * Gets the row index of the current location.
     */
    public int getCurrentRow() {
        return myCurrentRow;
    }

    /**
     * Gets the column index of the current location.
     */
    public int getCurrentColumn() {
        return myCurrentColumn;
    }

    /**
     * Gets the Room at a given location.
     * @param theRow the row index for the desired location.
     * @param theColumn the column index for the desired location.
     */
    public Room getLocation(final int theRow, final int theColumn) {
        return myRooms[theRow][theColumn];
    }

    /**
     * Gets the Room that the player is currently in.
     */
    public Room getCurrentLocation() {
        return myRooms[myCurrentRow][myCurrentColumn];
    }

    /**
     * Returns a String representation of the Maze.
     * @return the String version of the Maze.
     */
    public String toString() {
        Room myCurrentLocation;
        RoomType myCurrentType;
        String myCurrentString;
        int buffer;

        final StringBuilder myStr = new StringBuilder();
        //Build top wall
        for (int i = 0; i <= 2 * mySize; i++) {
            if (i == 0) {
                myStr.append(".");
            } else if (i == 2 * mySize) {
                myStr.append(".\n");
            } else {
                myStr.append("=");
            }
        }

        //Build interior rows
        for (int i = 0; i < (mySize * 2) - 1; i++) {
            for (int j = 0; j < mySize; j++) {
                if (i % 2 == 0) {//Room Row
                    myCurrentLocation = myRooms[i / 2][j];
                    myCurrentString = myCurrentLocation.toString();
                    myCurrentType = myCurrentLocation.getType();
                    if(myCurrentLocation == getCurrentLocation()) {
                        myCurrentString = "0";
                    }
                    if (myCurrentType == RoomType.LEFT
                            || myCurrentType == RoomType.TOP_LEFT
                            || myCurrentType == RoomType.BOT_LEFT) {
                        myStr.append("]" + myCurrentString + myCurrentLocation.getEastDoor());
                    } else if (myCurrentType == RoomType.RIGHT
                            || myCurrentType == RoomType.TOP_RIGHT
                            || myCurrentType == RoomType.BOT_RIGHT) {
                        myStr.append(myCurrentString + "[\n");
                    } else {
                        myStr.append(myCurrentString);
                        myStr.append(myCurrentLocation.getEastDoor().toString());
                    }
                } else {//Wall Row
                    buffer = i / 2 - 1;
                    if(buffer < 0) {
                        buffer = 0;
                    }
                    myCurrentLocation = myRooms[buffer][j];
                    if (myCurrentLocation.getType() == RoomType.LEFT
                            || myCurrentLocation.getType() == RoomType.TOP_LEFT) {
                        myStr.append("]" + myCurrentLocation.getSouthDoor() + "+");
                    } else if (myCurrentLocation.getType() == RoomType.RIGHT
                            || myCurrentLocation.getType() == RoomType.TOP_RIGHT) {
                        myStr.append(myCurrentLocation.getSouthDoor() + "[\n");
                    } else {
                        myStr.append(myCurrentLocation.getSouthDoor().toString() + "+");
                    }
                }
            }
        }

        //Build bottom wall
        for (int i = 0; i <= 2 * mySize; i++) {
            if (i == 0) {
                myStr.append("'");
            } else if (i == 2 * mySize) {
                myStr.append("'");
            } else {
                myStr.append("=");
            }
        }
        return myStr.toString();
    }
}
