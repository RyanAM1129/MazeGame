package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Room Class.
 */
public class RoomTest {
    /**
     * The Room used for testing.
     */
    Room myTestRoom;
    /**
     * The north Door used for testing.
     */
    Door myTestNorthDoor;
    /**
     * The west Door used for testing.
     */
    Door myTestWestDoor;
    /**
     * The south Door used for testing.
     */
    Door myTestSouthDoor;
    /**
     * The east Door used for testing.
     */
    Door myTestEastDoor;

    /**
     * Initializes the Room.
     * Makes the question for every door "Does java support OOP?".
     * Makes the answer for every door "yes".
     * Makes north and south Doors horizontal Doors.
     * Makes west and east Doors vertical Doors.
     * Makes the Room an Interior RoomType.
     */
    @Before
    public void init() {
        Stack<String> myTestAnswers = new Stack<>();
        myTestAnswers.push("yes");
        Question myTestQuestion = new Question("Does java support OOP?", myTestAnswers,
                QuestionType.SA);
        myTestNorthDoor = new Door(myTestQuestion, DoorType.HORIZONTAL);
        myTestWestDoor = new Door(myTestQuestion, DoorType.VERTICAL);
        myTestSouthDoor = new Door(myTestQuestion, DoorType.HORIZONTAL);
        myTestEastDoor = new Door(myTestQuestion, DoorType.VERTICAL);
        myTestRoom = new Room(myTestNorthDoor, myTestWestDoor, myTestSouthDoor, myTestEastDoor,
                RoomType.INTERIOR);
    }

    /**
     * Tests the getNorthDoor() method.
     */
    @Test
    public void getNorthDoorTest() {
        Door expected = myTestNorthDoor;
        Door actual = myTestRoom.getNorthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getWestDoor() method.
     */
    @Test
    public void getWestDoorTest() {
        Door expected = myTestWestDoor;
        Door actual = myTestRoom.getWestDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getSouthDoor() method.
     */
    @Test
    public void getSouthDoorTest() {
        Door expected = myTestSouthDoor;
        Door actual = myTestRoom.getSouthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getEastDoor() method.
     */
    @Test
    public void getEastDoorTest() {
        Door expected = myTestEastDoor;
        Door actual = myTestRoom.getEastDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    /**
     * Tests the getType() method.
     */
    @Test
    public void getTypeTest() {
        RoomType expected = RoomType.INTERIOR;
        RoomType actual = myTestRoom.getType();
        assertEquals("The RoomTypes do not equal.", expected, actual);
    }

    /**
     * Tests the hasBeenVisited() method with a false result.
     */
    @Test
    public void hasBeenVisitedFalseTest() {
        boolean expected = false;
        boolean actual = myTestRoom.hasBeenVisited();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    /**
     * Tests the visit() method.
     */
    @Test
    public void visitTest() {
        boolean expected = !myTestRoom.hasBeenVisited();
        myTestRoom.visit();
        boolean actual = myTestRoom.hasBeenVisited();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    /**
     * Tests the toString() method for an unvisited room.
     */
    @Test
    public void toStringTest1() {
        String expected = "?";
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    /**
     * Tests the toString() method for a visited room.
     */
    @Test
    public void toStringTest2() {
        String expected = "V";
        myTestRoom.visit();
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    /**
     * Tests the toString() method for an exit.
     */
    @Test
    public void toStringTest3() {
        String expected = "X";
        myTestRoom = new Room(myTestNorthDoor, myTestWestDoor, myTestSouthDoor, myTestEastDoor,
                RoomType.BOT_RIGHT);
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }
}
