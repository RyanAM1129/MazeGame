package view;

import model.Maze;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Woo go team!");
        Maze myMaze = new Maze(5);
        while(myMaze.getCurrentLocation().hasPath()) {
            CLI.mainDisplay(myMaze);
        }
    }
}
