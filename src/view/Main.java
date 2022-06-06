package view;

import model.Game;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Woo go team!");
        runCLI();
    }

    private static void runCLI() {
        Game myGame = new Game(5);
        while(!myGame.isMyGameOver()) {
            CLI.mainDisplay(myGame);
        }
        if (myGame.isMyGameWon()) {
            System.out.println("You have won! Congratulations!");
        } else {
            System.out.println("You have lost. Try again!");
        }
    }
}
