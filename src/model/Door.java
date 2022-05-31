package model;

public class Door {
    private Question myQuestion;
    private DoorType myType;
    private boolean myLockStatus;

    public Door(Question theQuestion, DoorType theType) {
        myLockStatus = true;
        myQuestion = theQuestion;
        myType = theType;
    }

    public Question getQuestion() {
        return myQuestion;
    }

    public DoorType getType() {
        return myType;
    }

    public boolean getLockStatus() {
        return myLockStatus;
    }

    public void unlock() {
        myLockStatus = false;
    }

    public String toString() {
        String myStr = "|";
        if(myType == DoorType.VERTICAL && !myLockStatus) {
            myStr = "/";
        } else if(myType == DoorType.HORIZONTAL && myLockStatus) {
            myStr = "=";
        } else if(myType == DoorType.HORIZONTAL) {
            myStr = "-";
        }
        return myStr;
    }
}