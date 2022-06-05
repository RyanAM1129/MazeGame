package test;

import model.Door;
import model.Maze;
import model.Question;
import model.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link controller.MazeBuilder}.
 */
public class MazeBuilderTest {
    /**
     * Tests the MazeBuilder.buildRooms() method with a size of 5.
     * The method is being called inside the constructor of Maze.
     */
    @Test
    public void buildRooms5Test() {
        final Maze myTestMaze = new Maze(5);
        final Room myTestRoom = myTestMaze.getLocation(0, 3);
        final Door myTestDoor = myTestRoom.getSouthDoor();
        final Question myTestQuestion = myTestDoor.getQuestion();
        final String expected = "HorizontalQuestion (0, 3)";
        final String actual = myTestQuestion.getQuestion();
        assertEquals(expected + " doesn't equal " + actual, expected, actual);
    }
}
