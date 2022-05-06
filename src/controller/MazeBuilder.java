package controller;

import model.Door;
import model.Question;
import model.Room;

public class MazeBuilder {
    public static Room[][] buildRooms(final int theSize) {
        Door[][] myVerticalDoors = new Door[theSize][theSize - 1];
        Door[][] myHorizontalDoors = new Door[theSize - 1][theSize];
        Room[][] myRooms = new Room[theSize][theSize];

        for (int i = 0; i < theSize - 1; i++) {
            for (int j = 0; j < theSize; j++) {
                myVerticalDoors[i][j] = new Door(
                        new Question("VerticalQuestion " + i + ", " + j + ")",
                                "VerticalAnswer (" + i + ", " + j + ")"));
            }
        }

//        for(Door[] row : myVerticalDoors) {
//            for(Door door : row) {
//                door = new Door(new Question("VerticalQuestion", "VerticalAnswer"));
//            }
//        }

        for (int i = 0; i < theSize - 1; i++) {
            for (int j = 0; j < theSize; j++) {
                myHorizontalDoors[i][j] = new Door(
                        new Question("HorizontalQuestion " + i + ", " + j + ")",
                                "HorizontalAnswer (" + i + ", " + j + ")"));
            }
        }

//        for(Door[] row : myHorizontalDoors) {
//            for(Door door : row) {
//                door = new Door(new Question("HorizontalQuestion", "HorizontalAnswer"));
//            }
//        }

        //First Row / First Column
        myRooms[0][0] = new Room(null, null, myHorizontalDoors[0][0],
                myVerticalDoors[0][0]);
        //First Row / Inner Column
        for (int i = 1; i < theSize - 1; i++) {
            myRooms[0][i] = new Room(null, myVerticalDoors[0][i - 1], myHorizontalDoors[0][i],
                    myVerticalDoors[0][i]);
        }
        //First Row / Last Column
        myRooms[0][theSize - 1] = new Room(null, myVerticalDoors[0][theSize - 2],
                myHorizontalDoors[0][theSize - 1], null);
        //Inner Row
        for (int i = 1; i < theSize - 1; i++) {
            //Inner Row / First Column
            myRooms[i][0] = new Room(myHorizontalDoors[i - 1][0], null,
                    myHorizontalDoors[i][0], myVerticalDoors[i][0]);
            //Inner Row / Inner Column
            for (int j = 1; j < theSize - 1; j++) {
                myRooms[i][j] = new Room(myHorizontalDoors[i - 1][j], myVerticalDoors[i][j - 1],
                        myHorizontalDoors[i][j], myVerticalDoors[i][j]);
            }
            //Inner Row / Last Column
            myRooms[i][theSize - 1] = new Room(myHorizontalDoors[i - 1][theSize - 1],
                    myVerticalDoors[i][theSize - 2], myHorizontalDoors[i][theSize - 1], null);
        }
        //Last Row / First Column
        myRooms[theSize - 1][0] = new Room(myHorizontalDoors[theSize - 2][0], null, null,
                myVerticalDoors[theSize - 1][0]);
        //Last Row / Inner Column
        for (int i = 1; i < theSize - 1; i++) {
            myRooms[theSize - 1][i] = new Room(myHorizontalDoors[theSize - 2][i],
                    myVerticalDoors[theSize - 1][i - 1], null, myVerticalDoors[theSize - 1][i]);
        }
        //Last Row / Last Column
        myRooms[theSize - 1][theSize - 1] = new Room(myHorizontalDoors[theSize - 2][theSize - 1],
                myVerticalDoors[theSize - 1][theSize - 2], null, null);

        return myRooms;
    }
}
