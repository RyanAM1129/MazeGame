package model;

public class Room {
    private Door myNorthDoor;
    private Door myWestDoor;
    private Door mySouthDoor;
    private Door myEastDoor;

    public Room(final Door theNorthDoor, final Door theWestDoor,
                final Door theSouthDoor, final Door theEastDoor){
        myNorthDoor = theNorthDoor;
        myWestDoor = theWestDoor;
        mySouthDoor = theSouthDoor;
        myEastDoor = theEastDoor;
    }

    public Door getNorthDoor() {
        return myNorthDoor;
    }

    public Door getWestDoor() {
        return myWestDoor;
    }

    public Door getSouthDoor() {
        return mySouthDoor;
    }

    public Door getEastDoor() {
        return myEastDoor;
    }
}