package controller;

import model.MultipleChoice;
import model.Question;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionBuilder {
    int myTotalQuestionCount;
    int myShortAnswerCount;
    int myMultipleChoiceCount;
    Question[] myShortAnswer;
    MultipleChoice[] myMultipleChoice;
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public QuestionBuilder(final int theN) {
        myTotalQuestionCount = theN;
        //Need to know how many short answer questions we want
        determineRatio(80);
        //Need to decide how to organize DataBase.
        establishConnection("jdbc:sqlite:questions.db");
        //Need to decide name of database
        myShortAnswer = buildShortAnswers();
        myMultipleChoice = buildMultipleChoices();
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
    private Question[] buildShortAnswers() {
        final String query = "SELECT * FROM short_answer ORDER BY RANDOM() LIMIT 1;";
        ResultSet myQuestionData;
        Question[] myQuestionSet = new Question[myShortAnswerCount];
        String myQuestionString;
        String myAnswerString;
        int myIndex = 0;
        try{
            myQuestionData = myStatement.executeQuery(query);
            for (int i = 0; i < myTotalQuestionCount; i++) {
                myQuestionData.next();
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswerString = myQuestionData.getString("ANSWER");
                myQuestionSet[i] = new Question(myQuestionString, myAnswerString);
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private MultipleChoice[] buildMultipleChoices() {
        final String query = "SELECT * FROM multiple_choice ORDER BY RANDOM() LIMIT 1;";
        ResultSet myQuestionData;
        MultipleChoice[] myQuestionSet = new MultipleChoice[myMultipleChoiceCount];
        String myQuestionString;
        String myAnswerString;
        String myWrong1;
        String myWrong2;
        String myWrong3;
        int myIndex = 0;
        try{
            myQuestionData = myStatement.executeQuery(query);
            for (int i = 0; i < myTotalQuestionCount; i++) {
                myQuestionData.next();
                myQuestionString = myQuestionData.getString("QUESTION");
                myAnswerString = myQuestionData.getString("ANSWER");
                myWrong1 = myQuestionData.getString("WRONG1");
                myWrong2 = myQuestionData.getString("WRONG2");
                myWrong3 = myQuestionData.getString("WRONG3");
                myQuestionSet[i] = new MultipleChoice(myQuestionString, myAnswerString,
                        myWrong1, myWrong2, myWrong3);
            }
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
        return myQuestionSet;
    }

    private void determineRatio(final int thePercent) {
        final double theScalar = thePercent / 100;
        myShortAnswerCount = (int) (myTotalQuestionCount * theScalar);
        myMultipleChoiceCount = myTotalQuestionCount - myShortAnswerCount;
    }

    public Question getShortAnswer(final int theIndex) {
        return myShortAnswer[theIndex];
    }

    public MultipleChoice getMultipleChoice(final int theIndex) {
        return myMultipleChoice[theIndex];
    }
}
