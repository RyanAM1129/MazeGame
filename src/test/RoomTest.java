package test;

import model.Door;
import model.Question;
import model.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Room}.
 */
public class RoomTest {
    /**
     * The north Door for myTestRoom.
     */
    Door myNorthDoor = new Door(new Question("NQ", "NA"));
    /**
     * The west Door for myTestRoom.
     */
    Door myWestDoor = new Door(new Question("WQ", "WA"));
    /**
     * The south Door for myTestRoom.
     */
    Door mySouthDoor = new Door(new Question("SQ", "SA"));
    /**
     * The east Door for myTestRoom.
     */
    Door myEastDoor = new Door(new Question("EQ", "EA"));
    /**
     * The Room being tested.
     */
    Room myTestRoom = new Room(myNorthDoor, myWestDoor, mySouthDoor, myEastDoor);

    /**
     * Tests the getNorthDoor() method.
     */
    @Test
    public void getNorthDoorTest() {
        Door expected = myNorthDoor;
        Door actual = myTestRoom.getNorthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getWestDoor() method.
     */
    @Test
    public void getWestDoorTest() {
        Door expected = myWestDoor;
        Door actual = myTestRoom.getWestDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getSouthDoor() method.
     */
    @Test
    public void getSouthDoorTest() {
        Door expected = mySouthDoor;
        Door actual = myTestRoom.getSouthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getEastDoor() method.
     */
    @Test
    public void getEastDoorTest() {
        Door expected = myEastDoor;
        Door actual = myTestRoom.getEastDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the visit() method.
     */
    @Test
    public void visitTest() {
        boolean expected = true;
        myTestRoom.visit();
        boolean actual = myTestRoom.hasBeenVisited();
        assertEquals("The room has not been visited.", expected, actual);
    }
}
