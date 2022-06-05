package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room myTestRoom;
    Door myTestNorthDoor;
    Door myTestWestDoor;
    Door myTestSouthDoor;
    Door myTestEastDoor;

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

    @Test
    public void getNorthDoorTest() {
        Door expected = myTestNorthDoor;
        Door actual = myTestRoom.getNorthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    @Test
    public void getWestDoorTest() {
        Door expected = myTestWestDoor;
        Door actual = myTestRoom.getWestDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    @Test
    public void getSouthDoorTest() {
        Door expected = myTestSouthDoor;
        Door actual = myTestRoom.getSouthDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    @Test
    public void getEastDoorTest() {
        Door expected = myTestEastDoor;
        Door actual = myTestRoom.getEastDoor();
        assertEquals("The Doors do not equal.", expected, actual);
    }

    @Test
    public void getTypeTest() {
        RoomType expected = RoomType.INTERIOR;
        RoomType actual = myTestRoom.getType();
        assertEquals("The RoomTypes do not equal.", expected, actual);
    }

    @Test
    public void hasBeenVisitedTest() {
        boolean expected = false;
        boolean actual = myTestRoom.hasBeenVisited();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    @Test
    public void visitTest() {
        boolean expected = true;
        myTestRoom.visit();
        boolean actual = myTestRoom.hasBeenVisited();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    @Test
    public void toStringTest1() {
        String expected = "?";
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    @Test
    public void toStringTest2() {
        String expected = "V";
        myTestRoom.visit();
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }

    @Test
    public void toStringTest3() {
        String expected = "X";
        myTestRoom = new Room(myTestNorthDoor, myTestWestDoor, myTestSouthDoor, myTestEastDoor,
                RoomType.BOT_RIGHT);
        String actual = myTestRoom.toString();
        assertEquals("The method returned the wrong answer.", expected, actual);
    }
}
