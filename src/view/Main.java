package view;

import model.Game;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Woo go team!");
        //runCLI();
        runGUI();
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

    private static void runGUI() {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainMenu menu = new MainMenu();
                    menu.getStartMenu().setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
