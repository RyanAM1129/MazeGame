package view;

import controller.Questionnaire;
import controller.Validator;
import model.Game;
import model.Maze;
import model.Room;
import model.RoomType;

import java.util.Scanner;

/**
 * Displays the maze game on a Command Line Interface.
 */
public class CLI {
    /**
     * Displays the main features (maze, controls, etc. of the CLI.
     * @param theGame the given game.
     */
    public static void mainDisplay(Game theGame) {
        Scanner myConsole = new Scanner(System.in);
        int myChoice;
        Room myLocation = theGame.getCurrentLocation();
        System.out.println(theGame);
        System.out.println("Remaining wrong answers: " + theGame.getHealth() + "\n");
        displayMoveOptions(myLocation.getType());
        myChoice = myConsole.nextInt();
        while(!Validator.numberInRange(myLocation.getType(), myChoice)) {
            displayMoveOptions(myLocation.getType());
            myChoice = myConsole.nextInt();
        }
        switch(myChoice){
            case 1:
                if (Questionnaire.askQuestion(myLocation.getNorthDoor().getQuestion())) {
                    theGame.moveNorth();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theGame.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 2:
                if (Questionnaire.askQuestion(myLocation.getWestDoor().getQuestion())) {
                    theGame.moveWest();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theGame.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 3:
                if (Questionnaire.askQuestion(myLocation.getSouthDoor().getQuestion())) {
                    theGame.moveSouth();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theGame.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 4:
                if (Questionnaire.askQuestion(myLocation.getEastDoor().getQuestion())) {
                    theGame.moveEast();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theGame.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
        }
    }

    private static void displayMoveOptions(final RoomType theType) {
        System.out.println("Please enter the number of your desired direction: ");
        switch (theType) {
            case TOP:
                System.out.println("2. W\n3. S\n4. E");
                break;
            case TOP_LEFT:
                System.out.println("3. S\n4. E");
                break;
            case LEFT:
                System.out.println("1. N\n3. S\n4. E");
                break;
            case BOT_LEFT:
                System.out.println("1. N\n4. E");
                break;
            case BOT:
                System.out.println("1. N\n2. W\n4. E");
                break;
            case BOT_RIGHT:
                System.out.println("1. N\n2. W\n4. Exit");
                break;
            case RIGHT:
                System.out.println("1. N\n2. W\n3. S");
                break;
            case TOP_RIGHT:
                System.out.println("2. W\n3. S");
                break;
            case INTERIOR:
                System.out.println("1. N\n2. W\n3. S\n4. E");
        }
    }

    private static void displayIncorrectAnswer() {
        System.out.println("!!!Sorry but the answer was incorrect!!!");
        //System.out.println("Press enter to continue...");
    }

    private static void displayCorrectAnswer() {
        System.out.println("Yay, that answer was correct!");
        //System.out.println("Press enter to continue...");
    }
}
