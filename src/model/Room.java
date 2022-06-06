package model;

public class Room {
    private final Door myNorthDoor;
    private final Door myWestDoor;
    private final Door mySouthDoor;
    private final Door myEastDoor;
    private final RoomType myType;
    private boolean myBeenVisited;

    public Room(final Door theNorthDoor, final Door theWestDoor,
                final Door theSouthDoor, final Door theEastDoor,
                final RoomType theType){
        myNorthDoor = theNorthDoor;
        myWestDoor = theWestDoor;
        mySouthDoor = theSouthDoor;
        myEastDoor = theEastDoor;
        myType = theType;
        myBeenVisited = false;
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

    public RoomType getType() {
        return myType;
    }

    public boolean hasBeenVisited() {
        return myBeenVisited;
    }

    public void visit() {
        myBeenVisited = true;
    }

    public String toString() {
        if(myType == RoomType.BOT_RIGHT) {
            return "X";
        } else if(myBeenVisited) {
            return "V";
        } else {
            return "?";
        }
    }
}