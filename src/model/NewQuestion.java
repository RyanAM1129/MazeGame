package model;

import java.util.Stack;

public class NewQuestion {
    /**
     * A string containing the 'Question'.
     */
    private final String myQuestion;
    /**
     * A string containing the 'Answer'.
     */
    private final String myCorrect;
    private final Stack<String> myAnswer;

    public NewQuestion(final String theQuestion, final Stack<String> theAnswer) {
        myQuestion = theQuestion;
        myCorrect = theAnswer.peek();
        myAnswer = (Stack<String>) theAnswer.clone();
    }

    public Stack<String> getAnswer() {
        return (Stack<String>) myAnswer.clone();
    }

    public String getQuestion() {
        return myQuestion;
    }

    public boolean isCorrect(final String theAnswer) {
        return myCorrect.equals(theAnswer);
    }
}
