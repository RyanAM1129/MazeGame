package view;

import model.Game;

import java.awt.*;

public class Main
{
    /**
     * In this Main, the GUI or CLI can be run simply
     * by commenting and uncommenting which one you
     * would want to run.
     */
    public static void main(String[] args)
    {
        //runCLI();
        runGUI();
    }

    /**
     * This method runs the CLI for the Java Trivia Maze Game.
     */
    private static void runCLI()
    {
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

    /**
     * This method runs the GUI for the Java Trivia Maze game.
     */
    private static void runGUI()
    {
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
