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

public class QuestionBuilder {
    int myTotalQuestionCount;
    int myMultipleChoiceCount;
    int myShortAnswerCount;
    int myTrueFalseCount;
    Stack<Question> myMultipleChoice;
    Stack<Question> myShortAnswer;
    Stack<Question> myTrueFalse;
    Question myFinalQuestion;
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public QuestionBuilder(final int theN) {
        //Add one to account for the "final answer".
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

    public Question getMultipleChoice() {
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

    public Question getTrueFalse() {
        if (myTrueFalse.size() > 0) {
            return myTrueFalse.pop();
        } else {
            return null;
        }
    }

    public Question getQuestion() {
        Random myRandom = new Random();
        int myRandomChoice = 1 + myRandom.nextInt(3);
        Question myQuestion = null;
        boolean tryAgain = true;
        while(tryAgain) {
            switch (myRandomChoice) {
                case 1:
                    if (!myMultipleChoice.isEmpty()) {
                        myQuestion = myMultipleChoice.pop();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 2;
                    }
                case 2:
                    if (!myShortAnswer.isEmpty()) {
                        myQuestion = myShortAnswer.pop();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 3;
                    }
                case 3:
                    if (!myTrueFalse.isEmpty()) {
                        myQuestion = myTrueFalse.pop();
                        tryAgain = false;
                        break;
                    } else {
                        myRandomChoice = 1;
                    }
            }
        }
        return myQuestion;
    }

    public Question getFinalQuestion() {
        return myFinalQuestion;
    }
}
