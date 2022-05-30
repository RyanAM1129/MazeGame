package view;

import controller.Questionaire;
import model.Maze;
import model.Room;

import java.util.Scanner;

public class CLI {
    public static void mainDisplay(Maze theMaze) {
        Scanner myConsole = new Scanner(System.in);
        int myChoice;
        Room myLocation = theMaze.getCurrentLocation();
        System.out.println(theMaze);
        System.out.println("1. N\n2. W\n3. S\n4. E");
        myChoice = myConsole.nextInt();
        switch(myChoice){
            case 1:
                if (myLocation.getNorthDoor().getLockStatus()
                        && Questionaire.askQuestion(myLocation.getNorthDoor().getQuestion())) {
                    myLocation.getNorthDoor().unlock();
                    theMaze.moveNorth();
                }
                break;
            case 2:
                if (myLocation.getWestDoor().getLockStatus()
                        && Questionaire.askQuestion(myLocation.getWestDoor().getQuestion())) {
                    myLocation.getNorthDoor().unlock();
                    theMaze.moveWest();
                }
                break;
            case 3:
                if (myLocation.getSouthDoor().getLockStatus()
                        && Questionaire.askQuestion(myLocation.getSouthDoor().getQuestion())) {
                    myLocation.getNorthDoor().unlock();
                    theMaze.moveSouth();
                }
                break;
            case 4:
                if (myLocation.getEastDoor().getLockStatus()
                        && Questionaire.askQuestion(myLocation.getEastDoor().getQuestion())) {
                    myLocation.getNorthDoor().unlock();
                    theMaze.moveEast();
                }
                break;
        }
    }
}
