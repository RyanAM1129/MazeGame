package test;

import model.Maze;
import model.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazeTest {
    Maze myTestMaze;

    @Before
    public void init() {
        myTestMaze = new Maze(3);
    }

    @Test
    public void getCurrentLocationTest1() {
        myTestMaze = new Maze(3, 0, 1);
        Room expected = myTestMaze.getLocation(0, 1);
        Room actual = myTestMaze.getCurrentLocation();
        assertEquals("The Rooms do not equal!", expected, actual);
    }

    @Test
    public void getCurrentLocationTest2() {
        myTestMaze = new Maze(3, 2, 2);
        Room expected = myTestMaze.getLocation(2, 2);
        Room actual = myTestMaze.getCurrentLocation();
        assertEquals("The Rooms do not equal!", expected, actual);
    }

    @Test
    public void getCurrentLocationTest3() {
        myTestMaze = new Maze(3, 1, 1);
        Room expected = myTestMaze.getLocation(1, 1);
        Room actual = myTestMaze.getCurrentLocation();
        assertEquals("The Rooms do not equal!", expected, actual);
    }

    @Test
    public void getCurrentLocationTest4() {
        Room expected = myTestMaze.getLocation(0, 0);
        Room actual = myTestMaze.getCurrentLocation();
        assertEquals("The Rooms do not equal!", expected, actual);
    }

    @Test
    public void toStringTest1() {
        String expected = ".=====.\n]0|?|?[\n]-+-+-[\n]?|?|?[\n]-+-+-[\n]?|?|X[\n'====='";
        String actual = myTestMaze.toString();
        assertEquals("The Strings do not equal!", expected, actual);
    }

    @Test
    public void toStringTest2() {
        String expected = ".=====.\n]0|?|?[\n]-+-+-[\n]?|V|?[\n]-+-+-[\n]?|?|X[\n'====='";
        myTestMaze.getLocation(1, 1).visit();
        myTestMaze.getLocation(2, 2).visit();
        String actual = myTestMaze.toString();
        assertEquals("The Strings do not equal!", expected, actual);
    }

    @Test
    public void toStringTest3() {
        myTestMaze = new Maze(3, 1, 1);
        String expected = ".=====.\n]?|?|?[\n]-+-+-[\n]?|0|?[\n]-+-+-[\n]?|?|X[\n'====='";
        String actual = myTestMaze.toString();
        assertEquals("The Strings do not equal!", expected, actual);
    }

    @Test
    public void toStringTest4() {
        myTestMaze = new Maze(5);
        String expected = ".=========.\n]0|?|?|?|?["
                + "\n]-+-+-+-+-[\n]?|?|?|?|?["
                + "\n]-+-+-+-+-[\n]?|?|?|?|?["
                + "\n]-+-+-+-+-[\n]?|?|?|?|?["
                + "\n]-+-+-+-+-[\n]?|?|?|?|X["
                + "\n'========='";
        String actual = myTestMaze.toString();
        assertEquals("The Strings do not equal!", expected, actual);
    }
}
