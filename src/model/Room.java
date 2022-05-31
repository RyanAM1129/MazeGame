package model;

public class Room {
    private final Door myNorthDoor;
    private final Door myWestDoor;
    private final Door mySouthDoor;
    private final Door myEastDoor;
    private boolean myBeenVisited;

    public Room(final Door theNorthDoor, final Door theWestDoor,
                final Door theSouthDoor, final Door theEastDoor){
        myNorthDoor = theNorthDoor;
        myWestDoor = theWestDoor;
        mySouthDoor = theSouthDoor;
        myEastDoor = theEastDoor;
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
}