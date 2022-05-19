package model;

/**
 * A class representing a Multiple Choice Question.
 */
public class MultipleChoice extends Question {
    /**
     * An array storing the three wrong answers.
     * Should never be larger than 3.
     */
    private final String[] myWrong;
    /**
     * A String representing the type of question.
     */
    final static String myType = "MC";

    /**
     * Constructor that receives three String Literals as parameters
     * for the Wrong Answers.
     *
     * @param theQuestion the Question String.
     * @param theAnswer the Answer String.
     * @param theWrong1 the first Wrong Answer String.
     * @param theWrong2 the second Wrong Answer String.
     * @param theWrong3 the third Wrong Answer String.
     */
    public MultipleChoice(final String theQuestion, final String theAnswer,
                          final String theWrong1, final String theWrong2,
                          final String theWrong3) {
        super(theQuestion, theAnswer);
        myWrong = new String[] {theWrong1, theWrong2, theWrong3};
    }

    /**
     * Constructor that receives an array of Strings as parameters
     * for the Wrong Answers.
     *
     * @param theQuestion the Question String.
     * @param theAnswer the Answer String.
     * @param theWrong the array of Wrong Answer Strings.
     */
    public MultipleChoice(final String theQuestion, final String theAnswer,
                          final String[] theWrong) {
        super(theQuestion, theAnswer);
        myWrong = theWrong.clone();
    }

    /**
     * Returns all the wrong answers as an array.
     * @return the array of Wrong Answers.
     */
    public String[] getWrongSet() {
        return myWrong.clone();
    }

    /**
     * Returns the Wrong Answer at a given index.
     * @param index the index of the Wrong Answer.
     * @return the Wrong Answer at index 'index'.
     */
    public String getWrong(final int index) {
        return myWrong[index];
    }
}
