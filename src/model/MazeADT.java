package model;

public class MazeADT<T> implements Maze{
    private T[][] myBoard;
    private int mySize;

    public MazeADT(int theSize) {
        mySize = theSize;
        myBoard = (T[][]) new Object[mySize][];
        for(int i = 0; i < mySize; i++) {
            myBoard[i] = (T[]) new Object[mySize];
        }
    }

    @Override
    public <T> T[][] getBoard() {
        return (T[][]) myBoard;
    }

    @Override
    public int getSize() {
        return mySize;
    }

    @Override
    public <T> T getLocation(int theRow, int theColumn) {
        return (T) myBoard[theRow][theColumn];
    }

    public void setLocation(int theRow, int theColumn, T theObject) {
        myBoard[theRow][theColumn] = theObject;
    }
}
