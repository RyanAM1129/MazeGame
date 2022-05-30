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
        myCurrentRow = 2;
        myCurrentColumn = 2;
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

    public Room getCurrentLocation() {
        return myRooms[myCurrentRow][myCurrentColumn];
    }

    public void moveNorth() {
        myCurrentRow--;
    }

    public void moveWest() {
        myCurrentColumn--;
    }

    public void moveSouth() {
        myCurrentRow++;
    }

    public void moveEast() {
        myCurrentColumn++;
    }

    public String toString() {
        StringBuilder myStr = new StringBuilder();
        for (int i = 0; i < mySize; i++) {
            for (int j = 0; j < mySize; j++) {
                if(myCurrentRow == i && myCurrentColumn == j) {
                    myStr.append("0");
                } else if(!myRooms[i][j].hasBeenVisited()) {
                    myStr.append("?");
                } else if (myRooms[i][j].hasBeenVisited() && myRooms[i][j].hasPath()) {
                    myStr.append("+");
                } else {
                    myStr.append("X");
                }
            }
            myStr.append("\n");
        }
        return myStr.toString();
    }
}
