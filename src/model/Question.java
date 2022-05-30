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

    public Question(final String theQuestion, final Stack<String> theAnswer) {
        myQuestion = theQuestion;
        myCorrect = theAnswer.peek();
        myAnswer = (Stack<String>) theAnswer.clone();
        if(myAnswer.size() > 1) {
            MY_TYPE = QuestionType.MC;
        } else if (myCorrect.toLowerCase() == "true" || myCorrect.toLowerCase() == "false") {
            MY_TYPE = QuestionType.TF;
        } else {
            MY_TYPE = QuestionType.SA;
        }
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

    public QuestionType getType() {
        return MY_TYPE;
    }
}