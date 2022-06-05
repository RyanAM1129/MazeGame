package model;

public class Door {
    private Question myQuestion;
    private DoorType myType;

    public Door(Question theQuestion, DoorType theType) {
        myQuestion = theQuestion;
        myType = theType;
    }

    public Question getQuestion() {
        return myQuestion;
    }

    public String toString() {
        String myStr = "|";
        if(myType == DoorType.HORIZONTAL) {
            myStr = "-";
        }
        return myStr;
    }
}