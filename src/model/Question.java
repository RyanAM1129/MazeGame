package model;

/**
 * A class representing a Question for a trivia game.
 */
public class Question {
    /**
     * A string containing the 'Question'.
     */
    private final String myQuestion;
    /**
     * A string containing the 'Answer'.
     */
    private final String myAnswer;

    /**
     * Constructor for Question using a given Question and Answer.
     * @param theQuestion the given question.
     * @param theAnswer the given answer.
     */
    public Question(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    /**
     * Returns the Question String.
     * @return the Question String.
     */
    public String getQuestion() {
        return myQuestion;
    }

    /**
     * Returns the Answer String.
     * @return the Answer String.
     */
    public String getAnswer() {
        return myAnswer;
    }

    /**
     * Checks if the given string is equal to myAnswer.
     * @return true if the strings match, false if they don't.
     */
    public boolean isCorrect(final String theGiven) {
        if(myAnswer == theGiven) {return true;}
        else{return false;}
    }
}
