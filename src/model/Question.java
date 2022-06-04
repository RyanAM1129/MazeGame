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
    private final QuestionType MY_TYPE;

    private final Stack<String> myAnswer;

    public Question(final String theQuestion, final Stack<String> theAnswer, final QuestionType theType) {
        myQuestion = theQuestion;
        myCorrect = theAnswer.peek();
        myAnswer = (Stack<String>) theAnswer.clone();
        MY_TYPE = theType;
    }

    public Stack<String> getAnswer() {
        return (Stack<String>) myAnswer.clone();
    }

    public String getQuestion() {
        return myQuestion;
    }

    public boolean isCorrect(final String theAnswer) {
        if(MY_TYPE == QuestionType.TF) {
            return myCorrect.strip().equalsIgnoreCase(theAnswer.strip());
        } else {
            return myCorrect.equals(theAnswer);
        }
    }

    public QuestionType getType() {
        return MY_TYPE;
    }
}