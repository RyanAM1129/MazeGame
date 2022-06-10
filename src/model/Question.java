package model;

import java.util.Stack;

public class Question {
    /**
     * A string containing the 'Question'.
     */
    private final String myQuestion;
    /**
     * A string containing the 'Answer'.
     */
    private final String myCorrect;
    /**
     * The type of Question.
     */
    private final QuestionType myType;

    /**
     * The Stack of answer Strings.
     */
    private final Stack<String> myAnswer;

    /**
     * Constructor using given Question String, Stack of answer Strings, and {@link QuestionType}.
     */
    public Question(final String theQuestion, final Stack<String> theAnswer, final QuestionType theType) {
        myQuestion = theQuestion;
        myCorrect = theAnswer.peek();
        myAnswer = (Stack<String>) theAnswer.clone();
        myType = theType;
    }

    /**
     * Gets the Stack of answer Strings.
     * @return a Stack of all the answer Strings.
     */
    public Stack<String> getAnswer() {
        return (Stack<String>) myAnswer.clone();
    }

    /**
     * Gets the question String.
     * @return the question String.
     */
    public String getQuestion() {
        return myQuestion;
    }

    /**
     * Checks if a given String is the same as the Correct Answer String and returns
     * true if it is and false if it isn't.
     * @param theAnswer the given answer to be checked.
     * @return true if the strings match, false if they don't.
     */
    public boolean isCorrect(final String theAnswer) {
        if(myType == QuestionType.TF) {
            return myCorrect.strip().equalsIgnoreCase(theAnswer.strip());
        } else {
            return myCorrect.equals(theAnswer);
        }
    }

    /**
     * Gets the type of Question as a {@link QuestionType}.
     * @return the {@link QuestionType}.
     */
    public QuestionType getType() {
        return myType;
    }
}