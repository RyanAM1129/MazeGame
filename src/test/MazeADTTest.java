package test;

import model.MazeADT;
import org.junit.Assert;
import org.junit.Test;

public class MazeADTTest {

    /**
     * A test checking the setLocation method if you wanted boolean false.
     */
    @Test
    public void setLocationTestFalse() {
        MazeADT booMaze = new MazeADT<Boolean>(5);
        boolean expected = false;
        booMaze.setLocation(0, 0, false);
        boolean actual = (boolean) booMaze.getLocation(0, 0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * A test checking getBoard() method.
     */
    @Test
    public void getBoardTest() {
        boolean[][] expected = new boolean[2][2];
        MazeADT booBoard = new MazeADT<Boolean>(2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                booBoard.setLocation(i, j, false);
            }
        }
        Object[][] actual = booBoard.getBoard();
        Assert.assertEquals(expected, actual);
    }
}
