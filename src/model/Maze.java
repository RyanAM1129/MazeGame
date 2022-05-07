package model;

import controller.MazeBuilder;

public class Maze {
    final Room[][] myRooms;
    final int mySize;

    public Maze(final int theSize) {
        mySize = theSize;
        myRooms = MazeBuilder.buildRooms(mySize);
    }

    public Room[][] getBoard() {
        return myRooms;
    }

    public int getSize() {
        return mySize;
    }

    public Room getLocation(int theRow, int theColumn) {
        return myRooms[theRow][theColumn];
    }
}
