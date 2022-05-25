package model;

import controller.MazeBuilder;

public class Maze {
    private final Room[][] myRooms;
    private final int mySize;
    private int myCurrentRow;
    private int myCurrentColumn;

    public Maze(final int theSize) {
        mySize = theSize;
        myRooms = MazeBuilder.buildRooms(mySize);
        myCurrentRow = 3;
        myCurrentColumn = 3;
    }

    public Room[][] getBoard() {
        return myRooms;
    }

    public int getSize() {
        return mySize;
    }

    public int getCurrentRow() {
        return myCurrentRow;
    }

    public int getCurrentColumn() {
        return myCurrentColumn;
    }

    public Room getLocation(int theRow, int theColumn) {
        return myRooms[theRow][theColumn];
    }
}
