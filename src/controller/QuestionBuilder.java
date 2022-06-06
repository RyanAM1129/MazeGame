package controller;

import model.Question;
import model.QuestionType;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Stack;

/**
 * Builds all the questions for a Maze and stores them in Stacks.
 */
public class QuestionBuilder {
    /**
     * The total number of questions for the Maze.
     */
    int myTotalQuestionCount;
    /**
     * The total number of Multiple Choice questions for the Maze.
     */
    int myMultipleChoiceCount;
    /**
     * The total number of Short Answer questions for the Maze.
     */
    int myShortAnswerCount;
    /**
     * The total number of True False questions for the Maze.
     */
    int myTrueFalseCount;
    /**
     * The stack of created Multiple Choice questions.
     */
    Stack<Question> myMultipleChoice;
    /**
     * The stack of created Short Answer questions.
     */
    Stack<Question> myShortAnswer;
    /**
     * The stack of created Short Answer questions.
     */
    Stack<Question> myTrueFalse;
    /**
     * The Question for the final exit.
     */
    Question myFinalQuestion;
    /**
     * The SQLite Data Source.
     */
    SQLiteDataSource myDataSource;
    /**
     * The SQLite connection.
     */
    Connection myConnection;
    /**
     * The SQLite statement.
     */
    Statement myStatement;

    /**
     * Constructor for QuestionBuilder that take a given number of total Questions.
     * @param theN the number of total Questions.
     */
    public QuestionBuilder(final int theN) {
        myTotalQuestionCount = theN;
        determineRatio();
        establishConnection("jdbc:sqlite:questions.db");
        myMultipleChoice = buildMultipleChoices();
        myShortAnswer = buildShortAnswers();
        myTrueFalse = buildTrueFalse();
    }

    /**
     * Establishes the connection with the SQLite database using a given URL.
     * @param theURL the given URL for the database.
     */
    private void establishConnection(final String theURL) {
        try {
            myDataSource = new SQLiteDataSource();
            myDataSource.setUrl(theURL);
            myConnection = myDataSource.getConnection();
            myStatement = myConnection.createStatement();
        } catch (Exception theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Determines the number of Multiple Choice, Short Answer and True False questions
     * using a ratio of 50%, 20%, and 30% respectively.
     */
    private void determineRatio() {
        myMultipleChoiceCount = myTotalQuestionCount / 2;
        myShortAnswerCount = myTotalQuestionCount / 5;
        myTrueFalseCount = myTotalQuestionCount -
                (myMultipleChoiceCount + myShortAnswerCount);
    }

    /**
     * Builds all the Multiple Choice Questions, puts them in a stack, and returns them.
     * @return the stack of Multiple Choice questions.
     */
    private Stack<Question> buildMultipleChoices() {
        final String query = "SELECT * FROM multiple_choice ORDER BY RANDOM() LIMIT " +
                myMultipleChoiceCount + ";";
        ResultSet myQuestionData;
        Stack<Question> myQuestionSet = new Stack<>();
        String myQuestionString;
        Stack<String> myAnswers;
        try{
            myAnswers = new Stack<>();
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswers.push(myQuestionData.getString("WRONG1"));
                myAnswers.push(myQuestionData.getString("WRONG2"));
                myAnswers.push(myQuestionData.getString("WRONG3"));
                myAnswers.push(myQuestionData.getString("ANSWER"));
                myQuestionSet.push(new Question(myQuestionString, (Stack<String>) myAnswers.clone(),
                        QuestionType.MC));
                myAnswers.clear();
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    /**
     * Builds all the Short Answer Questions, puts them in a stack, and returns them.
     * @return the stack of Short Answer questions.
     */
    private Stack<Question> buildShortAnswers() {
        final String query = "SELECT * FROM short_answer ORDER BY RANDOM() LIMIT " +
                (myShortAnswerCount + 1) + ";";
        ResultSet myQuestionData;
        Stack<Question> myQuestionSet = new Stack<>();
        String myQuestionString;
        Stack<String> myAnswers;
        try{
            myAnswers = new Stack<>();
            myQuestionData = myStatement.executeQuery(query);
            myQuestionData.next();
            myQuestionString = myQuestionData.getString("QUESTION");
            myAnswers.push(myQuestionData.getString("ANSWER"));
            myFinalQuestion = new Question(myQuestionString, myAnswers, QuestionType.SA);
            myAnswers.pop();
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswers.push(myQuestionData.getString("ANSWER"));
                myQuestionSet.push(new Question(myQuestionString, (Stack<String>) myAnswers.clone(),
                        QuestionType.SA));
                myAnswers.clear();
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    /**
     * Builds all the True False Questions, puts them in a stack, and returns them.
     * @return the stack of True False questions.
     */
    private Stack<Question> buildTrueFalse() {
        final String query = "SELECT * FROM true_false ORDER BY RANDOM() LIMIT " +
                myTrueFalseCount + ";";
        ResultSet myQuestionData;
        Stack<Question> myQuestionSet = new Stack<>();
        String myQuestionString;
        Stack<String> myAnswers;
        try{
            myAnswers = new Stack<>();
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswers.push(myQuestionData.getString("ANSWER"));
                myQuestionSet.push(new Question(myQuestionString, (Stack<String>) myAnswers.clone(),
                        QuestionType.TF));
                myAnswers.clear();
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    /**
     * Returns one Multiple Choice Question from the Stack of Multiple Choice Questions.
     * @return the top Question of the Multiple Choice Question stack.
     */
    public Question getMultipleChoice() {
        if (myMultipleChoice.size() > 0) {
            return myMultipleChoice.pop();
        } else {
            return null;
        }
    }

    /**
     * Returns one Short Answer Question from the Stack of Short Answer Questions.
     * @return the top Question of the Short Answer Question stack.
     */
    public Question getShortAnswer() {
        if (myShortAnswer.size() > 0) {
            return myShortAnswer.pop();
        } else {
            return null;
        }
    }

    /**
     * Returns one True False Questions from the Stack of True False Questions.
     * @return the top Question of the True False Question stack.
     */
    public Question getTrueFalse() {
        if (myTrueFalse.size() > 0) {
            return myTrueFalse.pop();
        } else {
            return null;
        }
    }

    /**
     * Returns a Question chosen randomly from the three different types.
     * @return the random question.
     */
    public Question getQuestion() {
        Random myRandom = new Random();
        int myRandomChoice = 1 + myRandom.nextInt(3);
        Question myQuestion = null;
        boolean tryAgain = true;
        while(tryAgain) {
            switch (myRandomChoice) {
                case 1:
                    if (!myMultipleChoice.isEmpty()) {
                        myQuestion = getMultipleChoice();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 2;
                    }
                case 2:
                    if (!myShortAnswer.isEmpty()) {
                        myQuestion = getShortAnswer();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 3;
                    }
                case 3:
                    if (!myTrueFalse.isEmpty()) {
                        myQuestion = getTrueFalse();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 1;
                    }
            }
        }
        return myQuestion;
    }

    /**
     * Returns the Question for the exit.
     * @return the exit Question.
     */
    public Question getFinalQuestion() {
        return myFinalQuestion;
    }
}
