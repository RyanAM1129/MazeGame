package view;

import model.Maze;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Woo go team!");
        Maze myMaze = new Maze(5);
        while(myMaze.getHealth() > 0) {
            CLI.mainDisplay(myMaze);
        }
        System.out.println("You have lost all your lives, the game is over.");
    }
}
