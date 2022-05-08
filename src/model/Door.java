package model;

public class Door {
    private Question myQuestion;
    private boolean myLockStatus;

    public Door(Question theQuestion) {
        myLockStatus = true;
        myQuestion = theQuestion;
    }

    public Question getQuestion() {
        return myQuestion;
    }

    public boolean getLockStatus() {
        return myLockStatus;
    }

    public void unlock() {
        myLockStatus = false;
    }
}