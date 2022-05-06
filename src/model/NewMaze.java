package model;

import controller.MazeBuilder;

public class NewMaze {
    final Room[][] myRooms;
    final int mySize;

    public NewMaze(final int theSize) {
        mySize = theSize;
        myRooms = MazeBuilder.buildRooms(mySize);
    }
}
