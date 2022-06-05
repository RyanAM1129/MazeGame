package controller;

import model.*;

public class MazeBuilder {
    public static Room[][] buildRooms(final int theSize) {
        Door[][] myVerticalDoors = new Door[theSize][theSize - 1];
        Door[][] myHorizontalDoors = new Door[theSize - 1][theSize];
        Room[][] myRooms = new Room[theSize][theSize];
        QuestionBuilder QB = new QuestionBuilder(2 * theSize * (theSize - 1));

        for (int i = 0; i < theSize; i++) {
            for (int j = 0; j < theSize - 1; j++) {
                myVerticalDoors[i][j] = new Door(QB.getQuestion(), DoorType.VERTICAL);
            }
        }

        for (int i = 0; i < theSize - 1; i++) {
            for (int j = 0; j < theSize; j++) {
                myHorizontalDoors[i][j] = new Door(QB.getQuestion(), DoorType.HORIZONTAL);
            }
        }

        //First Row / First Column
        myRooms[0][0] = new Room(null, null, myHorizontalDoors[0][0],
                myVerticalDoors[0][0], RoomType.TOP_LEFT);
        //First Row / Inner Column
        for (int i = 1; i < theSize - 1; i++) {
            myRooms[0][i] = new Room(null, myVerticalDoors[0][i - 1], myHorizontalDoors[0][i],
                    myVerticalDoors[0][i], RoomType.TOP);
        }
        //First Row / Last Column
        myRooms[0][theSize - 1] = new Room(null, myVerticalDoors[0][theSize - 2],
                myHorizontalDoors[0][theSize - 1], null, RoomType.TOP_RIGHT);
        //Inner Row
        for (int i = 1; i < theSize - 1; i++) {
            //Inner Row / First Column
            myRooms[i][0] = new Room(myHorizontalDoors[i - 1][0], null,
                    myHorizontalDoors[i][0], myVerticalDoors[i][0], RoomType.LEFT);
            //Inner Row / Inner Column
            for (int j = 1; j < theSize - 1; j++) {
                myRooms[i][j] = new Room(myHorizontalDoors[i - 1][j], myVerticalDoors[i][j - 1],
                        myHorizontalDoors[i][j], myVerticalDoors[i][j], RoomType.INTERIOR);
            }
            //Inner Row / Last Column
            myRooms[i][theSize - 1] = new Room(myHorizontalDoors[i - 1][theSize - 1],
                    myVerticalDoors[i][theSize - 2], myHorizontalDoors[i][theSize - 1], null,
                    RoomType.RIGHT);
        }
        //Last Row / First Column
        myRooms[theSize - 1][0] = new Room(myHorizontalDoors[theSize - 2][0], null, null,
                myVerticalDoors[theSize - 1][0], RoomType.BOT_LEFT);
        //Last Row / Inner Column
        for (int i = 1; i < theSize - 1; i++) {
            myRooms[theSize - 1][i] = new Room(myHorizontalDoors[theSize - 2][i],
                    myVerticalDoors[theSize - 1][i - 1], null, myVerticalDoors[theSize - 1][i],
                    RoomType.BOT);
        }
        //Last Row / Last Column
        myRooms[theSize - 1][theSize - 1] = new Room(myHorizontalDoors[theSize - 2][theSize - 1],
                myVerticalDoors[theSize - 1][theSize - 2], null,
                new Door(QB.getFinalQuestion(), DoorType.VERTICAL), RoomType.BOT_RIGHT);

        return myRooms;
    }
}
