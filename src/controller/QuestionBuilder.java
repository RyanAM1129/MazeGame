package controller;

import model.MultipleChoice;
import model.NewQuestion;
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
    Stack<NewQuestion> myMultipleChoice;
    Stack<NewQuestion> myShortAnswer;
    Stack<NewQuestion> myTrueFalse;
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

    private Stack<NewQuestion> buildMultipleChoices() {
        final String query = "SELECT * FROM multiple_choice ORDER BY RANDOM() LIMIT " +
                myMultipleChoiceCount + ";";
        ResultSet myQuestionData;
        Stack<NewQuestion> myQuestionSet = new Stack<>();
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
                myQuestionSet.push(new NewQuestion(myQuestionString, (Stack<String>) myAnswers.clone()));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private Stack<NewQuestion> buildShortAnswers() {
        final String query = "SELECT * FROM short_answer ORDER BY RANDOM() LIMIT " +
                myMultipleChoiceCount + ";";
        ResultSet myQuestionData;
        Stack<NewQuestion> myQuestionSet = new Stack<>();
        String myQuestionString;
        Stack<String> myAnswers;
        try{
            myAnswers = new Stack<>();
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswers.push(myQuestionData.getString("ANSWER"));
                myQuestionSet.push(new NewQuestion(myQuestionString, (Stack<String>) myAnswers.clone()));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private Stack<NewQuestion> buildTrueFalse() {
        final String query = "SELECT * FROM true_false ORDER BY RANDOM() LIMIT " +
                myMultipleChoiceCount + ";";
        ResultSet myQuestionData;
        Stack<NewQuestion> myQuestionSet = new Stack<>();
        String myQuestionString;
        Stack<String> myAnswers;
        try{
            myAnswers = new Stack<>();
            myQuestionData = myStatement.executeQuery(query);
            while (myQuestionData.next()) {
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswers.push(myQuestionData.getString("ANSWER"));
                myQuestionSet.push(new NewQuestion(myQuestionString, (Stack<String>) myAnswers.clone()));
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    public NewQuestion getMultipleChoice() {
        if (myMultipleChoice.size() > 0) {
            return myMultipleChoice.pop();
        } else {
            return null;
        }
    }

    public NewQuestion getShortAnswer() {
        if (myShortAnswer.size() > 0) {
            return myShortAnswer.pop();
        } else {
            return null;
        }
    }

    public NewQuestion getTrueFalse() {
        if (myTrueFalse.size() > 0) {
            return myTrueFalse.pop();
        } else {
            return null;
        }
    }
}
