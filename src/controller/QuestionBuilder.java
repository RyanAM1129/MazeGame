package controller;

import model.MultipleChoice;
import model.Question;
import model.TrueFalse;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class QuestionBuilder {
    int myTotalQuestionCount;
    int myMultipleChoiceCount;
    int myShortAnswerCount;
    int myTrueFalseCount;
    Stack<MultipleChoice> myMultipleChoice;
    Stack<Question> myShortAnswer;
    Stack<TrueFalse> myTrueFalse;
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public QuestionBuilder(final int theN) {
        myTotalQuestionCount = theN;
        determineRatio();
        establishConnection("jdbc:sqlite:questions.db");
        myMultipleChoice = buildMultipleChoices();
        myShortAnswer = buildShortAnswers();
        myTrueFalse = buildTrueFalse();
    }

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

    private void determineRatio() {
        myMultipleChoiceCount = myTotalQuestionCount / 2;
        myShortAnswerCount = myTotalQuestionCount / 5;
        myTrueFalseCount = myTotalQuestionCount -
                (myMultipleChoiceCount + myShortAnswerCount);
    }

    private Stack<MultipleChoice> buildMultipleChoices() {
        final String query = "SELECT * FROM multiple_choice ORDER BY RANDOM() LIMIT " +
                myMultipleChoiceCount + ";";
        ResultSet myQuestionData;
        Stack<MultipleChoice> myQuestionSet = new Stack<>();
        String myQuestionString;
        String myAnswerString;
        String myWrong1;
        String myWrong2;
        String myWrong3;
        int myIndex = 0;
        try{
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswerString = myQuestionData.getString("ANSWER");
                myWrong1 = myQuestionData.getString("WRONG1");
                myWrong2 = myQuestionData.getString("WRONG2");
                myWrong3 = myQuestionData.getString("WRONG3");
                myQuestionSet.push(new MultipleChoice(myQuestionString, myAnswerString,
                        myWrong1, myWrong2, myWrong3));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private Stack<Question> buildShortAnswers() {
        final String query = "SELECT * FROM short_answer ORDER BY RANDOM() LIMIT " +
                myShortAnswerCount + ";";
        ResultSet myQuestionData;
        Stack<Question> myQuestionSet = new Stack<>();
        String myQuestionString;
        String myAnswerString;
        int myIndex = 0;
        try{
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswerString = myQuestionData.getString("ANSWER");
                myQuestionSet.push(new Question(myQuestionString, myAnswerString));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private Stack<TrueFalse> buildTrueFalse() {
        final String query = "SELECT * FROM true_false ORDER BY RANDOM() LIMIT " +
                myTrueFalseCount + ";";
        ResultSet myQuestionData;
        Stack<TrueFalse> myQuestionSet = new Stack<>();
        String myQuestionString;
        String myAnswerString;
        int myIndex = 0;
        try{
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswerString = myQuestionData.getString("ANSWER");
                myQuestionSet.push(new TrueFalse(myQuestionString, myAnswerString));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    public MultipleChoice getMultipleChoice() {
        if (myMultipleChoice.size() > 0) {
            return myMultipleChoice.pop();
        } else {
            return null;
        }
    }

    public Question getShortAnswer() {
        if (myShortAnswer.size() > 0) {
            return myShortAnswer.pop();
        } else {
            return null;
        }
    }

    public TrueFalse getTrueFalse() {
        if (myTrueFalse.size() > 0) {
            return myTrueFalse.pop();
        } else {
            return null;
        }
    }
}
