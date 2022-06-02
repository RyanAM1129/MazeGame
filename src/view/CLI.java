package view;

import controller.Questionnaire;
import controller.Validator;
import model.Maze;
import model.Room;
import model.RoomType;

import java.util.Scanner;

public class CLI {
    public static void mainDisplay(Maze theMaze) {
        Scanner myConsole = new Scanner(System.in);
        int myChoice;
        Room myLocation = theMaze.getCurrentLocation();
        System.out.println(theMaze);
        System.out.println("Remaining wrong answers: " + theMaze.getHealth() + "\n");
        displayMoveOptions(myLocation.getType());
        myChoice = myConsole.nextInt();
        while(!Validator.numberInRange(myLocation.getType(), myChoice)) {
            displayMoveOptions(myLocation.getType());
            myChoice = myConsole.nextInt();
        }
        switch(myChoice){
            case 1:
                if (Questionnaire.askQuestion(myLocation.getNorthDoor().getQuestion())) {
                    theMaze.moveNorth();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theMaze.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 2:
                if (Questionnaire.askQuestion(myLocation.getWestDoor().getQuestion())) {
                    theMaze.moveWest();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theMaze.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 3:
                if (Questionnaire.askQuestion(myLocation.getSouthDoor().getQuestion())) {
                    theMaze.moveSouth();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theMaze.minusHealth();
                    displayIncorrectAnswer();
                    //myConsole.nextLine();
                }
                break;
            case 4:
                if (Questionnaire.askQuestion(myLocation.getEastDoor().getQuestion())) {
                    theMaze.moveEast();
                    displayCorrectAnswer();
                    //myConsole.nextLine();
                } else {
                    theMaze.minusHealth();
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
                System.out.println("1. N\n2. W\n4. E");
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
