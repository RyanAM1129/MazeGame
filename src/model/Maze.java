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
        Room myCurrentLocation;
        RoomType myCurrentType;
        int buffer;

        StringBuilder myStr = new StringBuilder();
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
        for (int i = 0; i < mySize * 2; i++) {
            for (int j = 0; j < mySize; j++) {
                if (i % 2 == 0) {//Room Row
                    myCurrentLocation = myRooms[i / 2][j];
                    myCurrentType = myCurrentLocation.getType();
                    if (myCurrentType == RoomType.LEFT
                            || myCurrentType == RoomType.TOP_LEFT
                            || myCurrentType == RoomType.BOT_LEFT) {
                        myStr.append("|" + myCurrentLocation + myCurrentLocation.getEastDoor());
                    } else if (myCurrentType == RoomType.RIGHT
                            || myCurrentType == RoomType.TOP_RIGHT
                            || myCurrentType == RoomType.BOT_RIGHT) {
                        myStr.append(myCurrentLocation + "|\n");
                    } else {
                        myStr.append(myCurrentLocation);
                        myStr.append(myCurrentLocation.getEastDoor().toString());
                    }
                } else {//Wall Row
                    buffer = (i / 2) - 1;
                    if(buffer < 0) {
                        buffer = 0;
                    }
                    myCurrentLocation = myRooms[buffer][j];
                    if (myCurrentLocation.getType() == RoomType.LEFT
                            || myCurrentLocation.getType() == RoomType.TOP_LEFT) {
                        myStr.append("|" + myCurrentLocation.getSouthDoor() + "+");
                    } else if (myCurrentLocation.getType() == RoomType.RIGHT
                            || myCurrentLocation.getType() == RoomType.TOP_RIGHT) {
                        myStr.append(myCurrentLocation.getSouthDoor() + "|\n");
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
                myStr.append("'\n");
            } else {
                myStr.append("=");
            }
        }
        return myStr.toString();
    }
}
