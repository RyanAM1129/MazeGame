package controller;

import model.RoomType;

public class Validator {
    public static boolean numberInRange(final RoomType theType, final int theNumber) {
        int[] myAcceptable = new int[0];
        switch (theType) {
            case TOP:
                myAcceptable = new int[] {2, 3, 4};
                break;
            case TOP_LEFT:
                myAcceptable = new int[] {3, 4};
                break;
            case LEFT:
                myAcceptable = new int[] {1, 3, 4};
                break;
            case BOT_LEFT:
                myAcceptable = new int[] {1, 4};
                break;
            case BOT:
                myAcceptable = new int[] {1, 2, 4};
                break;
            case BOT_RIGHT:
                myAcceptable = new int[] {1, 2, 4};
                break;
            case RIGHT:
                myAcceptable = new int[] {1, 2, 3};
                break;
            case TOP_RIGHT:
                myAcceptable = new int[] {2, 3};
                break;
            case INTERIOR:
                myAcceptable = new int[] {1, 2, 3, 4};
        }
        for(int number : myAcceptable){
            if (theNumber == number) {
                return true;
            }
        }
        return false;
    }
}
