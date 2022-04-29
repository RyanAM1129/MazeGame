package model;

public interface Maze {
    <T> T[][] getBoard();
    int getSize();
    <T> T getLocation(int theRow, int theColumn);
}
