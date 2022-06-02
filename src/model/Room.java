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

    private RoomType determineType() {
        RoomType myType = RoomType.INTERIOR;
        if(myNorthDoor == null && myWestDoor == null) {
            myType = RoomType.TOP_LEFT;
        } else if(myWestDoor == null && mySouthDoor == null) {
            myType = RoomType.BOT_LEFT;
        } else if(mySouthDoor == null && myEastDoor == null) {
            myType = RoomType.BOT_RIGHT;
        } else if(myNorthDoor == null && myEastDoor == null) {
            myType = RoomType.TOP_RIGHT;
        } else if(myNorthDoor == null) {
            myType = RoomType.TOP;
        } else if(myWestDoor == null) {
            myType = RoomType.LEFT;
        } else if(mySouthDoor == null) {
            myType = RoomType.BOT;
        } else if(myEastDoor == null) {
            myType = RoomType.RIGHT;
        }
        return myType;
    }

    public boolean hasBeenVisited() {
        return myBeenVisited;
    }

    public void visit() {
        myBeenVisited = true;
    }

    public boolean hasPath() {
        if(myNorthDoor.getLockStatus() || myWestDoor.getLockStatus()
                || mySouthDoor.getLockStatus() || myEastDoor.getLockStatus()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if(myBeenVisited) {
            return "V";
        } else {
            return "?";
        }
    }
}