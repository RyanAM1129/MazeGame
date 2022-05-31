package test;

import model.Door;
import model.Maze;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazeTest {
    Maze testMaze = new Maze(5);

    @Test
    public void botEastDoorTest() {
        Door actual = testMaze.getLocation(4, 2).getEastDoor();
        assertEquals("It is not null!", null, actual);
    }
}
