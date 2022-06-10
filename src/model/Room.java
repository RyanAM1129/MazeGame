package model;

/**
 * A room in a trivia maze.
 */
public class Room {
    /**
     * The north {@link Door} of the Room.
     */
    private final Door myNorthDoor;
    /**
     * The west {@link Door} of the Room.
     */
    private final Door myWestDoor;
    /**
     * The south {@link Door} of the Room.
     */
    private final Door mySouthDoor;
    /**
     * The east {@link Door} of the Room.
     */
    private final Door myEastDoor;
    /**
     * The type of room. Refer to {@link RoomType}.
     */
    private final RoomType myType;
    /**
     * A boolean keeping track of whether the door has been visited or not.
     * It is true if it has been visited, false if not.
     */
    private boolean myBeenVisited;

    /**
     * A constructor using given north, west, south, and east doors, and given
     * {@link RoomType}.
     * @param theNorthDoor the north {@link Door}.
     * @param theWestDoor the west {@link Door}.
     * @param theSouthDoor the south {@link Door}.
     * @param theEastDoor the east {@link Door}.
     * @param theType the {@link DoorType}.
     */
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

    /**
     * Gets the {@link Door} to the north of the Room.
     */
    public Door getNorthDoor() {
        return myNorthDoor;
    }

    /**
     * Gets the {@link Door} to the west of the Room.
     */
    public Door getWestDoor() {
        return myWestDoor;
    }

    /**
     * Gets the {@link Door} to the south of the Room.
     */
    public Door getSouthDoor() {
        return mySouthDoor;
    }

    /**
     * Gets the {@link Door} to the east of the Room.
     */
    public Door getEastDoor() {
        return myEastDoor;
    }

    /**
     * Gets the {@link RoomType}.
     */
    public RoomType getType() {
        return myType;
    }

    /**
     * Gets a boolean based on whether the Room has been visited or not.
     * @return true if the room has been visited, false if not.
     */
    public boolean hasBeenVisited() {
        return myBeenVisited;
    }

    /**
     * Marks the room as visited.
     */
    public void visit() {
        myBeenVisited = true;
    }

    /**
     * Returns a String representation of the Room.
     * @return @return a String with value "?" if it hasn't been visited,
     * "V" if it has, and "X" if it is an exit.
     */
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