package model;

/**
 * An ADT representing a Door in a Trivia Maze Game.
 * Stores the Question and type of Door.
 */
public class Door {
    /**
     * The Question used for the Door.
     * Should be asked everytime the door is traversed.
     */
    private Question myQuestion;
    /**
     * The type of Door.
     * The possible types of Door are {@link DoorType}.
     */
    private DoorType myType;

    /**
     * Constructor for a Door that uses a given Question and {@link DoorType}.
     * @param theQuestion the given Question for the door. Can be any {@link QuestionType}.
     * @param theType the given {@link DoorType}.
     */
    public Door(Question theQuestion, DoorType theType) {
        myQuestion = theQuestion;
        myType = theType;
    }

    /**
     * Returns the {@link Question} of the Door.
     * @return the Doors {@link Question}.
     */
    public Question getQuestion() {
        return myQuestion;
    }

    /**
     * Returns a String representation of the Door.
     * @return "|" for a Vertical door and "-" for a Horizontal door.
     */
    @Override
    public String toString() {
        String myStr = "|";
        if(myType == DoorType.HORIZONTAL) {
            myStr = "-";
        }
        return myStr;
    }
}